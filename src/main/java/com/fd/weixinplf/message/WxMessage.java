package com.fd.weixinplf.message;

import com.fd.weixinplf.message.builders.EventMessageBuilder;
import com.fd.weixinplf.message.builders.ImageMessageBuilder;
import com.fd.weixinplf.message.builders.LinkMessageBuilder;
import com.fd.weixinplf.message.builders.LocationMessageBuilder;
import com.fd.weixinplf.message.builders.MessageBuilder;
import com.fd.weixinplf.message.builders.VideoMessageBuilder;
import com.fd.weixinplf.message.builders.VoiceMessageBuilder;
import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 微信消息
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
    
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";
    public static final String EVENT_TYPE_LOCATION = "LOCATION";
    public static final String EVENT_TYPE_CLICK = "CLICK";
    public static final String EVENT_TYPE_VIEW = "VIEW";
    public static final String EVENT_TYPE_SCAN = "SCAN";
    
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
    
    // 事件
    @XStreamAlias("Event")
    public String event;
    
    // KEY qrscene_12123
    @XStreamAlias("EventKey")
    public String eventKey;
    
    // 二维码ticket
    @XStreamAlias("Ticket")
    public String ticket;

    // 维度
    @XStreamAlias("Latitude")
    public float latitude;
    
    // 经度
    @XStreamAlias("Logitude")
    public float logitude;
    
    // 精度
    @XStreamAlias("Precision")
    public float precision;
    
    /**
     * @return 是否为文本消息
     */
    public boolean isTextMessage() {
        return msgType.equals(MSG_TYPE_TEXT);
    }
    
    /**
     * @return 是否为语音消息
     */
    public boolean isVoiceMessage() {
        return msgType.equals(MSG_TYPE_VOICE);
    }
    
    /**
     * @return 是否为视频消息
     */
    public boolean isVideoMessage() {
        return msgType.equals(MSG_TYPE_VIDEO);
    }
    
    /**
     * @return 是否为图片消息
     */
    public boolean isImageMessage() {
        return msgType.equals(MSG_TYPE_IMAGE);
    }
    
    /**
     * @return 是否为短视频消息
     */
    public boolean isShortVideoMessage() {
        return msgType.equals(MSG_TYPE_SHORT_VIDEO);
    }
    
    /**
     * @return 是否为地理位置消息
     */
    public boolean isLocationMessage() {
        return msgType.equals(MSG_TYPE_LOCATION);
    }
    
    /**
     * @return 是否为链接消息
     */
    public boolean isLinkMessage() {
        return msgType.equals(MSG_TYPE_LINK);
    }
    
    /**
     * @return 是否为事件消息
     */
    public boolean isEventMessage() {
        return msgType.equals(MSG_TYPE_EVENT);
    }
    
    /**
     * @return Message 转换为Message
     */
    public Message toMessage() {
        return MessageBuilder.custom().setCreateTime(createTime)
                .setFromUserName(fromUserName).setMsgId(msgId)
                .setMsgType(msgType).setToUserName(toUserName).build();
    }
    
    /**
     * @return ImageMessage 转换为图片消息
     */
    public ImageMessage toImageMessage(){
        if (!isImageMessage()) {
            throw new RuntimeException(msgType + " cannot be convert to image message");
        }
        ImageMessageBuilder builder = ImageMessageBuilder.custom();
        builder.createImage(mediaId).setCreateTime(createTime)
                .setFromUserName(fromUserName).setMsgId(msgId).setMsgType(msgType)
                .setToUserName(toUserName);
        return builder.build();
    }
    
    /**
     * @return VoiceMessage 转换为语音消息
     */
    public VoiceMessage toVoiceMessage() {
        if (!isVoiceMessage()) {
            throw new RuntimeException(msgType + " message cannot be convert to voice message");
        }
        VoiceMessageBuilder builder = VoiceMessageBuilder.custom();
        builder.createVoice(mediaId).setFromUserName(fromUserName)
                .setCreateTime(createTime).setMsgId(msgId)
                .setMsgType(msgType).setToUserName(toUserName);
        return builder.build();
    }
    
    /**
     * @return VideoMessage 转换为视频消息
     */
    public VideoMessage toVideoMessage() {
        if (!isVideoMessage() && !isShortVideoMessage()) {
            throw new RuntimeException(msgType + " message cannot be convert to video message");
        }
        VideoMessageBuilder builder = VideoMessageBuilder.custom();
        builder.setCreateTime(createTime).setFromUserName(fromUserName)
                .setMsgId(msgId).setMsgType(msgType)
                .setToUserName(toUserName);
        builder.setVideo(builder.newVideoBuilder()
                .setDescription(description)
                .setMediaId(mediaId)
                .setTitle(title)
                .setThumbMediaId(thumbMediaId)
                .build());
        return builder.build();
    }
    
    /**
     * @return LocationMessage 转换为地理位置信息
     */
    public LocationMessage toLocationMessage() {
        if (!isLocationMessage()) {
            throw new RuntimeException(msgType + " message cannot be convert to location message");
        }
        LocationMessageBuilder builder = LocationMessageBuilder.custom();
        builder.setCreateTime(createTime).setFromUserName(fromUserName)
                .setMsgId(msgId).setMsgType(msgType).setToUserName(toUserName);
        builder.setLabel(label).setLocationX(locationX).setLocationY(locationY)
                .setScale(scale);
        return builder.build();
    }
    
    /**
     * @return LinkMessage 转换为链接消息
     */
    public LinkMessage toLinkMessage() {
        if (!isLinkMessage()) {
            throw new RuntimeException(msgType + " message cannot be convert to link message");
        }
        LinkMessageBuilder builder = LinkMessageBuilder.custom();
        builder.setCreateTime(createTime).setFromUserName(fromUserName)
                .setMsgId(msgId).setMsgType(msgType).setToUserName(toUserName);
        builder.setTitle(title).setUrl(url).setDescription(description);
        return builder.build();
    }
    
    /**
     * @return EventMessage 转化为事件消息
     */
    public EventMessage toEventMessage() {
        if (!isEventMessage()) {
            throw new RuntimeException(msgType + " message cannot be convert to event message");
        }
        EventMessageBuilder builder = EventMessageBuilder.custom();
        builder.setCreateTime(createTime).setFromUserName(fromUserName)
                .setMsgType(msgType).setToUserName(toUserName);
        builder.setEvent(event).setEventKey(eventKey).setLatitude(latitude)
                .setLogitude(logitude).setPrecision(precision);
        return builder.build();
    }
}
