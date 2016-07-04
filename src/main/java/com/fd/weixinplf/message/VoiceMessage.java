package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 语音消息 即可以作为推送消息也可以作为回复消息
 * @author caoliuyi
 *
 */
@XStreamAlias("xml")
public class VoiceMessage extends Message {
    
    public VoiceMessage() {
        super();
    }
    
    public VoiceMessage(Message message) {
        super(message);
    }
    
    @XStreamAlias("Voice")
    public Voice voice;
    
    @XStreamAlias("Voice")
    public static class Voice {
        @XStreamAlias("MediaId")
        @XStreamConverter(value=XmlStringConverter.class)
        public String mediaId;
    }
}
