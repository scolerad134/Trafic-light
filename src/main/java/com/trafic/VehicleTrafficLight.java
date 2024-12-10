package com.trafic;

public class VehicleTrafficLight extends TrafficLight {
    public VehicleTrafficLight(int id) {
        super(id);
    }

    @Override
    public void processEvent(Event event) {
        if ("CHANGE_STATE".equals(event.getType())) {
            this.setState(event.getData());
            System.out.println("VehicleTrafficLight " + id + " state changed to " + state);
        }
    }
}