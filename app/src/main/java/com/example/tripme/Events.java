package com.example.tripme;

public class Events {
    String place;
    String type;
    int price;
    int duration;
    Result res;
    int uberPrice;

    Result r1;
    Result r2;

    public Events(String place, String type, int price, Result res) {
        this.place = place;
        this.type = type;
        this.price = price;
        this.res = res;
        this.duration = getDurationFromType(type);
    }

    public Events(Result r1, Result r2) {
        this.r1 = r1;
        this.r2 = r2;
        this.place = "Lyft";
    }

    public int getUberPrice() {
        uberPrice = Main.getPrice(this.r1, this.r2);
        return uberPrice;
    }

    public int getUberDuration() {
        return uberPrice/2;
    }



    public Events() {}

    public int getDurationFromType(String type) {
        if (type.equals("Restaurants")) {
            return 60;
        } else if (type.equals("Hotels")) {
            return -1;
        } else if (type.equals("Attractions")) {
            return 150;
        }
        return -1;
    }

    public boolean isUber() {
        return type.equals("Transit");
    }

    public int getDurationForTrip() {
        return uberPrice;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public String getPlace() {
        if (type.equals("Transit")) {
            return "Lyft";
        }
        return place;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return type;
    }

    public Result getRes() {
        return res;
    }
}