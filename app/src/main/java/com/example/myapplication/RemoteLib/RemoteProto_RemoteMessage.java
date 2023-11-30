package com.example.myapplication.RemoteLib;


import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.InputStream;

/* loaded from: classes4.dex */
public final class RemoteProto_RemoteMessage extends GeneratedMessageLite<RemoteProto_RemoteMessage, RemoteProto_RemoteMessage.Builder> implements MessageLiteOrBuilder {
    public static final int APPLINKLAUNCHREQUEST_FIELD_NUMBER = 90;
    public static final int CONFIGURE_FIELD_NUMBER = 1;
    private static final RemoteProto_RemoteMessage DEFAULT_INSTANCE;
    public static final int IMEBATCHEDIT_FIELD_NUMBER = 21;
    public static final int IMEKEYINJECT_FIELD_NUMBER = 20;
    public static final int IMESHOWREQUEST_FIELD_NUMBER = 22;
    public static final int KEYINJECT_FIELD_NUMBER = 10;
    private static volatile Parser<RemoteProto_RemoteMessage> PARSER = null;
    public static final int PINGREQUEST_FIELD_NUMBER = 8;
    public static final int PINGRESPONSE_FIELD_NUMBER = 9;
    public static final int SETACTIVE_FIELD_NUMBER = 2;
    public static final int VOICEBEGIN_FIELD_NUMBER = 30;
    public static final int VOICEEND_FIELD_NUMBER = 32;
    public static final int VOICEPAYLOAD_FIELD_NUMBER = 31;
    private int bitField0_;
    private Object request_;
    private int requestCase_ = 0;
    private byte memoizedIsInitialized = (byte) 2;

    /* loaded from: classes4.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RemoteProto_RemoteMessage, Builder> implements MessageLiteOrBuilder {
        public Builder() {
            super(RemoteProto_RemoteMessage.DEFAULT_INSTANCE);
        }

        public /* synthetic */ Builder(RemoteProto$1 remoteProto$1) {
            this();
        }

