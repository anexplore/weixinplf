package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.NotThreadSafe;
import com.fd.weixinplf.message.MusicMessage;
import com.fd.weixinplf.message.MusicMessage.Music;
import com.fd.weixinplf.message.WxMessage;

@NotThreadSafe
public class MusicMessageBuilder extends MessageBuilder {
    
    private Music music;
    
    private MusicMessageBuilder() {}
    
    public static MusicMessageBuilder custom() {
        return new MusicMessageBuilder();
    }
    
    public MusicMessageBuilder setMusic(Music music) {
        this.music = music;
        return this;
    }
    
    public MusicBuilder newMusicBuilder() {
        return new MusicBuilder();
    }
    
    @Override public MusicMessage build() {
        MusicMessage msg = new MusicMessage(super.build());
        msg.music = music;
        msg.msgType = WxMessage.MSG_TYPE_MUSIC;
        return msg;
    }
    
    public class MusicBuilder {
        
        public String title;
        public String description;
        public String musicUrl; 
        public String hqMusicUrl;
        public String thumbMediaId;

        MusicBuilder() {}

        public MusicBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MusicBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MusicBuilder setMusicUrl(String musicUrl) {
            this.musicUrl = musicUrl;
            return this;
        }

        public MusicBuilder setHqMusicUrl(String hqMusicUrl) {
            this.hqMusicUrl = hqMusicUrl;
            return this;
        }

        public MusicBuilder setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
            return this;
        }
        
        public Music build() {
            Music music = new Music();
            music.thumbMediaId = thumbMediaId;
            music.description = description;
            music.hqMusicUrl = hqMusicUrl;
            music.musicUrl = musicUrl;
            music.title = title;
            return music;
        }
    }
}
