package com.example.tripme;

import java.util.*;

enum EventType {
    TRANSPORT, DEST, SLEEP
}

public class Event {
    int duration;
    double lat;
    double lng;
    int averageDuration;
    EventType type;
    String pic;
    String name;
    int cost;

    int start;
    int end;

    public Event() {
        duration = 0;
    }

    public void setAverageDuration(int averageDuration) {
        this.averageDuration = averageDuration;
    }

    public String getName() {
        return name;
    }

    public Event(double lat, double lng, int duration, EventType eventType, String name,
                 String pic, int cost) {
        this.pic = pic;
        this.lat = lat;
        this.lng = lng;
        this.duration = duration;
        this.type = eventType;
        this.name = name;
        this.cost = cost;
    }

    public EventType getEventType() {
        return type;
    }

    public int getTime() {
        return duration;
    }

     public boolean updateEventTime(int newTime) {
         duration = newTime;
        return true;
     }

     public double[] getLocation() {
        double[] locations = {lat, lng};
        return locations;
     }

     public void updateLocation(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
     }

    @Override
    public boolean equals(Object o) {
        String otherName = ((Event) o).getName();
        return name.equals(otherName);
     }

}
