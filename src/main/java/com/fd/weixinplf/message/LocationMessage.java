package com.fd.weixinplf.message;
/**
 * 地理位置信息,尽可作为微信服务器推送消息,不可作为回复消息
 * @author caoliuyi
 *
 */
public class LocationMessage extends Message {
    
    public LocationMessage() {}
    
    public LocationMessage(Message message) {
        super(message);
    }
    
    // 维度
    public float locationX;
    // 经度
    public float locationY;
    // 缩放比例
    public int scale;
    // 标签
    public String label;
}
