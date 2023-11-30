package com.example.myapplication.RemoteLib;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_VoiceEnd extends GeneratedMessageLite<RemoteProto_VoiceEnd, RemoteProto_VoiceEnd.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_VoiceEnd DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_VoiceEnd> PARSER = null;
    public static final int SESSIONID_FIELD_NUMBER = 1;
    private int bitField0_;
    private int sessionId_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_VoiceEnd, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_VoiceEnd.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setSessionId(int i) {
            copyOnWrite();
            ((RemoteProto_VoiceEnd) this.instance).setSessionId(i);
            return this;
        }
    }

    static {
        RemoteProto_VoiceEnd RemoteProto_VoiceEnd = new RemoteProto_VoiceEnd();
        DEFAULT_INSTANCE = RemoteProto_VoiceEnd;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_VoiceEnd.class, RemoteProto_VoiceEnd);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_VoiceEnd();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"bitField0_", "sessionId_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_VoiceEnd> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_VoiceEnd.class) {
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

    public final void setSessionId(int i) {
        this.bitField0_ |= 1;
        this.sessionId_ = i;
    }
}
