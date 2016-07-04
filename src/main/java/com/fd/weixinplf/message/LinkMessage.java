package com.fd.weixinplf.message;
/**
 * 链接信息,仅限于微信服务器推送消息,不可作为回复消息
 *
 */
public class LinkMessage extends Message {
    
    public LinkMessage() {}
    
    public LinkMessage(Message build) {
        super(build);
    }
    
    public String title;
    public String description;
    public String url;
    
}
