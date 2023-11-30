package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_PingResponse extends GeneratedMessageLite<RemoteProto_PingResponse, RemoteProto_PingResponse.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_PingResponse DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_PingResponse> PARSER = null;
    public static final int VAL1_FIELD_NUMBER = 1;
    private int bitField0_;
    private int val1_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_PingResponse, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_PingResponse.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setVal1(int i) {
            copyOnWrite();
            ((RemoteProto_PingResponse) this.instance).setVal1(i);
            return this;
        }
    }

    static {
        RemoteProto_PingResponse RemoteProto_PingResponse = new RemoteProto_PingResponse();
        DEFAULT_INSTANCE = RemoteProto_PingResponse;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_PingResponse.class, RemoteProto_PingResponse);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_PingResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဋ\u0000", new Object[]{"bitField0_", "val1_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_PingResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_PingResponse.class) {
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

    public final void setVal1(int i) {
        this.bitField0_ |= 1;
        this.val1_ = i;
    }
}