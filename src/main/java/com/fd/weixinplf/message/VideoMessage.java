package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * (小)视频消息 即可以作为推送消息也可以作为回复消息
 * @author caoliuyi
 *
 */
@XStreamAlias("xml")
public class VideoMessage extends Message {

    public VideoMessage() {
        super();
    }
    
    public VideoMessage(Message message) {
        super(message);
    }
    
    @XStreamAlias("Video")
    public Video video;
    
    @XStreamAlias("Video")
    public static class Video {
        
        @XStreamAlias("MediaId")
        @XStreamConverter(value=XmlStringConverter.class)
        public String mediaId;
        
        @XStreamAlias("Title")
        @XStreamConverter(value=XmlStringConverter.class)
        public String title;
        
        @XStreamAlias("Description")
        @XStreamConverter(value=XmlStringConverter.class)
        public String description;
        
        @XStreamAlias("ThumbMediaId")
        @XStreamConverter(value=XmlStringConverter.class)
        // 作为回复消息时没有此项
        public String thumbMediaId;
    }
}
