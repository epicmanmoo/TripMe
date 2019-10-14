package com.example.tripme;

import java.util.*;

public class TripMaker {
    String zipCode;
    public TripMaker() {
        zipCode = "98105";
    }

    public static void main(String[] args) {
        List<Events> day = buildDay("98105");
    }

    public static List<Events> buildDay(String zipCode) {
        Events curEvent;
        int timeLeft = 540;
        List<Events> day = new ArrayList<Events>();

        List<Result> hotels = Main.getList(zipCode,"Hotels");
        Events startHotel = new Events(hotels.get(0).getName(), "Hotels", 120, hotels.get(0));
        curEvent = startHotel;

        List<Result> destinations = Main.getList(zipCode,"Attractions");
        Events firstEvent =  new Events(destinations.get(0).getName(), "Attractions", 30,
                destinations.get(0));
        Events secondEvent =  new Events(destinations.get(1).getName(), "Attractions", 30,
                destinations.get(1));
        Events thirdEvent =  new Events(destinations.get(2).getName(), "Attractions", 30,
                destinations.get(2));
        Events fourthEvent =  new Events(destinations.get(3).getName(), "Attractions", 30,
                destinations.get(3));
        Events fifthEvent =  new Events(destinations.get(4).getName(), "Attractions", 30,
                destinations.get(4));



        List<Result> restaurants = Main.getList(zipCode,"Restaurants");

        Events firstMeal =  new Events(restaurants.get(0).getName(), "Restaurants", 20,
                restaurants.get(0));
        Events secondMeal =  new Events(restaurants.get(1).getName(), "Restaurants", 18,
                restaurants.get(1));
        Events thirdMeal =  new Events(restaurants.get(2).getName(), "Restaurants", 15,
                restaurants.get(2));



        // add hotel
        day.add(startHotel);
        // hotel to food

        addTransport(startHotel, firstMeal, day);
        addTransport(firstMeal, firstEvent, day);
        addTransport(firstEvent, secondEvent, day);
        addTransport(secondEvent, secondMeal, day);
        addTransport(secondMeal, thirdEvent, day);
        addTransport(thirdEvent, fourthEvent, day);
        addTransport(fourthEvent, thirdMeal, day);
        addTransport(thirdMeal, fifthEvent, day);
        addTransport(fifthEvent, startHotel, day);


        for (Events e : day) {
            System.out.println(e.place + " " + (e.place.equals("Lyft") ? e.getUberDuration() : ""));

        }
        return day;
    }

    public static void addTransport(Events e1, Events e2, List<Events> day) {
        // add the time it takes to get to e1 to e2 into the list then add e2 after.
        Events lunchToDest = new Events(e1.getRes(), e2.getRes());
        lunchToDest.setType("Transit");
        lunchToDest.uberPrice = lunchToDest.getUberPrice();
        day.add(lunchToDest);
        day.add(e2);
    }
}
