package com.summer.mvpandroidframe.data;

public class MessageEvent {
    private String message;
    public MessageEvent(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
