package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

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
