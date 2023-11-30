package com.example.myapplication.RemoteLib;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_VoiceConfig extends GeneratedMessageLite<RemoteProto_VoiceConfig, RemoteProto_VoiceConfig.Builder> implements MessageLiteOrBuilder {
    public static final int AUDIOFORMAT_FIELD_NUMBER = 3;
    public static final int CHANNELCONFIG_FIELD_NUMBER = 2;
    private static final RemoteProto_VoiceConfig DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_VoiceConfig> PARSER = null;
    public static final int SAMPLERATE_FIELD_NUMBER = 1;
    private int audioFormat_;
    private int bitField0_;
    private int channelConfig_;
    private byte memoizedIsInitialized = (byte) 2;
    private int sampleRate_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_VoiceConfig, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_VoiceConfig.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setAudioFormat(int i) {
            copyOnWrite();
            ((RemoteProto_VoiceConfig) this.instance).setAudioFormat(i);
            return this;
        }

        public Builder setChannelConfig(int i) {
            copyOnWrite();
            ((RemoteProto_VoiceConfig) this.instance).setChannelConfig(i);
            return this;
        }

        public Builder setSampleRate(int i) {
            copyOnWrite();
            ((RemoteProto_VoiceConfig) this.instance).setSampleRate(i);
            return this;
        }
    }

    static {
        RemoteProto_VoiceConfig RemoteProto_VoiceConfig = new RemoteProto_VoiceConfig();
        DEFAULT_INSTANCE = RemoteProto_VoiceConfig;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_VoiceConfig.class, RemoteProto_VoiceConfig);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_VoiceConfig();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔄ\u0000\u0002ᔄ\u0001\u0003ᔄ\u0002", new Object[]{"bitField0_", "sampleRate_", "channelConfig_", "audioFormat_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_VoiceConfig> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_VoiceConfig.class) {
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

    public final void setAudioFormat(int i) {
        this.bitField0_ |= 4;
        this.audioFormat_ = i;
    }

    public final void setChannelConfig(int i) {
        this.bitField0_ |= 2;
        this.channelConfig_ = i;
    }

    public final void setSampleRate(int i) {
        this.bitField0_ |= 1;
        this.sampleRate_ = i;
    }
}