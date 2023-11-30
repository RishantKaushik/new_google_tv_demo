package com.example.myapplication;


import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.example.myapplication.Auth.PacketEncoder;
import com.example.myapplication.Auth.PacketParser;
import com.example.myapplication.Keystore.AsyncKeystore;
import com.example.myapplication.Keystore.KeyStoreManager;
import com.example.myapplication.RemoteLib.RemoteProto$DeviceInfo;
import com.example.myapplication.RemoteLib.RemoteProto_AppInfo;
import com.example.myapplication.RemoteLib.RemoteProto_Configure;
import com.example.myapplication.RemoteLib.RemoteProto_KeyInject;
import com.example.myapplication.RemoteLib.RemoteProto_PingResponse;
import com.example.myapplication.RemoteLib.RemoteProto_RemoteMessage;
import com.example.myapplication.RemoteLib.RemoteProto_SetActive;
import com.example.myapplication.RemoteLib.RemoteProto_TextFieldStatus;
import com.example.myapplication.RemoteLib.RemoteProto_VoiceBegin;
import com.example.myapplication.RemoteLib.RemoteProto_VoiceConfig;
import com.example.myapplication.RemoteLib.RemoteProto_VoiceEnd;
import com.google.polo.pairing.ClientPairingSession;
import com.google.polo.pairing.PairingContext;
import com.google.polo.pairing.PairingListener;
import com.google.polo.pairing.PairingSession;
import com.google.polo.pairing.message.EncodingOption;
import com.google.polo.ssl.DummySSLSocketFactory;
import com.google.polo.wire.WireFormat;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;

