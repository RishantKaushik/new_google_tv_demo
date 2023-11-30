package com.example.myapplication.RemoteLib;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_Configure extends GeneratedMessageLite<RemoteProto_Configure, RemoteProto_Configure.Builder> implements MessageLiteOrBuilder {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final RemoteProto_Configure DEFAULT_INSTANCE;
    public static final int DEVICEINFO_FIELD_NUMBER = 2;
    private static volatile Parser<RemoteProto_Configure> PARSER;
    private int bitField0_;
    private int code_;
    private RemoteProto$DeviceInfo deviceInfo_;
    private byte memoizedIsInitialized = (byte) 2;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_Configure, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_Configure.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setCode(int i) {
            copyOnWrite();
            ((RemoteProto_Configure) this.instance).setCode(i);
            return this;
        }

        public Builder setDeviceInfo(RemoteProto$DeviceInfo remoteProto$DeviceInfo) {
            copyOnWrite();
            ((RemoteProto_Configure) this.instance).setDeviceInfo(remoteProto$DeviceInfo);
            return this;
        }
    }

    static {
        RemoteProto_Configure RemoteProto_Configure = new RemoteProto_Configure();
        DEFAULT_INSTANCE = RemoteProto_Configure;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_Configure.class, RemoteProto_Configure);
    }

    public static RemoteProto_Configure getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
       switch (methodToInvoke.ordinal()) {
            case 1:
                return new RemoteProto_Configure();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဋ\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "code_", "deviceInfo_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_Configure> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_Configure.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return Byte.valueOf(this.memoizedIsInitialized);
            case 7:
                this.memoizedIsInitialized = (byte) (obj != null ? 1 : 0);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getCode() {
        return this.code_;
    }

    public final void setCode(int i) {
        this.bitField0_ |= 1;
        this.code_ = i;
    }

    public final void setDeviceInfo(RemoteProto$DeviceInfo remoteProto$DeviceInfo) {
        remoteProto$DeviceInfo.getClass();
        this.deviceInfo_ = remoteProto$DeviceInfo;
        this.bitField0_ |= 2;
    }
}