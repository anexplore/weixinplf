package com.fd.weixinplf.message;

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

    public boolean isTextMessage() {
        return msgType.equals(MSG_TYPE_TEXT);
    }
    
    public boolean isVoiceMessage() {
        return msgType.equals(MSG_TYPE_VOICE);
    }
    
    public boolean isVideoMessage() {
        return msgType.equals(MSG_TYPE_VIDEO);
    }
    
    public boolean isImageMessage() {
        return msgType.equals(MSG_TYPE_IMAGE);
    }
    
    public boolean isShortVideoMessage() {
        return msgType.equals(MSG_TYPE_SHORT_VIDEO);
    }
    
    public boolean isLocationMessage() {
        return msgType.equals(MSG_TYPE_LOCATION);
    }
    
    public boolean isLinkMessage() {
        return msgType.equals(MSG_TYPE_LINK);
    }
    
    public boolean isEventMessage() {
        return msgType.equals(MSG_TYPE_EVENT);
    }
    
    public Message toMessage() {
        return MessageBuilder.custom().setCreateTime(createTime)
                .setFromUserName(fromUserName).setMsgId(msgId)
                .setMsgType(msgType).setToUserName(toUserName).build();
    }
    
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
}
