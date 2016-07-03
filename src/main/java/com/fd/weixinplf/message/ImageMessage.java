package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class ImageMessage extends Message {
    
    public ImageMessage() {
        super();
    }
    
    public ImageMessage(Message message) {
        super(message);
    }
    
    @XStreamAlias("Image")
    public Image image;
    
    @XStreamAlias("Image")
    public static class Image {
        @XStreamAlias("MediaId")
        @XStreamConverter(value=XmlStringConverter.class)
        public String mediaId;
    }
}
