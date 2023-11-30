package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_AppInfo extends GeneratedMessageLite<RemoteProto_AppInfo, RemoteProto_AppInfo.Builder> implements MessageLiteOrBuilder {
    public static final int APP_PACKAGE_FIELD_NUMBER = 12;
    public static final int COUNTER_FIELD_NUMBER = 1;
    private static final RemoteProto_AppInfo DEFAULT_INSTANCE;
    public static final int INT13_FIELD_NUMBER = 13;


    public static final int INT2_FIELD_NUMBER = 2;
    public static final int INT3_FIELD_NUMBER = 3;
    public static final int INT4_FIELD_NUMBER = 4;
    public static final int INT7_FIELD_NUMBER = 7;
    public static final int INT8_FIELD_NUMBER = 8;
    public static final int LABEL_FIELD_NUMBER = 10;
    private static volatile Parser<RemoteProto_AppInfo> PARSER;
    private int bitField0_;
    private int counter_;
    private int int13_;
    private int int2_;
    private int int3_;
    private int int7_;
    private int int8_;
    private String int4_ = "";
    private String label_ = "";
    private String appPackage_ = "";

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_AppInfo, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_AppInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_AppInfo RemoteProto_AppInfo = new RemoteProto_AppInfo();
        DEFAULT_INSTANCE = RemoteProto_AppInfo;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_AppInfo.class, RemoteProto_AppInfo);
    }

    public static RemoteProto_AppInfo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_AppInfo();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\t\u0000\u0001\u0001\r\t\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0007င\u0004\bင\u0005\nဈ\u0006\fဈ\u0007\rင\b", new Object[]{"bitField0_", "counter_", "int2_", "int3_", "int4_", "int7_", "int8_", "label_", "appPackage_", "int13_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_AppInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_AppInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}