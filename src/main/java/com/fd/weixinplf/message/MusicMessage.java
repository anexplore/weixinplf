package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
/**
 * 音乐消息,仅作为回复消息使用
 * @author caoliuyi
 *
 */
@XStreamAlias("xml")
public class MusicMessage extends Message {

    public MusicMessage() {
        super();
    }
    
    public MusicMessage(Message message) {
        super(message);
    }
    
    @XStreamAlias("Music")
    public Music music;
    
    @XStreamAlias("Music")
    public static class Music {
        
        @XStreamAlias("Title")
        @XStreamConverter(value=XmlStringConverter.class)
        public String title;
        
        @XStreamAlias("Description")
        @XStreamConverter(value=XmlStringConverter.class)
        public String description;
        
        @XStreamAlias("MusicUrl")
        @XStreamConverter(value=XmlStringConverter.class)
        public String musicUrl; 
        
        @XStreamAlias("HQMusicUrl")
        @XStreamConverter(value=XmlStringConverter.class)
        public String hqMusicUrl;
        
        @XStreamAlias("ThumbMediaId")
        @XStreamConverter(value=XmlStringConverter.class)
        public String thumbMediaId;
    }
}
