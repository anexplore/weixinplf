package com.fd.weixinplf.message;

public class EventMessage extends Message {

    public String event;
    public String eventKey;
    public float latitude;
    public float logitude;
    public float precision;

    public EventMessage() {}
    
    public EventMessage(Message message) {
        super(message);
    }
    
    public boolean isSubscribeEvent() {
        return event.equals(WxMessage.EVENT_TYPE_SUBSCRIBE);
    }
    
    public boolean isUnSubcribeEvent() {
        return event.equals(WxMessage.EVENT_TYPE_UNSUBSCRIBE);
    }
    
    public boolean isMenuClickedEvent() {
        return event.equals(WxMessage.EVENT_TYPE_CLICK);
    }
    
    public boolean isMenuUrlRedirectEvent() {
        return event.equals(WxMessage.EVENT_TYPE_VIEW);
    }
    
    public boolean isLocationEvent() {
        return event.equals(WxMessage.EVENT_TYPE_LOCATION);
    }
    
    public boolean isQRScanEvent() {
        return event.equals(WxMessage.EVENT_TYPE_SCAN);
    }
    
    public boolean isQRSubscribe() {
      return isSubscribeEvent() && eventKey != null && !eventKey.isEmpty();  
    }
}
