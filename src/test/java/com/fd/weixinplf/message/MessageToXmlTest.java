package com.fd.weixinplf.message;

import java.util.ArrayList;

import com.fd.weixinplf.message.util.XmlSerializerInitializer;
import com.thoughtworks.xstream.XStream;

import junit.framework.TestCase;

public class MessageToXmlTest extends TestCase {
    
    public void testWxMessage() {
        WxMessage msg = new WxMessage();
        msg.createTime = System.currentTimeMillis();
        msg.toUserName = "Lily";
        msg.fromUserName = "user";
        msg.msgType = WxMessage.MSG_TYPE_TEXT;
        msg.content = "test";
        XStream xstream = new XmlSerializerInitializer().initialize();
        xstream.processAnnotations(WxMessage.class);
        System.out.println(xstream.toXML(msg));
        String xmlString = "<xml><CreateTime>123123</CreateTime><ToUserName><![CDATA[hello]]></ToUserName></xml>";
        WxMessage fMsg = (WxMessage) xstream.fromXML(xmlString);
        System.out.println(fMsg.toUserName);
        System.out.println(fMsg.createTime);
        
        XStream xstream1 = new XmlSerializerInitializer().initialize();
        xstream1.processAnnotations(Message.class);
        xstream1.processAnnotations(TextMessage.class);
        xstream1.processAnnotations(ImageMessage.class);
        xstream1.processAnnotations(ArticleMessage.class);
        xstream1.omitField(Message.class, "msgId");
        TextMessage textMsg = new TextMessage();
        textMsg.content = "hello world";
        System.out.println(xstream1.toXML(textMsg));
        
        ImageMessage voiceMsg = new ImageMessage();
        voiceMsg.image = new ImageMessage.Image();
        voiceMsg.image.mediaId = "123";
        System.out.println(xstream1.toXML(voiceMsg));
        
        ArticleMessage articleMsg = new ArticleMessage(textMsg);
        articleMsg.articles = new ArrayList<>(1);
        ArticleMessage.Article article = new ArticleMessage.Article();
        article.description = "today's wether";
        articleMsg.articles.add(article);
        System.out.println(xstream1.toXML(articleMsg));
    }
}
