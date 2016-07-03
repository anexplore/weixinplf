package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.VoiceMessage;
import com.fd.weixinplf.message.VoiceMessage.Voice;

@NotThreadSafe
public class VoiceMessageBuilder extends MessageBuilder {
    
    private Voice voice;
    
    private VoiceMessageBuilder() {}
    
    public static VoiceMessageBuilder custom() {
        return new VoiceMessageBuilder();
    }
    
    public VoiceMessageBuilder setVoice(Voice voice) {
        this.voice = voice;
        return this;
    }
    
    public VoiceMessageBuilder createVoice(String mediaId) {
        voice = new Voice();
        voice.mediaId = mediaId;
        return this;
    }
    
    @Override public VoiceMessage build() {
        VoiceMessage msg = new VoiceMessage(super.build());
        msg.voice = voice;
        return msg;
    }
}
