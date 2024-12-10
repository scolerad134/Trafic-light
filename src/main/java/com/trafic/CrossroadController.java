package com.trafic;

import java.util.ArrayList;
import java.util.List;

public class CrossroadController {
    private List<TrafficLight> trafficLights;

    public CrossroadController() {
        this.trafficLights = new ArrayList<>();
    }

    public void addTrafficLight(TrafficLight light) {
        trafficLights.add(light);
    }

    public void controlTraffic() {
        while (true) {
            for (TrafficLight light : trafficLights) {
                System.out.println("TrafficLight " + light.getId() + " has queue size " + light.getQueueSize());

                if (light.getQueueSize() > 10) {
                    light.addEvent(new Event("CHANGE_STATE", "GREEN", light.getId()));
                } else {
                    light.addEvent(new Event("CHANGE_STATE", "RED", light.getId()));
                }

                while (!light.eventQueue.isEmpty()) {
                    light.processEvent(light.eventQueue.poll());
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public List<TrafficLight> getTrafficLights() {

        return trafficLights;
    }

    public TrafficLight getTrafficLightById(int id) {
        return trafficLights.get(id);
    }

}
