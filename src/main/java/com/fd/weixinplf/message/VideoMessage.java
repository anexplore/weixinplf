package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

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
    }
}
