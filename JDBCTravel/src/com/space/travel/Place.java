package com.space.travel;

import java.sql.Date;

public class Place {

    private int place_number;
    private String place_name;
    private Date place_arrival;
    private Date place_departure;
    private TravelPackage travelPackage;

    public Place() {
    }

    public Place(int place_number, String place_name, Date place_arrival, Date place_departure, TravelPackage travelPackage) {
        this.place_number = place_number;
        this.place_name = place_name;
        this.place_arrival = place_arrival;
        this.place_departure = place_departure;
        this.travelPackage = travelPackage;
    }

    public int getPlace_number() {
        return place_number;
    }

    public void setPlace_number(int place_number) {
        this.place_number = place_number;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public Date getPlace_arrival() {
        return place_arrival;
    }

    public void setPlace_arrival(Date place_arrival) {
        this.place_arrival = place_arrival;
    }

    public Date getPlace_departure() {
        return place_departure;
    }

    public void setPlace_departure(Date place_departure) {
        this.place_departure = place_departure;
    }

    public TravelPackage getTravelPackage() {

        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    @Override
    public String toString() {
        return "TravelPackage{" +
                "place_number=" + place_number +
                ", place_name='" + place_name + '\'' +
                ", place_arrival=" + place_arrival +
                ", place_departure=" + place_departure +
                ", travelPackage=" + travelPackage +
                '}';
    }
}
