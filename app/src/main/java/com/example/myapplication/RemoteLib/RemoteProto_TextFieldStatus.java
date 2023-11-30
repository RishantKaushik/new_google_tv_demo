package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_TextFieldStatus extends GeneratedMessageLite<RemoteProto_TextFieldStatus, RemoteProto_TextFieldStatus.Builder> implements MessageLiteOrBuilder {
    public static final int COUNTER_FIELD_FIELD_NUMBER = 1;
    private static final RemoteProto_TextFieldStatus DEFAULT_INSTANCE;
    public static final int END_FIELD_NUMBER = 4;
    public static final int INT5_FIELD_NUMBER = 5;
    public static final int LABEL_FIELD_NUMBER = 6;
    private static volatile Parser<RemoteProto_TextFieldStatus> PARSER = null;
    public static final int START_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int counterField_;
    private int end_;
    private int int5_;
    private int start_;
    private String value_ = "";
    private String label_ = "";

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_TextFieldStatus, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_TextFieldStatus.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_TextFieldStatus RemoteProto_TextFieldStatus = new RemoteProto_TextFieldStatus();
        DEFAULT_INSTANCE = RemoteProto_TextFieldStatus;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_TextFieldStatus.class, RemoteProto_TextFieldStatus);
    }

    public static RemoteProto_TextFieldStatus getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke.ordinal()) {
            case 1:
                return new RemoteProto_TextFieldStatus();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005", new Object[]{"bitField0_", "counterField_", "value_", "start_", "end_", "int5_", "label_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_TextFieldStatus> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_TextFieldStatus.class) {
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