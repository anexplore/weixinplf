package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
/**
 * 文本消息,既可以作为推送消息也可以作为回复消息
 */
@XStreamAlias("xml")
public class TextMessage extends Message {
    
    public TextMessage() {
        super();
    }
    
    public TextMessage(Message message) {
        super(message);
    }
    
    @XStreamAlias("Content")
    @XStreamConverter(value=XmlStringConverter.class)
    public String content;

}
