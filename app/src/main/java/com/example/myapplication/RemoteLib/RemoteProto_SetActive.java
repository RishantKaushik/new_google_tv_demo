package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_SetActive extends GeneratedMessageLite<RemoteProto_SetActive, RemoteProto_SetActive.Builder> implements MessageLiteOrBuilder {
    public static final int ACTIVE_FIELD_NUMBER = 1;
    private static final RemoteProto_SetActive DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_SetActive> PARSER;
    private int active_;
    private int bitField0_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_SetActive, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_SetActive.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setActive(int i) {
            copyOnWrite();
            ((RemoteProto_SetActive) this.instance).setActive(i);
            return this;
        }
    }

    static {
        RemoteProto_SetActive remoteProto$SetActive = new RemoteProto_SetActive();
        DEFAULT_INSTANCE = remoteProto$SetActive;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_SetActive.class, remoteProto$SetActive);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_SetActive();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဋ\u0000", new Object[]{"bitField0_", "active_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_SetActive> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_SetActive.class) {
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

    public final void setActive(int i) {
        this.bitField0_ |= 1;
        this.active_ = i;
    }
}