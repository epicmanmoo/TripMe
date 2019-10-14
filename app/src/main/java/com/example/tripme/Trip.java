package com.example.tripme;

import java.util.*;

public class Trip {
    ArrayList<Day> days;

    String img;
    int numTrips;
    String tripName;

    public Trip(String img, String tripName) {
        this.img = img;
        this.tripName = tripName;
    }

    public void addDay(Day d1) {
        days.add(d1);
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        String otherName = ((Trip) o).tripName;
        return tripName.equals(otherName);
    }
}
