package com.fd.weixinplf.message.util;

import com.fd.weixinplf.message.ArticleMessage;
import com.fd.weixinplf.message.ImageMessage;
import com.fd.weixinplf.message.Message;
import com.fd.weixinplf.message.MusicMessage;
import com.fd.weixinplf.message.TextMessage;
import com.fd.weixinplf.message.VideoMessage;
import com.fd.weixinplf.message.VoiceMessage;
import com.fd.weixinplf.message.WxMessage;
import com.fd.weixinplf.message.VideoMessage.Video;
import com.thoughtworks.xstream.XStream;

public class XmlFactory {
    
    public static XStream newSerializer() {
        return new XmlSerializerInitializer().initialize();
    }
    
    /**
     * @return XStream 文本消息xml序列化工具
     */
    public static XStream newTextMessageSerializer() {
        XStream xstream = newSerializer();
        xstream.processAnnotations(Message.class);
        xstream.processAnnotations(TextMessage.class);
        xstream.omitField(Message.class, "msgId");
        return xstream;
    }
    
    /**
     * @return XStream 图片消息xml序列化工具
     */
    public static XStream newImageMessageSerializer() {
        XStream xstream = newSerializer();
        xstream.processAnnotations(Message.class);
        xstream.processAnnotations(ImageMessage.class);
        xstream.omitField(Message.class, "msgId");
        return xstream;
    }
    
    /**
     * @return XStream 语音消息xml序列化工具
     */
    public static XStream newVoiceMessageSerializer() {
        XStream xstream = newSerializer();
        xstream.processAnnotations(Message.class);
        xstream.processAnnotations(VoiceMessage.class);
        xstream.omitField(Message.class, "msgId");
        return xstream;
    }
    
    /**
     * @return XStream 视频消息xml序列化工具
     */
    public static XStream newVideoMessageSerializer() {
        XStream xstream = newSerializer();
        xstream.processAnnotations(Message.class);
        xstream.processAnnotations(VideoMessage.class);
        xstream.omitField(Message.class, "msgId");
        xstream.omitField(Video.class, "thumbMediaId");
        return xstream;
    }
    
    /**
     * @return XStream 音乐消息xml序列化工具
     */
    public static XStream newMusicMessageSerializer() {
        XStream xstream = newSerializer();
        xstream.processAnnotations(Message.class);
        xstream.processAnnotations(MusicMessage.class);
        xstream.omitField(Message.class, "msgId");
        return xstream;
    }
    
    /**
     * @return XStream 图片消息xml序列化工具
     */
    public static XStream newArticleMessageSerializer() {
        XStream xstream = newSerializer();
        xstream.processAnnotations(Message.class);
        xstream.processAnnotations(ArticleMessage.class);
        xstream.omitField(Message.class, "msgId");
        return xstream;
    }
    
    /**
     * @return XStream 消息反序列化
     */
    public static XStream newDeserializer() {
        return new XmlDeserializerInitializer().initialize();
    }
    
    /**
     * @return XStream WxMessage消息反序列化
     */
    public static XStream newWxMessageDeserializer() {
        XStream xstream = new XmlDeserializerInitializer().initialize();
        xstream.processAnnotations(WxMessage.class);
        xstream.ignoreUnknownElements();
        return xstream;
    }
}
