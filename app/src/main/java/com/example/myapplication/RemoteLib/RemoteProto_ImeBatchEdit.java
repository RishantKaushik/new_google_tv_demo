package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_ImeBatchEdit extends GeneratedMessageLite<RemoteProto_ImeBatchEdit, RemoteProto_ImeBatchEdit.Builder> implements MessageLiteOrBuilder {
    private static final RemoteProto_ImeBatchEdit DEFAULT_INSTANCE;
    public static final int EDIT_INFO_FIELD_NUMBER = 3;
    public static final int FIELD_COUNTER_FIELD_NUMBER = 2;
    public static final int IME_COUNTER_FIELD_NUMBER = 1;
    private static volatile Parser<RemoteProto_ImeBatchEdit> PARSER;
    private int bitField0_;
    private Internal.ProtobufList<RemoteProto_EditInfo> editInfo_ = GeneratedMessageLite.emptyProtobufList();
    private int fieldCounter_;
    private int imeCounter_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_ImeBatchEdit, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_ImeBatchEdit.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_ImeBatchEdit RemoteProto_ImeBatchEdit = new RemoteProto_ImeBatchEdit();
        DEFAULT_INSTANCE = RemoteProto_ImeBatchEdit;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_ImeBatchEdit.class, RemoteProto_ImeBatchEdit);
    }

    public static RemoteProto_ImeBatchEdit getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_ImeBatchEdit();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003\u001b", new Object[]{"bitField0_", "imeCounter_", "fieldCounter_", "editInfo_", RemoteProto_EditInfo.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_ImeBatchEdit> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_ImeBatchEdit.class) {
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

    public int getImeCounter() {
        return this.imeCounter_;
    }
}