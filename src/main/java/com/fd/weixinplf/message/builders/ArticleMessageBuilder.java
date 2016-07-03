package com.fd.weixinplf.message.builders;

import java.util.ArrayList;
import java.util.List;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.ArticleMessage;
import com.fd.weixinplf.message.ArticleMessage.Article;

@NotThreadSafe
public class ArticleMessageBuilder extends MessageBuilder {
    
    private List<Article> articles;
    
    private ArticleMessageBuilder() {}
    
    public static ArticleMessageBuilder custom() {
        return new ArticleMessageBuilder();
    }

    public void addArticle(Article article) {
        if (article == null) {
            throw new NullPointerException("article may not be null");
        }
        if (articles == null) {
            articles = new ArrayList<>(3);
        }
        articles.add(article);
    }
    
    public ArticleBuilder newArticleBuilder() {
        return new ArticleBuilder();
    }
    
    @Override public ArticleMessage build() {
        ArticleMessage articleMsg = new ArticleMessage(super.build());
        articleMsg.articles = articles;
        return articleMsg;
    }
    
    public class ArticleBuilder {
        
        private String title;
        private String description;
        private String picUrl;
        private String url;
        
        ArticleBuilder() {}
        
        public ArticleBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public ArticleBuilder setDescription(String description) {
            this.description = description;
            return this;
        }
        
        public ArticleBuilder setPicUrl(String picUrl) {
            this.picUrl = picUrl;
            return this;
        }
        
        public ArticleBuilder setUrl(String url) {
            this.url = url;
            return this;
        }
        
        public Article build() {
            Article article = new Article();
            article.description = description;
            article.title = title;
            article.picUrl = picUrl;
            article.url = url;
            return article;
        }
    }
}
