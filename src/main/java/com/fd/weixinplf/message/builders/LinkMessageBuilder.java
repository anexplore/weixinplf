package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.message.LinkMessage;

public class LinkMessageBuilder extends MessageBuilder {
    
    private String title;
    private String description;
    private String url;
    
    private LinkMessageBuilder() {}
    
    public static LinkMessageBuilder custom() {
        return new LinkMessageBuilder();
    }

    public LinkMessageBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public LinkMessageBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public LinkMessageBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override public LinkMessage build() {
        LinkMessage msg = new LinkMessage(super.build());
        msg.title = title;
        msg.description = description;
        msg.url = url;
        return msg;
    }
    
}
