package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@XStreamAlias("xml")
public class Message {

    public Message() {
        System.out.println("called");
    }
    
    public Message(Message message) {
        toUserName = message.toUserName;
        fromUserName = message.fromUserName;
        msgType = message.msgType;
        createTime = message.createTime;
        msgId = message.msgId;
    }
    
    @XStreamAlias("ToUserName")
    @XStreamConverter(value=XmlStringConverter.class)
    public String toUserName;
    
    @XStreamAlias("FromUserName")
    @XStreamConverter(value=XmlStringConverter.class)
    public String fromUserName;
    
    @XStreamAlias("MsgType")
    @XStreamConverter(value=XmlStringConverter.class)
    public String msgType;
    
    @XStreamAlias("CreateTime")
    public long createTime;
    
    @XStreamAlias("MsgId")
    public long msgId;
}
