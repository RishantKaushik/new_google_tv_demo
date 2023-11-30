package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_ImeObject extends GeneratedMessageLite<RemoteProto_ImeObject, RemoteProto_ImeObject.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_ImeObject DEFAULT_INSTANCE;
    public static final int PARAM1_FIELD_NUMBER = 1;
    public static final int PARAM2_FIELD_NUMBER = 2;
    private static volatile Parser<RemoteProto_ImeObject> PARSER = null;
    public static final int STR_FIELD_NUMBER = 3;
    private int bitField0_;
    private int param1_;
    private int param2_;
    private String str_ = "";

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_ImeObject, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_ImeObject.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_ImeObject remoteProto$ImeObject = new RemoteProto_ImeObject();
        DEFAULT_INSTANCE = remoteProto$ImeObject;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_ImeObject.class, remoteProto$ImeObject);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_ImeObject();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003ဈ\u0002", new Object[]{"bitField0_", "param1_", "param2_", "str_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_ImeObject> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_ImeObject.class) {
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