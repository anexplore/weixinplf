package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.message.LocationMessage;

public class LocationMessageBuilder extends MessageBuilder {

    private float locationX;
    private float locationY;
    private int scale;
    private String label;
    
    private LocationMessageBuilder() {}
    
    public static LocationMessageBuilder custom() {
        return new LocationMessageBuilder();
    }

    public LocationMessageBuilder setLocationX(float locationX) {
        this.locationX = locationX;
        return this;
    }

    public LocationMessageBuilder setLocationY(float locationY) {
        this.locationY = locationY;
        return this;
    }

    public LocationMessageBuilder setScale(int scale) {
        this.scale = scale;
        return this;
    }

    public LocationMessageBuilder setLabel(String label) {
        this.label = label;
        return this;
    }
    
    @Override public LocationMessage build() {
        LocationMessage msg = new LocationMessage(super.build());
        msg.label = label;
        msg.locationX = locationX;
        msg.locationY = locationY;
        msg.scale = scale;
        return msg;
    }
    
}
