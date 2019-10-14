package com.example.tripme;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
//import com.google.gson.Gson;
import com.google.gson.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {
        List<Result> listRestaurants = getList("98021","Restaurants");

        int uberPrice = getPrice(listRestaurants.get(0), listRestaurants.get(1));;
        String getTime = getTime(listRestaurants.get(0), listRestaurants.get(1));

        System.out.println("get Time = " + getTime);
        System.out.println("price = " + uberPrice);

        List<Result> destinations = getList("98105","Attractions");
        List<Result> hotels = getList("98105","Hotels");

    }

    public static String getTime(Result r1, Result r2) {
        Example el = getTravelInfo(r1, r2);
        return getDistance(el);
    }

    public static int getPrice(Result r1, Result r2) {
        Example el = getTravelInfo(r1, r2);
        return getPrice(el);
    }

    public static List<Result> getList(String zip, String type){
        String url = "https://maps.googleapis" +
                ".com/maps/api/place/textsearch/json?query="+type+"+in+"+zip+"&key" +
                APIKeysLOL.GET_LIST_KEY;
        return getInfo(url);
    }

    public static String getDistance(Example ex) {
        return ex.getRows().get(0).getElements().get(0).getDuration().getText();
    }

    public static int getPrice(Example ex) {
        return (Integer.parseInt(ex.getRows().get(0).getElements().get(0).getDuration().getText().split(
                " ")[0]) * 2);
    }
    // gets the example which hold the duration of the trip
    public static Example getTravelInfo(Result start2, Result end2) {
        String start =
                start2.getGeometry().getLocation().getLat()+ "," + start2.getGeometry().getLocation().getLng();
        String end =
                end2.getGeometry().getLocation().getLat()+ "," + end2.getGeometry().getLocation().getLng();


        String name = "https://maps.googleapis.com/maps/api/distancematrix/json?units" +
                "=imperial" +
                "&origins="+start + "&destinations="+ end + "&key" +
                APIKeysLOL.GET_TRAVEL_INFO_KEY;
        Example el = getTripData(name);
        return el;
    }


    public static List<Result> getInfo(String url) {
        Restaurants hotels = getRestaurantData(url);
        System.out.println("hotels " + url);
        List<Result> listHotels = new ArrayList<>(hotels.getResults());
        Comparator<Result> resCom = new Comparator<Result>() {
            @Override
            public int compare(Result r1, Result r2) {
                return (int)(10*r2.getRating() - 10*r1.getRating());
            }
        };
        Collections.sort(listHotels, resCom);
        return listHotels;
    }



    public static Example getTripData(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();

//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            Gson myResponse = new Gson();

            return myResponse.fromJson(response.toString(), Example.class);
        } catch (Exception e) {
            System.out.println("help");
        }
        return null;
    }

    public static Restaurants getRestaurantData(String url) {
        System.out.println("ahhhh");
        try {
            System.out.println("start");
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "Mozilla/5.0");


//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
            InputStream st = con.getInputStream();
            System.out.println("mid1");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(st));

            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("mid2");


            in.close();
            Gson myResponse = new Gson();
            System.out.println("end");
            return myResponse.fromJson(response.toString(), Restaurants.class);
        } catch (Exception e) {
            System.out.println("help");
            e.printStackTrace();
        }
        return null;
    }




    public void addEvent(Event e1) {
        // call api database
    }



    //        public Event(double lat, double lng, int duration, EventType eventType, String name,
////                 String pic) {
//    Event space = new Event(47.6205, 122.3493, 60*3, EventType.DEST, "SpaceNeedle",
//            "SpaceNeedle" +
//                    ".jpeg", 20);
//    Event airBnb = new Event(47.6205, 122.3493, 60*3, EventType.SLEEP, "STAY",
//            "SpaceNeedle" +
//                    ".jpeg", 20);

}