        public Builder setConfigure(RemoteProto_Configure RemoteProto_Configure) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setConfigure(RemoteProto_Configure);
            return this;
        }

        public Builder setKeyInject(RemoteProto_KeyInject RemoteProto_KeyInject) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setKeyInject(RemoteProto_KeyInject);
            return this;
        }

        public Builder setPingResponse(RemoteProto_PingResponse RemoteProto_PingResponse) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setPingResponse(RemoteProto_PingResponse);
            return this;
        }

        public Builder setSetActive(RemoteProto_SetActive remoteProto_SetActive) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setSetActive(remoteProto_SetActive);
            return this;
        }

        public Builder setVoiceBegin(RemoteProto_VoiceBegin remoteProto_VoiceBegin) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setVoiceBegin(remoteProto_VoiceBegin);
            return this;
        }

        public Builder setVoiceEnd(RemoteProto_VoiceEnd.Builder builder) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setVoiceEnd(builder.build());
            return this;
        }

        public Builder setVoicePayload(ByteString byteString) {
            copyOnWrite();
            ((RemoteProto_RemoteMessage) this.instance).setVoicePayload(byteString);
            return this;
        }
    }

    /* loaded from: classes4.dex */
    public enum RequestCase {
        CONFIGURE(1),
        SETACTIVE(2),
        PINGREQUEST(8),
        PINGRESPONSE(9),
        KEYINJECT(10),
        IMEKEYINJECT(20),
        IMEBATCHEDIT(21),
        IMESHOWREQUEST(22),
        VOICEBEGIN(30),
        VOICEPAYLOAD(31),
        VOICEEND(32),
        APPLINKLAUNCHREQUEST(90),
        REQUEST_NOT_SET(0);

        public final int value;

        RequestCase(int i) {
            this.value = i;
        }

        public static RequestCase forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 90) {
                            switch (i) {
                                case 8:
                                    return PINGREQUEST;
                                case 9:
                                    return PINGRESPONSE;
                                case 10:
                                    return KEYINJECT;
                                default:
                                    switch (i) {
                                        case 20:
                                            return IMEKEYINJECT;
                                        case 21:
                                            return IMEBATCHEDIT;
                                        case 22:
                                            return IMESHOWREQUEST;
                                        default:
                                            switch (i) {
                                                case 30:
                                                    return VOICEBEGIN;
                                                case 31:
                                                    return VOICEPAYLOAD;
                                                case 32:
                                                    return VOICEEND;
                                                default:
                                                    return null;
                                            }
                                    }
                            }
                        }
                        return APPLINKLAUNCHREQUEST;
                    }
                    return SETACTIVE;
                }
                return CONFIGURE;
            }
            return REQUEST_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }
    }

    static {
        RemoteProto_RemoteMessage RemoteProto_RemoteMessage = new RemoteProto_RemoteMessage();
        DEFAULT_INSTANCE = RemoteProto_RemoteMessage;
        GeneratedMessageLite.registerDefaultInstance(RemoteProto_RemoteMessage.class, RemoteProto_RemoteMessage);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RemoteProto_RemoteMessage parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return (RemoteProto_RemoteMessage) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (RemoteProto$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new RemoteProto_RemoteMessage();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\f\u0001\u0001\u0001Z\f\u0000\u0000\u0003\u0001ᐼ\u0000\u0002ြ\u0000\bြ\u0000\tြ\u0000\nြ\u0000\u0014ြ\u0000\u0015ြ\u0000\u0016ြ\u0000\u001eᐼ\u0000\u001fွ\u0000 ြ\u0000Zᐼ\u0000", new Object[]{"request_", "requestCase_", "bitField0_", RemoteProto_Configure.class, RemoteProto_SetActive.class, RemoteProto_PingRequest.class, RemoteProto_PingResponse.class, RemoteProto_KeyInject.class, RemoteProto_ImeKeyInject.class, RemoteProto_ImeBatchEdit.class, RemoteProto_ImeShowRequest.class, RemoteProto_VoiceBegin.class, RemoteProto_VoiceEnd.class, RemoteProto_AppLinkLaunchRequest.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RemoteProto_RemoteMessage> parser = PARSER;
                if (parser == null) {
                    synchronized (RemoteProto_RemoteMessage.class) {
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

    public RemoteProto_Configure getConfigure() {
        return this.requestCase_ == 1 ? (RemoteProto_Configure) this.request_ : RemoteProto_Configure.getDefaultInstance();
    }

    public RemoteProto_ImeBatchEdit getImeBatchEdit() {
        return this.requestCase_ == 21 ? (RemoteProto_ImeBatchEdit) this.request_ : RemoteProto_ImeBatchEdit.getDefaultInstance();
    }

    public RemoteProto_ImeKeyInject getImeKeyInject() {
        return this.requestCase_ == 20 ? (RemoteProto_ImeKeyInject) this.request_ : RemoteProto_ImeKeyInject.getDefaultInstance();
    }

    public RemoteProto_ImeShowRequest getImeShowRequest() {
        return this.requestCase_ == 22 ? (RemoteProto_ImeShowRequest) this.request_ : RemoteProto_ImeShowRequest.getDefaultInstance();
    }

    public RemoteProto_PingRequest getPingRequest() {
        return this.requestCase_ == 8 ? (RemoteProto_PingRequest) this.request_ : RemoteProto_PingRequest.getDefaultInstance();
    }

    public RequestCase getRequestCase() {
        return RequestCase.forNumber(this.requestCase_);
    }

    public final void setConfigure(RemoteProto_Configure RemoteProto_Configure) {
        RemoteProto_Configure.getClass();
        this.request_ = RemoteProto_Configure;
        this.requestCase_ = 1;
    }

    public final void setKeyInject(RemoteProto_KeyInject RemoteProto_KeyInject) {
        RemoteProto_KeyInject.getClass();
        this.request_ = RemoteProto_KeyInject;
        this.requestCase_ = 10;
    }

    public final void setPingResponse(RemoteProto_PingResponse RemoteProto_PingResponse) {
        RemoteProto_PingResponse.getClass();
        this.request_ = RemoteProto_PingResponse;
        this.requestCase_ = 9;
    }

    public final void setSetActive(RemoteProto_SetActive remoteProto$SetActive) {
        remoteProto$SetActive.getClass();
        this.request_ = remoteProto$SetActive;
        this.requestCase_ = 2;
    }

    public final void setVoiceBegin(RemoteProto_VoiceBegin remoteProto$VoiceBegin) {
        remoteProto$VoiceBegin.getClass();
        this.request_ = remoteProto$VoiceBegin;
        this.requestCase_ = 30;
    }

    public final void setVoiceEnd(RemoteProto_VoiceEnd remoteProto$VoiceEnd) {
        remoteProto$VoiceEnd.getClass();
        this.request_ = remoteProto$VoiceEnd;
        this.requestCase_ = 32;
    }

    public final void setVoicePayload(ByteString byteString) {
        byteString.getClass();
        this.requestCase_ = 31;
        this.request_ = byteString;
    }
}