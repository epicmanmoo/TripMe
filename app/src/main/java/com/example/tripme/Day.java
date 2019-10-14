package com.example.tripme;

import java.util.*;


public class Day {
    List<Event> events;
    int sumTime;

    public Day() {
        sumTime = 0;
        events = new ArrayList<Event>();
    }

    public boolean addEvent(Event e1) {
        if (e1.getTime() + sumTime < 24) {
            events.add(e1);
            sumTime += e1.getTime();
            return true;
        }
        return false;
    }

    public int timeLeft() {
        return sumTime - 24*60;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void updateEvent(Event e1, Event e2) {
        for (Event event : events) {
            if (events.equals(e1)) {
                updateEventDuration(e1, e1.getTime());
                event = e2;
            }
        }
    }

    public boolean updateEventDuration(Event e1, int newTime) {
        for (Event el : events) {
            if (el.equals(e1)) {
                e1.updateEventTime(newTime);
                return true;
            }
        }
        return false;
    }

}
