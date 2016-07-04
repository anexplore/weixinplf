package com.fd.weixinplf.message;

import java.util.List;

import com.fd.weixinplf.message.util.XmlStringConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
/**
 * 图文消息, 作为回复消息使用
 */
@XStreamAlias("xml")
public class ArticleMessage extends Message {
    
    public ArticleMessage() {
        super();
    }
    
    public ArticleMessage(Message message) {
        super(message);
    }
    
    @XStreamAlias("Articles")
    public List<Article> articles;
    
    @XStreamAlias("item")
    public static class Article {
        @XStreamAlias("Title")
        @XStreamConverter(value=XmlStringConverter.class)
        public String title;
        
        @XStreamAlias("Description")
        @XStreamConverter(value=XmlStringConverter.class)
        public String description;
        
        @XStreamAlias("PicUrl")
        @XStreamConverter(value=XmlStringConverter.class)
        public String picUrl;
        
        @XStreamAlias("Url")
        @XStreamConverter(value=XmlStringConverter.class)
        public String url;
        
    }
}
