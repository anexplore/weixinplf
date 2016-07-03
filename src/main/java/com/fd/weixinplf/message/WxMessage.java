package com.fd.weixinplf.message;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 微信消息
 * 
 * @author caoliuyi
 *
 */
@XStreamAlias("xml")
public class WxMessage {
    
    public static final String MSG_TYPE_TEXT = "text";
    public static final String MSG_TYPE_IMAGE = "image";
    public static final String MSG_TYPE_VOICE = "voice";
    public static final String MSG_TYPE_VIDEO = "video";
    public static final String MSG_TYPE_SHORT_VIDEO = "shortvideo";
    public static final String MSG_TYPE_LOCATION = "location";
    public static final String MSG_TYPE_LINK = "link";
    public static final String MSG_TYPE_EVENT = "event";
    
    // 微信号
    @XStreamAlias("ToUserName")
    @XStreamConverter(value=XmlStringConverter.class)
    public String toUserName;
    
    // 发送方帐号 openId
    @XStreamAlias("FromUserName")
    @XStreamConverter(value=XmlStringConverter.class)
    public String fromUserName;
    
    // 消息类型
    @XStreamAlias("MsgType")
    @XStreamConverter(value=XmlStringConverter.class)
    public String msgType;
    
    // 消息内容
    @XStreamAlias("Content")
    @XStreamConverter(value=XmlStringConverter.class)
    public String content;
    
    // 图片地址
    @XStreamAlias("PicUrl")
    @XStreamConverter(value=XmlStringConverter.class)
    public String picUrl;
    
    // 语音格式
    @XStreamAlias("Format")
    @XStreamConverter(value=XmlStringConverter.class)
    public String format;
    
    // 语音识别结果
    @XStreamAlias("Recognition")
    @XStreamConverter(value=XmlStringConverter.class)
    public String recognition;
    
    // 地理位置信息
    @XStreamAlias("Label")
    @XStreamConverter(value=XmlStringConverter.class)
    public String label;
    
    // 消息标题
    @XStreamAlias("Title")
    @XStreamConverter(value=XmlStringConverter.class)
    public String title;
    
    // 消息描述
    @XStreamAlias("Description")
    @XStreamConverter(value=XmlStringConverter.class)
    public String description;
    
    // 消息链接
    @XStreamAlias("Url")
    @XStreamConverter(value=XmlStringConverter.class)
    public String url;
    
    // 消息ID
    @XStreamAlias("MsgId")
    public long msgId;
    
    // 消息创建时间
    @XStreamAlias("CreateTime")
    public long createTime;
    
    // 媒体ID
    @XStreamAlias("MediaId")
    @XStreamConverter(value=XmlStringConverter.class)
    public String mediaId;
    
    // 缩略图ID
    @XStreamAlias("ThumbMediaId")
    @XStreamConverter(value=XmlStringConverter.class)
    public String thumbMediaId;
    
    // 地理位置维度
    @XStreamAlias("Location_X")
    public float locationX;
    
    // 地理位置经度
    @XStreamAlias("Location_Y")
    public float locationY;
    
    // 地图缩放大小
    @XStreamAlias("Scale")
    public int scale;

}
