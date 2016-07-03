package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.ImageMessage;
import com.fd.weixinplf.message.ImageMessage.Image;

@NotThreadSafe
public class ImageMessageBuilder extends MessageBuilder {
    
    private Image image;
    
    private ImageMessageBuilder() {}
    
    public static ImageMessageBuilder custom() {
        return new ImageMessageBuilder();
    }

    public ImageMessageBuilder setImage(Image image) {
        this.image = image;
        return this;
    }
    
    public ImageMessageBuilder createImage(String mediaId) {
        image = new Image();
        image.mediaId = mediaId;
        return this;
    }
    
    @Override public ImageMessage build() {
        ImageMessage msg = new ImageMessage(super.build());
        msg.image = image;
        return msg;
    }
}
