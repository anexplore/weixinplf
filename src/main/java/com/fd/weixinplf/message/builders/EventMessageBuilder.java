package com.fd.weixinplf.message.builders;

import com.fd.weixinplf.message.EventMessage;

public class EventMessageBuilder extends MessageBuilder {
    
    private String event;
    private String eventKey;
    private float latitude;
    private float logitude;
    private float precision;
    
    private EventMessageBuilder() {}
    
    public static EventMessageBuilder custom() {
        return new EventMessageBuilder();
    }

    public EventMessageBuilder setEvent(String event) {
        this.event = event;
        return this;
    }

    public EventMessageBuilder setEventKey(String eventKey) {
        this.eventKey = eventKey;
        return this;
    }

    public EventMessageBuilder setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public EventMessageBuilder setLogitude(float logitude) {
        this.logitude = logitude;
        return this;
    }

    public EventMessageBuilder setPrecision(float precision) {
        this.precision = precision;
        return this;
    }

    @Override public EventMessage build() {
        EventMessage msg = new EventMessage(super.build());
        msg.event = event;
        msg.eventKey = eventKey;
        msg.latitude = latitude;
        msg.logitude = logitude;
        msg.precision = precision;
        return msg;
    }
}
