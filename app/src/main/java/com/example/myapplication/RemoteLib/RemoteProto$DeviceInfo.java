package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto$DeviceInfo extends GeneratedMessageLite<RemoteProto$DeviceInfo, RemoteProto$DeviceInfo.Builder> implements MessageLiteOrBuilder {
    public static final int APPVERSION_FIELD_NUMBER = 6;
    private static final RemoteProto$DeviceInfo DEFAULT_INSTANCE;
    public static final int MODEL_FIELD_NUMBER = 1;
    public static final int PACKAGENAME_FIELD_NUMBER = 5;
    private static volatile Parser<RemoteProto$DeviceInfo> PARSER = null;
    public static final int UNKNOWN1_FIELD_NUMBER = 3;
    public static final int UNKNOWN2_FIELD_NUMBER = 4;
    public static final int VENDOR_FIELD_NUMBER = 2;
    private int bitField0_;
    private int unknown1_;
    private byte memoizedIsInitialized = (byte) 2;
    private String model_ = "";
    private String vendor_ = "";
    private String unknown2_ = "";
    private String packageName_ = "";
    private String appVersion_ = "";

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto$DeviceInfo, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto$DeviceInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setAppVersion(String str) {
            copyOnWrite();
            ((RemoteProto$DeviceInfo) this.instance).setAppVersion(str);
            return this;
        }

        public Builder setModel(String str) {
            copyOnWrite();
            ((RemoteProto$DeviceInfo) this.instance).setModel(str);
            return this;
        }

        public Builder setPackageName(String str) {
            copyOnWrite();
            ((RemoteProto$DeviceInfo) this.instance).setPackageName(str);
            return this;
        }

        public Builder setUnknown1(int i) {
            copyOnWrite();
            ((RemoteProto$DeviceInfo) this.instance).setUnknown1(i);
            return this;
        }

        public Builder setUnknown2(String str) {
            copyOnWrite();
            ((RemoteProto$DeviceInfo) this.instance).setUnknown2(str);
            return this;
        }

        public Builder setVendor(String str) {
            copyOnWrite();
            ((RemoteProto$DeviceInfo) this.instance).setVendor(str);
            return this;
        }
    }

    static {
        RemoteProto$DeviceInfo remoteProto$DeviceInfo = new RemoteProto$DeviceInfo();
        DEFAULT_INSTANCE = remoteProto$DeviceInfo;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto$DeviceInfo.class, remoteProto$DeviceInfo);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto$DeviceInfo();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0006\u0001ᔈ\u0000\u0002ᔈ\u0001\u0003ᔋ\u0002\u0004ᔈ\u0003\u0005ᔈ\u0004\u0006ᔈ\u0005", new Object[]{"bitField0_", "model_", "vendor_", "unknown1_", "unknown2_", "packageName_", "appVersion_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto$DeviceInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto$DeviceInfo.class) {
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

    public final void setAppVersion(String str) {
        str.getClass();
        this.bitField0_ |= 32;
        this.appVersion_ = str;
    }

    public final void setModel(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.model_ = str;
    }

    public final void setPackageName(String str) {
        str.getClass();
        this.bitField0_ |= 16;
        this.packageName_ = str;
    }

    public final void setUnknown1(int i) {
        this.bitField0_ |= 4;
        this.unknown1_ = i;
    }

    public final void setUnknown2(String str) {
        str.getClass();
        this.bitField0_ |= 8;
        this.unknown2_ = str;
    }

    public final void setVendor(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.vendor_ = str;
    }
}
