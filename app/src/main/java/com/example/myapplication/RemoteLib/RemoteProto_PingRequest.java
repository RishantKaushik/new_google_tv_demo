package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_PingRequest extends GeneratedMessageLite<RemoteProto_PingRequest, RemoteProto_PingRequest.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_PingRequest DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_PingRequest> PARSER = null;
    public static final int VAL1_FIELD_NUMBER = 1;
    public static final int VAL2_FIELD_NUMBER = 2;
    private int bitField0_;
    private int val1_;
    private int val2_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_PingRequest, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_PingRequest.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_PingRequest RemoteProto_PingRequest = new RemoteProto_PingRequest();
        DEFAULT_INSTANCE = RemoteProto_PingRequest;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_PingRequest.class, RemoteProto_PingRequest);
    }

    public static RemoteProto_PingRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_PingRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "val1_", "val2_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_PingRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_PingRequest.class) {
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

    public int getVal1() {
        return this.val1_;
    }
}