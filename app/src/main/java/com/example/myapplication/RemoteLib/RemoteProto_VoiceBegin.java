package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_VoiceBegin extends GeneratedMessageLite<RemoteProto_VoiceBegin, RemoteProto_VoiceBegin.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_VoiceBegin DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_VoiceBegin> PARSER = null;
    public static final int SESSIONID_FIELD_NUMBER = 1;
    public static final int VOICE_CONFIG_FIELD_NUMBER = 2;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte) 2;
    private int sessionId_;
    private RemoteProto_VoiceConfig voiceConfig_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_VoiceBegin, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_VoiceBegin.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setSessionId(int i) {
            copyOnWrite();
            ((RemoteProto_VoiceBegin) this.instance).setSessionId(i);
            return this;
        }

        public Builder setVoiceConfig(RemoteProto_VoiceConfig remoteProto_VoiceConfig) {
            copyOnWrite();
            ((RemoteProto_VoiceBegin) this.instance).setVoiceConfig(remoteProto_VoiceConfig);
            return this;
        }
    }

    static {
        RemoteProto_VoiceBegin RemoteProto_VoiceBegin = new RemoteProto_VoiceBegin();
        DEFAULT_INSTANCE = RemoteProto_VoiceBegin;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_VoiceBegin.class, RemoteProto_VoiceBegin);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_VoiceBegin();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001င\u0000\u0002ᐉ\u0001", new Object[]{"bitField0_", "sessionId_", "voiceConfig_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_VoiceBegin> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_VoiceBegin.class) {
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

    public final void setSessionId(int i) {
        this.bitField0_ |= 1;
        this.sessionId_ = i;
    }

    public final void setVoiceConfig(RemoteProto_VoiceConfig remoteProto$VoiceConfig) {
        remoteProto$VoiceConfig.getClass();
        this.voiceConfig_ = remoteProto$VoiceConfig;
        this.bitField0_ |= 2;
    }
}