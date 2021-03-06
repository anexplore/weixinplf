package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
/**
 * 图片消息，即作为微信推送消息也作为回复消息
 *
 */
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
