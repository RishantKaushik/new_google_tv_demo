package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_EditInfo extends GeneratedMessageLite<RemoteProto_EditInfo, RemoteProto_EditInfo.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_EditInfo DEFAULT_INSTANCE;
    public static final int INSERT_FIELD_NUMBER = 1;
    private static volatile Parser<RemoteProto_EditInfo> PARSER = null;
    public static final int TEXTFIELDSTATUS_FIELD_NUMBER = 2;
    private int bitField0_;
    private int insert_;
    private RemoteProto_ImeObject textFieldStatus_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_EditInfo, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_EditInfo.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_EditInfo remoteProto$EditInfo = new RemoteProto_EditInfo();
        DEFAULT_INSTANCE = remoteProto$EditInfo;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_EditInfo.class, remoteProto$EditInfo);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_EditInfo();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "insert_", "textFieldStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_EditInfo> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_EditInfo.class) {
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