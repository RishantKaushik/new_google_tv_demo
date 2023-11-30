package com.example.myapplication.RemoteLib;


import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_ImeKeyInject extends GeneratedMessageLite<RemoteProto_ImeKeyInject, RemoteProto_ImeKeyInject.Builder> implements MessageLiteOrBuilder {
    public static final int APPINFO_FIELD_NUMBER = 1;
    private static final RemoteProto_ImeKeyInject DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_ImeKeyInject> PARSER = null;
    public static final int TEXTFIELDSTATUS_FIELD_NUMBER = 2;
    private RemoteProto_AppInfo appInfo_;
    private int bitField0_;
    private RemoteProto_TextFieldStatus textFieldStatus_;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_ImeKeyInject, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_ImeKeyInject.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_ImeKeyInject RemoteProto_ImeKeyInject = new RemoteProto_ImeKeyInject();
        DEFAULT_INSTANCE = RemoteProto_ImeKeyInject;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_ImeKeyInject.class, RemoteProto_ImeKeyInject);
    }

    public static RemoteProto_ImeKeyInject getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_ImeKeyInject();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "appInfo_", "textFieldStatus_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_ImeKeyInject> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_ImeKeyInject.class) {
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

    public RemoteProto_AppInfo getAppInfo() {
        RemoteProto_AppInfo remoteProto$AppInfo = this.appInfo_;
        return remoteProto$AppInfo == null ? RemoteProto_AppInfo.getDefaultInstance() : remoteProto$AppInfo;
    }

    public RemoteProto_TextFieldStatus getTextFieldStatus() {
        RemoteProto_TextFieldStatus remoteProto$TextFieldStatus = this.textFieldStatus_;
        return remoteProto$TextFieldStatus == null ? RemoteProto_TextFieldStatus.getDefaultInstance() : remoteProto$TextFieldStatus;
    }

    public boolean hasAppInfo() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasTextFieldStatus() {
        return (this.bitField0_ & 2) != 0;
    }
}