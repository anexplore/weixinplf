package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.Message;

@NotThreadSafe
public class MessageBuilder {

    private String toUserName;
    private String fromUserName;
    private String msgType;
    private long createTime;
    private long msgId;

    protected MessageBuilder() {}
    
    public static MessageBuilder custom() {
        return new MessageBuilder();
    }
    
    public MessageBuilder setToUserName(String toUserName) {
        this.toUserName = toUserName;
        return this;
    }
    
    public MessageBuilder setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
        return this;
    }
    
    public MessageBuilder setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }
    
    public MessageBuilder setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }
    
    public MessageBuilder setMsgId(long msgId) {
        this.msgId = msgId;
        return this;
    }
    
    public Message build() {
        Message msg = new Message();
        msg.toUserName = toUserName;
        msg.fromUserName = fromUserName;
        msg.createTime = createTime;
        msg.msgId = msgId;
        msg.msgType = msgType;
        return msg;
    }
}
