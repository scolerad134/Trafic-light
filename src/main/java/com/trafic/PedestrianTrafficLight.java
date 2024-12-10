package com.trafic;

public class PedestrianTrafficLight extends TrafficLight {
    public PedestrianTrafficLight(int id) {
        super(id);
    }

    @Override
    public void processEvent(Event event) {
        if ("CHANGE_STATE".equals(event.getType())) {
            this.setState(event.getData());
            System.out.println("PedestrianTrafficLight " + id + " state changed to " + state);
        }
    }
}