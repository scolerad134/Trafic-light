package com.trafic;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class TrafficLight {
    protected int id;
    protected String state;
    protected int queueSize;
    protected ConcurrentLinkedQueue<Event> eventQueue = new ConcurrentLinkedQueue<>();

    public TrafficLight(int id) {
        this.id = id;
        this.state = "RED";
        this.queueSize = 0;
    }

    public abstract void processEvent(Event event);

    public void addEvent(Event event) {
        eventQueue.add(event);
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public void updateQueueSize(int delta) {
        this.queueSize += delta;
    }
}

