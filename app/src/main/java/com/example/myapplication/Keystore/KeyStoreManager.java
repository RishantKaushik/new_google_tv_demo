package com.example.myapplication.Keystore;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.text.TextUtils;
import com.google.polo.ssl.SslUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.Locale;
import java.util.UUID;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes2.dex */
public final class KeyStoreManager {
    public static String ANDROID_KEYSTORE = "AndroidKeyStore";
    public static final char[] KEYSTORE_PASSWORD = "KeyStore_Password".toCharArray();
    public final Context mContext;
    public DynamicTrustManager mDynamicTrustManager;
    public KeyStore mKeyStore;

    /* loaded from: classes2.dex */
    public static class DynamicTrustManager implements X509TrustManager {
        public X509TrustManager trustManager;

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }

        public DynamicTrustManager(KeyStore keyStore) {
            reloadTrustManager(keyStore);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.trustManager.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.trustManager.checkServerTrusted(x509CertificateArr, str);
        }

        public void reloadTrustManager(KeyStore keyStore) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                for (int i = 0; i < trustManagers.length; i++) {
                    if (trustManagers[i] instanceof X509TrustManager) {
                        this.trustManager = (X509TrustManager) trustManagers[i];
                        return;
                    }
                }
                throw new IllegalStateException("No trust manager found");
            } catch (KeyStoreException | NoSuchAlgorithmException unused) {
            }
        }
    }

    public KeyStoreManager(Context context) {
        this.mContext = context;
        KeyStore load = load();
        this.mKeyStore = load;
        this.mDynamicTrustManager = new DynamicTrustManager(load);
    }

    public static String createAlias(String str) {
        return String.format("libremote-%s", str);
    }

    public final void createIdentity(KeyStore keyStore) throws GeneralSecurityException, IOException {
        createIdentity(keyStore, "libremote-local");
    }

    public final void createIdentity(KeyStore keyStore, String str) throws GeneralSecurityException, IOException {
        createIdentity(keyStore, str, getUniqueId());
    }

    public final void setLocale(Locale locale) {
        try {
            Locale.setDefault(locale);
            Resources resources = this.mContext.getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Exception unused) {
        }
    }
    public final void createIdentity(KeyStore keyStore, String str, String str2) throws GeneralSecurityException, IOException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_EC, "AndroidKeyStore");
        kpg.initialize(new KeyGenParameterSpec.Builder(
                str,
                KeyProperties.PURPOSE_SIGN | KeyProperties.PURPOSE_VERIFY)
                .setDigests(KeyProperties.DIGEST_SHA256,
                        KeyProperties.DIGEST_SHA512)
                .setCertificateSubject(new X500Principal(getCertificateName(str2)))
                .build());

        KeyPair generateKeyPair = kpg.generateKeyPair();
        try {
            // Use the provided alias 'str' when setting the key entry
            keyStore.setKeyEntry(str, generateKeyPair.getPrivate(), null, new Certificate[]{X509CertificateGenerator.generateCertificate()});
        } catch (IllegalArgumentException unused) {
            Locale locale = Locale.getDefault();
            setLocale(Locale.ENGLISH);
            // Use the provided alias 'str' when setting the key entry
            keyStore.setKeyEntry(str, generateKeyPair.getPrivate(), null, new Certificate[]{X509CertificateGenerator.generateCertificate()});
            setLocale(locale);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

/*
    public final void createIdentity(KeyStore keyStore, String str, String str2) throws GeneralSecurityException {
//        KeyPair generateKeyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(
                KeyProperties.KEY_ALGORITHM_EC);
        kpg.initialize(new KeyGenParameterSpec.Builder(
                str,
                KeyProperties.PURPOSE_SIGN | KeyProperties.PURPOSE_VERIFY)
                .setDigests(KeyProperties.DIGEST_SHA256,
                        KeyProperties.DIGEST_SHA512)
                .build());

        KeyPair generateKeyPair = kpg.generateKeyPair();
        try {
            keyStore.setKeyEntry(str, generateKeyPair.getPrivate(), null, new Certificate[]{X509CertificateGenerator.generateCertificate(str2,"local")});
         //   keyStore.setKeyEntry(str, generateKeyPair.getPrivate(), null, new Certificate[]{SslUtil.generateX509V3Certificate(generateKeyPair, getCertificateName(str2))});
        } catch (IllegalArgumentException unused) {
            Locale locale = Locale.getDefault();
            setLocale(Locale.ENGLISH);
            keyStore.setKeyEntry(str, generateKeyPair.getPrivate(), null, new Certificate[]{SslUtil.generateX509V3Certificate(generateKeyPair, getCertificateName(str2))});
            setLocale(locale);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
*/

    public final KeyStore createIdentityKeyStore() throws GeneralSecurityException, IOException {
        KeyStore keyStore;
        if (!useAndroidKeyStore()) {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            try {
                keyStore.load(null, KEYSTORE_PASSWORD);
            } catch (IOException e2) {
                throw new GeneralSecurityException("Unable to create empty keyStore", e2);
            }
        } else {
            keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
            try {
                keyStore.load(null);
            } catch (IOException e3) {
                throw new GeneralSecurityException("Unable to create empty keyStore", e3);
            }
        }
        createIdentity(keyStore);
        return keyStore;
    }

    public static final String getCertificateName(String str) {
        return "CN=libremote/" + (Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.MODEL + "/" + str).replace("+", "(Plus)").replace("=", "-eq-");
    }

    public static String getSubjectDN(Certificate certificate) {
        X500Principal subjectX500Principal;
        if (!(certificate instanceof X509Certificate) || (subjectX500Principal = ((X509Certificate) certificate).getSubjectX500Principal()) == null) {
            return null;
        }
        return subjectX500Principal.getName();
    }

    public static final String getUniqueId() {
        String str = Build.SERIAL;
        if (TextUtils.isEmpty(str)) {
            String address = BluetoothAdapter.getDefaultAdapter().getAddress();
            return TextUtils.isEmpty(address) ? UUID.randomUUID().toString() : address;
        }
        return str;
    }

    public final boolean hasServerIdentityAlias(KeyStore keyStore) {
        try {
            return keyStore.containsAlias("libremote-local");
        } catch (KeyStoreException unused) {
            return false;
        }
    }

    public final KeyStore load() {
        KeyStore keyStore;
        KeyStore keyStore2 = null;
        try {
            if (!useAndroidKeyStore()) {
                keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(this.mContext.openFileInput("libremote.keystore"), KEYSTORE_PASSWORD);
            } else {
                keyStore = KeyStore.getInstance(ANDROID_KEYSTORE);
                keyStore.load(null);
            }
            keyStore2 = keyStore;
        } catch (IOException | GeneralSecurityException unused) {
        }
        if (keyStore2 == null || !hasServerIdentityAlias(keyStore2)) {
            try {
                KeyStore createIdentityKeyStore = createIdentityKeyStore();
                store(createIdentityKeyStore);
                return createIdentityKeyStore;
            } catch (GeneralSecurityException e3) {
                throw new IllegalStateException("Unable to create identity KeyStore", e3);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return keyStore2;
    }

    public final void store(KeyStore keyStore) {
        if (useAndroidKeyStore()) {
            return;
        }
        try {
            FileOutputStream openFileOutput = this.mContext.openFileOutput("libremote.keystore", 0);
            keyStore.store(openFileOutput, KEYSTORE_PASSWORD);
            openFileOutput.close();
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to store keyStore", e2);
        } catch (GeneralSecurityException e3) {
            throw new IllegalStateException("Unable to store keyStore", e3);
        }
    }

    public final boolean useAndroidKeyStore() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public KeyManager[] getKeyManagers() throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(this.mKeyStore, "".toCharArray());
        return keyManagerFactory.getKeyManagers();
    }

    public TrustManager[] getTrustManagers() throws GeneralSecurityException {
        try {
            return new DynamicTrustManager[]{this.mDynamicTrustManager};
        } catch (Exception e2) {
            throw new GeneralSecurityException(e2);
        }
    }

    public boolean hasServerIdentityAlias() {
        return hasServerIdentityAlias(this.mKeyStore);
    }

    public void initializeKeyStore() {
        initializeKeyStore(getUniqueId());
    }

    public void initializeKeyStore(String str) {
        try {
            createIdentity(this.mKeyStore, "libremote-local", str);
            store();
        } catch (GeneralSecurityException | IOException e2) {
            throw new IllegalStateException("Unable to create identity KeyStore", e2);
        }
    }

    public void store() {
        this.mDynamicTrustManager.reloadTrustManager(this.mKeyStore);
        store(this.mKeyStore);
    }

    public void storeCertificate(Certificate certificate) {
        storeCertificate(certificate, Integer.toString(certificate.hashCode()));
    }

    public void storeCertificate(Certificate certificate, String str) {
        try {
            String createAlias = createAlias(str);
            String subjectDN = getSubjectDN(certificate);
            if (this.mKeyStore.containsAlias(createAlias)) {
                this.mKeyStore.deleteEntry(createAlias);
            }
            if (subjectDN != null) {
                Enumeration<String> aliases = this.mKeyStore.aliases();
                while (aliases.hasMoreElements()) {
                    String nextElement = aliases.nextElement();
                    String subjectDN2 = getSubjectDN(this.mKeyStore.getCertificate(nextElement));
                    if (subjectDN2 != null && subjectDN2.equals(subjectDN)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Deleting entry for ");
                        sb.append(nextElement);
                        sb.append(" (");
                        sb.append(subjectDN2);
                        sb.append(")");
                        this.mKeyStore.deleteEntry(nextElement);
                    }
                }
            }
            this.mKeyStore.setCertificateEntry(createAlias, certificate);
            store();
        } catch (KeyStoreException unused) {
        }
    }
}