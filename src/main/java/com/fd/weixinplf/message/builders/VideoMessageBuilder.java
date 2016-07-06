package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.VideoMessage;
import com.fd.weixinplf.message.VideoMessage.Video;
import com.fd.weixinplf.message.WxMessage;

@NotThreadSafe
public class VideoMessageBuilder extends MessageBuilder {

    private Video video;
    
    private VideoMessageBuilder() {}
    
    public static VideoMessageBuilder custom() {
        return new VideoMessageBuilder();
    }
    
    public VideoMessageBuilder setVideo(Video video) {
        this.video = video;
        return this;
    }
    
    public VideoBuilder newVideoBuilder() {
        return new VideoBuilder();
    }
    
    @Override public VideoMessage build() {
        VideoMessage msg = new VideoMessage(super.build());
        msg.video = video;
        msg.msgType = WxMessage.MSG_TYPE_VIDEO;
        return msg;
    }
    
    public class VideoBuilder {
        private String mediaId;
        private String title;
        private String description;
        private String thumbMediaId;
        
        VideoBuilder() {}
        
        public VideoBuilder setMediaId(String mediaId) {
            this.mediaId = mediaId;
            return this;
        }
        
        public VideoBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public VideoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }
        
        public VideoBuilder setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
            return this;
        }
        
        public Video build() {
            Video video = new Video();
            video.description = description;
            video.title = title;
            video.mediaId = mediaId;
            video.thumbMediaId = thumbMediaId;
            return video;
        }
    }
}
