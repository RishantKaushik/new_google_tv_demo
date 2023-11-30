package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_KeyInject extends GeneratedMessageLite<RemoteProto_KeyInject, RemoteProto_KeyInject.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_KeyInject DEFAULT_INSTANCE;
    public static final int DIRECTION_FIELD_NUMBER = 2;
    public static final int KEYCODE_FIELD_NUMBER = 1;
    private static volatile Parser<RemoteProto_KeyInject> PARSER;
    private int bitField0_;
    private int direction_;
    private int keyCode_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_KeyInject, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_KeyInject.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setDirection(int i) {
            copyOnWrite();
            ((RemoteProto_KeyInject) this.instance).setDirection(i);
            return this;
        }

        public Builder setKeyCode(int i) {
            copyOnWrite();
            ((RemoteProto_KeyInject) this.instance).setKeyCode(i);
            return this;
        }
    }

    static {
        RemoteProto_KeyInject RemoteProto_KeyInject = new RemoteProto_KeyInject();
        DEFAULT_INSTANCE = RemoteProto_KeyInject;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_KeyInject.class, RemoteProto_KeyInject);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_KeyInject();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဋ\u0000\u0002ဋ\u0001", new Object[]{"bitField0_", "keyCode_", "direction_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_KeyInject> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_KeyInject.class) {
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

    public final void setDirection(int i) {
        this.bitField0_ |= 2;
        this.direction_ = i;
    }

    public final void setKeyCode(int i) {
        this.bitField0_ |= 1;
        this.keyCode_ = i;
    }
}