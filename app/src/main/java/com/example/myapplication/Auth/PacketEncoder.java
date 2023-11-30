package com.example.myapplication.Auth;

import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class PacketEncoder {
    public static final byte[] ENCODED_CANCEL_BUGREPORT = {1, 29, 0, 0};
    public static final byte[] ENCODED_CONFIGURE_SUCCESS = {1, 7, 0, 0};
    public static final byte[] ENCODED_HIDE_IME = {1, 6, 0, 0};
    public static final byte[] ENCODED_PACKET_PING = {1, 20, 0, 0};
    public static final byte[] ENCODED_PACKET_PONG = {1, 21, 0, 0};
    public static final byte[] ENCODED_PACKET_START_VOICE = {1, 11, 0, 0};
    public static final byte[] ENCODED_PACKET_STOP_VOICE = {1, 12, 0, 0};
    public static final byte[] ENCODED_PACKET_VERSION_TOO_HIGH = {1, 9, 0, 4, 1, 0, 0, 0};
    public static final byte[] ENCODED_PACKET_VERSION_TOO_LOW = {1, 10, 0, 4, 1, 0, 0, 0};
    public static final byte[] ENCODED_SHOW_IME = {1, 5, 0, 0};
    public static final byte[] ENCODED_TAKE_BUGREPORT = {1, 28, 0, 0};
    public static final ByteBuffer mBuffer = ByteBuffer.allocate(65539);
    public static final ReentrantLock mLock = new ReentrantLock();
    public long mIndex = 0;

    /* loaded from: classes2.dex */
    public class PacketBuilder {
        public PacketBuilder(byte b) {
            if (!PacketEncoder.mLock.isHeldByCurrentThread()) {
                PacketEncoder.mLock.lock();
                PacketEncoder.mBuffer.clear();
                addHeader(b);
                return;
            }
            PacketEncoder.mLock.unlock();
            throw new RuntimeException(String.format("Thread %s already building packet", Thread.currentThread().toString()));
        }

        public final void addHeader(byte b) {
            put((byte) 1).put(b).putShort(new Integer(0).shortValue());
        }

        public final void setPayloadSize() {
            PacketEncoder.mBuffer.putShort(2, new Integer(PacketEncoder.mBuffer.position() - 4).shortValue());
        }

        public byte[] build() {
            setPayloadSize();
            byte[] bArr = new byte[PacketEncoder.mBuffer.position()];
            System.arraycopy(PacketEncoder.mBuffer.array(), PacketEncoder.mBuffer.arrayOffset(), bArr, 0, PacketEncoder.mBuffer.position());
            PacketEncoder.mLock.unlock();
            return bArr;
        }

        public PacketBuilder put(byte b) {
            PacketEncoder.mBuffer.put(b);
            return this;
        }

        public PacketBuilder putCharSequence(CharSequence charSequence) {
            if (charSequence == null) {
                PacketEncoder.mBuffer.put((byte) 1);
            } else {
                byte[] bytes = charSequence.toString().getBytes();
                PacketEncoder.mBuffer.put((byte) 0);
                PacketEncoder.mBuffer.putInt(bytes.length);
                PacketEncoder.mBuffer.put(bytes);
            }
            return this;
        }

        public PacketBuilder putInt(int i) {
            PacketEncoder.mBuffer.putInt(i);
            return this;
        }

        public PacketBuilder putLong(long j) {
            PacketEncoder.mBuffer.putLong(j);
            return this;
        }

        public PacketBuilder putShort(short s) {
            PacketEncoder.mBuffer.putShort(s);
            return this;
        }
    }

    public byte[] encodeConfigure(int i, int i2, byte b, byte b2, String str) {
        PacketBuilder packetBuilder = new PacketBuilder((byte) 0);
        packetBuilder.putInt(i).putInt(i2).put(b).put(b2).put((byte) 0).put((byte) 0).putCharSequence(str);
        return packetBuilder.build();
    }

    public byte[] encodeKeyEvent(int i, int i2) {
        long j = this.mIndex;
        this.mIndex = 1 + j;
        return encodeKeyEvent(j, i, i2);
    }

    public byte[] encodeKeyEvent(long j, int i, int i2) {
        PacketBuilder packetBuilder = new PacketBuilder((byte) 2);
        packetBuilder.putLong(j).putInt(i).putInt(i2);
        return packetBuilder.build();
    }
}