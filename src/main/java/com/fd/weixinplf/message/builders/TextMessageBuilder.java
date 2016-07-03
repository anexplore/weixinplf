package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.TextMessage;

@NotThreadSafe
public class TextMessageBuilder extends MessageBuilder {
    
    private String content;
    
    private TextMessageBuilder() {}
    
    public static TextMessageBuilder custom() {
        return new TextMessageBuilder();
    }
    
    public TextMessageBuilder setContent(String content) {
        this.content = content;
        return this;
    }
    
    @Override public TextMessage build() {
        TextMessage textMsg = new TextMessage(super.build());
        textMsg.content = content;
        return textMsg;
    }
    
}