/* loaded from: classes2.dex */
public class AndroidTVManager {
    public static Context context;
    public static volatile AndroidTVManager instance;
    public HandlerThread connectionThread;
    public String deviceIp;
    public int devicePort;
    public KeyStoreManager keyStoreManager;
    public ConnectionListener listener;
    public InputStream mInputStream;
    public Thread mListeningThread;
    public OutputStream mOutputStream;
    public PairingThread mPairingThread;
    public WifiManager.WifiLock mWifiLock;
    public Handler mainHandler;
    public PacketEncoder packetEncoder;
    public SSLSocket sslsock;
    public boolean isNewAndroidTV = false;
    public boolean isConnecting = false;
    public boolean needsReconnect = false;
    public RemoteProto_AppInfo textFieldAppInfo = null;
    public RemoteProto_TextFieldStatus textFieldStatus = null;
    public final Runnable mSocketListener = new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.1
        @Override // java.lang.Runnable
        public void run() {
            AndroidTVManager.this.mWifiLock.acquire();
            while (AndroidTVManager.this.sslsock != null && (AndroidTVManager.this.sslsock == null || AndroidTVManager.this.sslsock.isConnected())) {
                if (AndroidTVManager.this.isNewAndroidTV) {
                    while (true) {
                        try {
                            RemoteProto_RemoteMessage parseDelimitedFrom = RemoteProto_RemoteMessage.parseDelimitedFrom(AndroidTVManager.this.mInputStream);
                            if (parseDelimitedFrom != null) {
                                if (parseDelimitedFrom.getRequestCase().getNumber() == 1) {
                                    AndroidTVManager.this.sendConfigurationNew(parseDelimitedFrom.getConfigure().getCode());
                                } else if (parseDelimitedFrom.getRequestCase().getNumber() == 2) {
                                    AndroidTVManager.this.sendActive();
                                } else if (parseDelimitedFrom.getRequestCase().getNumber() == 8) {
                                    AndroidTVManager.this.sendPing(parseDelimitedFrom.getPingRequest().getVal1());
                                } else if (parseDelimitedFrom.getRequestCase().getNumber() == 20) {
                                    if (parseDelimitedFrom.getImeKeyInject().hasTextFieldStatus()) {
                                        AndroidTVManager.this.textFieldStatus = parseDelimitedFrom.getImeKeyInject().getTextFieldStatus();
                                    }
                                    if (parseDelimitedFrom.getImeKeyInject().hasAppInfo()) {
                                        AndroidTVManager.this.textFieldAppInfo = parseDelimitedFrom.getImeKeyInject().getAppInfo();
                                    }
                                } else if (parseDelimitedFrom.getRequestCase().getNumber() == 21) {
                                    if (parseDelimitedFrom.getImeBatchEdit().getImeCounter() > 0) {
                                        AndroidTVManager.this.broadcastStartTyping();
                                    }
                                } else if (parseDelimitedFrom.getRequestCase().getNumber() == 22) {
                                    if (parseDelimitedFrom.getImeShowRequest().hasRemoteTextFieldStatus()) {
                                        AndroidTVManager.this.textFieldStatus = parseDelimitedFrom.getImeShowRequest().getRemoteTextFieldStatus();
                                    }
                                    AndroidTVManager.this.broadcastTextUpdated();
                                } else if (parseDelimitedFrom.getRequestCase().getNumber() == 31) {
                                    AndroidTVManager.this.broadcastStopVoice();
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    try {
                        if (-5 == PacketParser.readPacket(AndroidTVManager.this.mInputStream, new byte[65536])) {
                            AndroidTVManager.this.disconnect();
                            break;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    continue;
                }
            }
            if (AndroidTVManager.this.mWifiLock != null) {
                try {
                    if (AndroidTVManager.this.mWifiLock.isHeld()) {
                        AndroidTVManager.this.mWifiLock.release();
                    }
                } catch (Exception unused3) {
                }
            }
            AndroidTVManager.this.mListeningThread = null;
        }
    };

    /* loaded from: classes2.dex */
    public interface ConnectionListener {
        void onConnected();

        void onConnectionFailed();

        void onPinRequested();
    }

    public static AndroidTVManager getInstance(Context context2) {
        AndroidTVManager androidTVManager = instance;
        context = context2;
        if (androidTVManager == null) {
            synchronized (AndroidTVManager.class) {
                androidTVManager = instance;
                if (androidTVManager == null) {
                    androidTVManager = new AndroidTVManager();
                    instance = androidTVManager;
                }
            }
        }
        return androidTVManager;
    }

    public void setListener(ConnectionListener connectionListener) {
        this.listener = connectionListener;
    }

    public void connect(String str, int i, boolean z) {
        try {
            try {
                this.mWifiLock = ((WifiManager) context.getSystemService(Context.WIFI_SERVICE)).createWifiLock(1, "LibRemote");
                this.isNewAndroidTV = true;
                this.packetEncoder = new PacketEncoder();
                HandlerThread handlerThread = new HandlerThread("LibRemote.Network");
                this.connectionThread = handlerThread;
                handlerThread.start();
                this.mainHandler = new Handler(this.connectionThread.getLooper());
                this.deviceIp = str;
                if (i == 6465) {
                    this.devicePort = 6466;
                } else {
                    this.devicePort = i;
                }
                new asyncKeystore().execute(context);
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        } catch (NullPointerException unused) {
            Toast.makeText(context, (int) R.string.app_name, Toast.LENGTH_SHORT).show();
        }
    }

    public void disconnect() {
        new Thread(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AndroidTVManager.this.sslsock != null && AndroidTVManager.this.sslsock.isConnected()) {
                        AndroidTVManager.this.sslsock.close();
                    }
                } catch (Exception unused) {
                }
                if (AndroidTVManager.this.mInputStream != null) {
                    try {
                        AndroidTVManager.this.mInputStream.close();
                    } catch (Exception unused2) {
                    }
                    AndroidTVManager.this.mInputStream = null;
                }
                if (AndroidTVManager.this.mOutputStream != null) {
                    try {
                        AndroidTVManager.this.mOutputStream.close();
                    } catch (Exception unused3) {
                    }
                    AndroidTVManager.this.mOutputStream = null;
                }
            }
        }).start();
        cancelPairing();
        HandlerThread handlerThread = this.connectionThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.connectionThread = null;
        this.sslsock = null;
        this.mainHandler = null;
        this.deviceIp = null;
    }

    /* loaded from: classes2.dex */
    public class asyncKeystore extends AsyncKeystore {
        public asyncKeystore() {
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(KeyStoreManager keyStoreManager) {
            AndroidTVManager.this.keyStoreManager = keyStoreManager;
            if (AndroidTVManager.this.mainHandler != null) {
                AndroidTVManager.this.mainHandler.post(new connectThread());
            }
        }
    }

    public void cancelPairing() {
        PairingThread pairingThread = this.mPairingThread;
        if (pairingThread != null) {
            pairingThread.cancel();
            this.mPairingThread = null;
        }
    }

    public void setSecret(String str) {
        PairingThread pairingThread = this.mPairingThread;
        if (pairingThread != null) {
            pairingThread.setSecret(str);
        }
    }

    public void startPairing(String str, int i) {
        Log.d("testing"," bhi");
        if (this.mPairingThread == null) {
            PairingThread pairingThread = new PairingThread();
            this.mPairingThread = pairingThread;
            pairingThread.pairingIp = str;
            this.mPairingThread.pairingPort = i;
            this.mPairingThread.start();
        }
    }

    public void attemptToPair(String str, int i) {
        Log.d("testing"," kuch bhi");
        startPairing(str, i);
    }

    public void attemptToConnect(String str, int i) throws GeneralSecurityException {
        Log.d("testing","na remove bhi");
        this.isConnecting = true;
        KeyManager[] keyManagerArr = new KeyManager[0];
        try {
            keyManagerArr = this.keyStoreManager.getKeyManagers();
        } catch (Exception ignored) {
        }
        TrustManager[] trustManagerArr = new TrustManager[0];
        trustManagerArr = this.keyStoreManager.getTrustManagers();
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(keyManagerArr, trustManagerArr, new SecureRandom());
            SSLSocket sSLSocket = (SSLSocket) sSLContext.getSocketFactory().createSocket(str, i);
            sSLSocket.setNeedClientAuth(true);
            sSLSocket.setUseClientMode(true);
            sSLSocket.setKeepAlive(true);
            sSLSocket.setTcpNoDelay(true);
            sSLSocket.startHandshake();
            this.sslsock = sSLSocket;
            try {
                this.mInputStream = sSLSocket.getInputStream();
                this.mOutputStream = this.sslsock.getOutputStream();
                Thread thread = new Thread(this.mSocketListener);
                this.mListeningThread = thread;
                thread.start();
                ConnectionListener connectionListener = this.listener;
                if (connectionListener != null) {
                    connectionListener.onConnected();
                }
                if (!this.isNewAndroidTV) {
                    sendConfiguration();
                }
                this.needsReconnect = false;
            } catch (Exception unused3) {
            }
        } catch (SSLException unused4) {
            attemptToPair(str, i + 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.isConnecting = false;
    }

    public void sendConfiguration() {
        try {
            writeBytes(this.packetEncoder.encodeConfigure(1, 1, (byte) 32, (byte) 3, getIdentifier()));
        } catch (Exception unused) {
        }
    }

    public void sendConfigurationNew(int i) {
        RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
        RemoteProto_Configure.Builder newBuilder2 = RemoteProto_Configure.newBuilder();
        newBuilder2.setCode(i);
        newBuilder2.setDeviceInfo(RemoteProto$DeviceInfo.newBuilder().setModel(Build.MODEL).setVendor(Build.MANUFACTURER).setUnknown1(1).setUnknown2(Build.VERSION.RELEASE).setPackageName(context.getPackageName()).setAppVersion("1.12.0").build());
        newBuilder.setConfigure(newBuilder2.build());
        try {
            newBuilder.build().writeDelimitedTo(this.mOutputStream);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void sendActive() {
        RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
        newBuilder.setSetActive(RemoteProto_SetActive.newBuilder().setActive(639).build());
        try {
            newBuilder.build().writeDelimitedTo(this.mOutputStream);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void sendPing(int i) {
        RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
        newBuilder.setPingResponse(RemoteProto_PingResponse.newBuilder().setVal1(i).build());
        try {
            newBuilder.build().writeDelimitedTo(this.mOutputStream);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final String getIdentifier() {
        if (Build.VERSION.SDK_INT <= 22) {
            return context.checkCallingOrSelfPermission("bluetooth") != PackageManager.PERMISSION_GRANTED ? ((WifiManager) context.getSystemService(Context.WIFI_SERVICE)).getConnectionInfo().getMacAddress() : BluetoothAdapter.getDefaultAdapter().getAddress();
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("LibRemoteSDK", 0);
        String string = sharedPreferences.getString("identifier", null);
        if (string != null) {
            return string;
        }
        String randomMACAddress = randomMACAddress();
        sharedPreferences.edit().putString("identifier", randomMACAddress).apply();
        return randomMACAddress;
    }

    public static String randomMACAddress() {
        byte[] bArr = new byte[6];
        new SecureRandom().nextBytes(bArr);
        bArr[0] = (byte) ((bArr[0] | 2) & (-2));
        StringBuilder sb = new StringBuilder(18);
        for (int i = 0; i < 6; i++) {
            byte b = bArr[i];
            if (sb.length() > 0) {
                sb.append(":");
            }
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    public void checkIfConnected() {
        if (this.deviceIp == null || this.isConnecting) {
            return;
        }
        disconnectSafe();
        this.isConnecting = true;
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.3
            @Override // java.lang.Runnable
            public void run() {
                AndroidTVManager androidTVManager = AndroidTVManager.this;
                androidTVManager.connect("10.64.23.70", AndroidTVManager.this.devicePort, AndroidTVManager.this.isNewAndroidTV);
            }
        }, 500L);
    }

    public void startVoiceNew() {
        new Thread(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.6
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidTVManager.this.sslsock != null && AndroidTVManager.this.sslsock.isConnected()) {
                    RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
                    newBuilder.setVoiceBegin(RemoteProto_VoiceBegin.newBuilder().setSessionId(-1).setVoiceConfig(RemoteProto_VoiceConfig.newBuilder().setSampleRate(8000).setChannelConfig(16).setAudioFormat(2).build()).build());
                    try {
                        newBuilder.build().writeDelimitedTo(AndroidTVManager.this.mOutputStream);
                        return;
                    } catch (SocketException unused) {
                        AndroidTVManager.this.checkIfConnected();
                        return;
                    } catch (SSLException unused2) {
                        AndroidTVManager.this.checkIfConnected();
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                AndroidTVManager.this.broadcastReconnect();
            }
        }).start();
    }

    public void sendVoiceNew(final byte[] bArr) {
        new Thread(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.7
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidTVManager.this.sslsock != null && AndroidTVManager.this.sslsock.isConnected()) {
                    RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
                    newBuilder.setVoicePayload(ByteString.copyFrom(bArr)).build();
                    try {
                        newBuilder.build().writeDelimitedTo(AndroidTVManager.this.mOutputStream);
                        return;
                    } catch (SocketException unused) {
                        AndroidTVManager.this.checkIfConnected();
                        return;
                    } catch (SSLException unused2) {
                        AndroidTVManager.this.checkIfConnected();
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                AndroidTVManager.this.broadcastReconnect();
            }
        }).start();
    }

    public void stopVoiceNew() {
        new Thread(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.8
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidTVManager.this.sslsock != null && AndroidTVManager.this.sslsock.isConnected()) {
                    RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
                    newBuilder.setVoiceEnd(RemoteProto_VoiceEnd.newBuilder().setSessionId(-1)).build();
                    try {
                        newBuilder.build().writeDelimitedTo(AndroidTVManager.this.mOutputStream);
                        return;
                    } catch (SocketException unused) {
                        AndroidTVManager.this.checkIfConnected();
                        return;
                    } catch (SSLException unused2) {
                        AndroidTVManager.this.checkIfConnected();
                        return;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                AndroidTVManager.this.broadcastReconnect();
            }
        }).start();
    }

    public void sendKeyPress(final int i) {
        new Thread(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.9
            @Override // java.lang.Runnable
            public void run() {
                if (AndroidTVManager.this.sslsock != null && AndroidTVManager.this.sslsock.isConnected()) {
                    if (!AndroidTVManager.this.isNewAndroidTV) {
                        AndroidTVManager androidTVManager = AndroidTVManager.this;
                        androidTVManager.writeBytes(androidTVManager.packetEncoder.encodeKeyEvent(0, i));
                        AndroidTVManager androidTVManager2 = AndroidTVManager.this;
                        androidTVManager2.writeBytes(androidTVManager2.packetEncoder.encodeKeyEvent(1, i));
                        return;
                    }
                    AndroidTVManager.this.sendKeyPressNew(i, 0);
                    AndroidTVManager.this.sendKeyPressNew(i, 1);
                    return;
                }
                AndroidTVManager.this.broadcastReconnect();
            }
        }).start();
    }

    public void sendKeyPressNew(int i, int i2) {
        if (this.needsReconnect) {
            return;
        }
        RemoteProto_RemoteMessage.Builder newBuilder = RemoteProto_RemoteMessage.newBuilder();
        newBuilder.setKeyInject(RemoteProto_KeyInject.newBuilder().setKeyCode(i).setDirection(i2 + 1).build());
        try {
            newBuilder.build().writeDelimitedTo(this.mOutputStream);
        } catch (SocketException unused) {
            this.needsReconnect = true;
            checkIfConnected();
        } catch (SSLException unused2) {
            this.needsReconnect = true;
            checkIfConnected();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void disconnectSafe() {
        try {
            SSLSocket sSLSocket = this.sslsock;
            if (sSLSocket != null && sSLSocket.isConnected()) {
                this.sslsock.close();
            }
        } catch (Exception unused) {
        }
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused2) {
            }
            this.mInputStream = null;
        }
        OutputStream outputStream = this.mOutputStream;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused3) {
            }
            this.mOutputStream = null;
        }
        cancelPairing();
        HandlerThread handlerThread = this.connectionThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        Thread thread = this.mListeningThread;
        if (thread != null) {
            thread.interrupt();
        }
        this.mListeningThread = null;
        this.connectionThread = null;
        this.sslsock = null;
        this.mainHandler = null;
    }

    public void broadcastReconnect() {
        disconnectSafe();
        Context context2 = context;
        if (context2 != null) {
            context2.sendBroadcast(new Intent("ANDROID_RECONNECT"));
        }
    }

    public void writeBytes(byte[] bArr) {
        try {
            this.mOutputStream.write(bArr);
            this.mOutputStream.flush();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* loaded from: classes2.dex */
    public class connectThread implements Runnable {
        public connectThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.d("testing","na remove kuch bhi");
            AndroidTVManager androidTVManager = AndroidTVManager.this;
            try {
                androidTVManager.attemptToConnect(androidTVManager.deviceIp, AndroidTVManager.this.devicePort);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class PairingThread extends Thread {
        public boolean mIsCancelling;
        public final Handler mPairingNetHandler;
        public ClientPairingSession mPairingSession;
        public String mSecret;
        public String pairingIp;
        public int pairingPort;

        public PairingThread() {
            HandlerThread handlerThread = new HandlerThread("PairingClient.Network");
            handlerThread.start();
            this.mPairingNetHandler = new Handler(handlerThread.getLooper());
        }

        public synchronized void cancel() {
            this.mIsCancelling = true;
            notify();
            this.mPairingNetHandler.post(new Runnable() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.PairingThread.1
                @Override // java.lang.Runnable
                public void run() {
                    if (PairingThread.this.mPairingSession != null) {
                        PairingThread.this.mPairingSession.teardown();
                    }
                }
            });
        }

        public synchronized void setSecret(String str) {
            if (this.mSecret == null) {
                this.mSecret = str;
                notify();
            }
        }

        public synchronized String getSecret() {
            synchronized (this) {
                if (this.mIsCancelling) {
                    return null;
                }
                String str = this.mSecret;
                if (str != null) {
                    return str;
                }
                try {
                    wait();
                    return this.mIsCancelling ? null : this.mSecret;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {

            try {
                Log.d("testing","abb kuch bhi");
                SSLSocket sSLSocket = (SSLSocket) DummySSLSocketFactory.fromKeyManagers(AndroidTVManager.this.keyStoreManager.getKeyManagers()).createSocket(this.pairingIp, this.pairingPort);
                PairingContext fromSslSocket = PairingContext.fromSslSocket(sSLSocket, false);

                if (!AndroidTVManager.this.isNewAndroidTV) {
                    Log.d("testing"," bhi");
                    this.mPairingSession = new ClientPairingSession(WireFormat.JSON.getWireInterface(fromSslSocket), fromSslSocket, AndroidService.ID);
                    EncodingOption encodingOption = new EncodingOption(EncodingOption.EncodingType.ENCODING_HEXADECIMAL, 4);
                    this.mPairingSession.addInputEncoding(encodingOption);
                    this.mPairingSession.addOutputEncoding(encodingOption);
                } else {
                    Log.d("testing","hup bhi");
                    this.mPairingSession = new ClientPairingSession(WireFormat.PROTOCOL_BUFFERS.getWireInterface(fromSslSocket), fromSslSocket, AndroidService.ID);
                    EncodingOption.EncodingType encodingType = EncodingOption.EncodingType.ENCODING_HEXADECIMAL;
                    EncodingOption encodingOption2 = new EncodingOption(encodingType, 4);
                    this.mPairingSession.addInputEncoding(new EncodingOption(encodingType, 6));
                    this.mPairingSession.addOutputEncoding(encodingOption2);
                }
                if (this.mPairingSession.doPair(new PairingListener() { // from class: com.begamob.global.remote.roku.utils.remoteutils.androidtv.AndroidTVManager.PairingThread.2
                    @Override // com.google.polo.pairing.PairingListener
                    public void onLogMessage(PairingListener.LogLevel logLevel, String str) {
                    }

                    @Override // com.google.polo.pairing.PairingListener
                    public void onPerformOutputDeviceRole(PairingSession pairingSession, byte[] bArr) {
                    }

                    @Override // com.google.polo.pairing.PairingListener
                    public void onSessionCreated(PairingSession pairingSession) {
                    }

                    @Override // com.google.polo.pairing.PairingListener
                    public void onSessionEnded(PairingSession pairingSession) {
                    }

                    @Override // com.google.polo.pairing.PairingListener
                    public void onPerformInputDeviceRole(PairingSession pairingSession) {
                        Log.d("testing"," bhisdvfsdv");
                        if (!PairingThread.this.mIsCancelling && AndroidTVManager.this.listener != null) {
                            AndroidTVManager.this.listener.onPinRequested();
                        }
                        String secret = PairingThread.this.getSecret();
                        if (!PairingThread.this.mIsCancelling && secret != null) {
                            try {
                                if (!AndroidTVManager.this.isNewAndroidTV) {
                                    pairingSession.setSecret(pairingSession.getEncoder().decodeToBytes(secret));
                                    return;
                                } else {
                                    pairingSession.setSecret(AndroidTVManager.this.hexStringToBytes(secret));
                                    return;
                                }
                            } catch (IllegalArgumentException unused) {
                                pairingSession.teardown();
                                return;
                            } catch (IllegalStateException unused2) {
                                pairingSession.teardown();
                                return;
                            }
                        }
                        pairingSession.teardown();
                    }
                })) {
                  //  keyStoreManager.storeCertificate(fromSslSocket.getServerCertificate());
                    mainHandler.post(new connectThread());
                } else {
                    failedConnection();
                }
                try {
                    sSLSocket.close();
                } catch (IOException unused) {
                }
            } catch (Exception unused2) {
                Log.d("Testing",unused2.toString());
                failedConnection();
            }
        }

        public void failedConnection() {
            Log.d("testing"," sdvsdvsdbhi");
            ClientPairingSession clientPairingSession = this.mPairingSession;
            if (clientPairingSession != null) {
                clientPairingSession.teardown();
            }
            AndroidTVManager.this.disconnect();
            if (AndroidTVManager.this.listener != null) {
                AndroidTVManager.this.listener.onConnectionFailed();
            }
        }
    }

    public byte[] hexStringToBytes(String str) {
        if (str == null || str.length() == 0 || str.length() % 2 != 0) {
            throw new IllegalArgumentException("Bad input string.");
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, i2 * 2), 16);
            i = i2;
        }
        return bArr;
    }

    public void broadcastStartTyping() {
        Context context2 = context;
        if (context2 != null) {
            context2.sendBroadcast(new Intent("ANDROID_START_TYPING"));
        }
    }

    public void broadcastTextUpdated() {
        Context context2 = context;
        if (context2 != null) {
            context2.sendBroadcast(new Intent("ANDROID_TEXT_UPDATED"));
        }
    }

    public void broadcastStopVoice() {
        Context context2 = context;
        if (context2 != null) {
            context2.sendBroadcast(new Intent("ANDROID_STOP_VOICE"));
        }
    }
}