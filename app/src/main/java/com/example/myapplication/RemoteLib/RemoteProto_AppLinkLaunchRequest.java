package com.example.myapplication.RemoteLib;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;

/* loaded from: classes4.dex */
public final class RemoteProto_AppLinkLaunchRequest extends GeneratedMessageLite<RemoteProto_AppLinkLaunchRequest, RemoteProto_AppLinkLaunchRequest.Builder> implements MessageLiteOrBuilder {
    public static final int APP_LINK_FIELD_NUMBER = 1;
    private static final RemoteProto_AppLinkLaunchRequest DEFAULT_INSTANCE;
    private static volatile Parser<RemoteProto_AppLinkLaunchRequest> PARSER;
    private int bitField0_;
    private byte memoizedIsInitialized = (byte) 2;
    private String appLink_ = "";

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_AppLinkLaunchRequest, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_AppLinkLaunchRequest.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }
    }

    static {
        RemoteProto_AppLinkLaunchRequest RemoteProto_AppLinkLaunchRequest = new RemoteProto_AppLinkLaunchRequest();
        DEFAULT_INSTANCE = RemoteProto_AppLinkLaunchRequest;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_AppLinkLaunchRequest.class, RemoteProto_AppLinkLaunchRequest);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_AppLinkLaunchRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001ᔈ\u0000", new Object[]{"bitField0_", "appLink_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_AppLinkLaunchRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_AppLinkLaunchRequest.class) {
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
}