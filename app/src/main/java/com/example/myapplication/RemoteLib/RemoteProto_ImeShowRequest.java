package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_ImeShowRequest extends GeneratedMessageLite<RemoteProto_ImeShowRequest, RemoteProto_ImeShowRequest.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_ImeShowRequest DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_ImeShowRequest> PARSER = null;
    public static final int REMOTE_TEXT_FIELD_STATUS_FIELD_NUMBER = 2;
    private int bitField0_;
    private RemoteProto_TextFieldStatus remoteTextFieldStatus_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_ImeShowRequest, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_ImeShowRequest.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_ImeShowRequest RemoteProto_ImeShowRequest = new RemoteProto_ImeShowRequest();
        DEFAULT_INSTANCE = RemoteProto_ImeShowRequest;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_ImeShowRequest.class, RemoteProto_ImeShowRequest);
    }

    public static RemoteProto_ImeShowRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_ImeShowRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"bitField0_", "remoteTextFieldStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_ImeShowRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_ImeShowRequest.class) {
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

    public RemoteProto_TextFieldStatus getRemoteTextFieldStatus() {
        RemoteProto_TextFieldStatus remoteProto$TextFieldStatus = this.remoteTextFieldStatus_;
        return remoteProto$TextFieldStatus == null ? RemoteProto_TextFieldStatus.getDefaultInstance() : remoteProto$TextFieldStatus;
    }

    public boolean hasRemoteTextFieldStatus() {
        return (this.bitField0_ & 1) != 0;
    }
}
