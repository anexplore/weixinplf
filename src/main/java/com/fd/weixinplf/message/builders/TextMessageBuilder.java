package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.TextMessage;
import com.fd.weixinplf.message.WxMessage;

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
        textMsg.msgType = WxMessage.MSG_TYPE_TEXT;
        return textMsg;
    }
    
}
