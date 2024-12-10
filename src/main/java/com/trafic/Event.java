package com.trafic;

public class Event {
    private String type;
    private String data;
    private int senderId;

    public Event(String type, String data, int senderId) {
        this.type = type;
        this.data = data;
        this.senderId = senderId;
    }

    public String getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    public int getSenderId() {
        return senderId;
    }
}
