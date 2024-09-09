package com.space.travel;

import java.sql.Date;

public class Lodging {
    private int lodging_number;
    private String lodging_name;
    private Date lodging_arrival;
    private Date lodging_departure;
    private Place place;

    public Lodging() {
    }

    public Lodging(int lodging_number, String lodging_name, Date lodging_arrival, Date lodging_departure, Place place) {
        this.lodging_number = lodging_number;
        this.lodging_name = lodging_name;
        this.lodging_arrival = lodging_arrival;
        this.lodging_departure = lodging_departure;
        this.place = place;
    }


    public int getLodging_number() {
        return lodging_number;
    }

    public void setLodging_number(int lodging_number) {
        this.lodging_number = lodging_number;
    }

    public String getLodging_name() {
        return lodging_name;
    }

    public void setLodging_name(String lodging_name) {
        this.lodging_name = lodging_name;
    }

    public Date getLodging_arrival() {
        return lodging_arrival;
    }

    public void setLodging_arrival(Date lodging_arrival) {
        this.lodging_arrival = lodging_arrival;
    }

    public Date getLodging_departure() {
        return lodging_departure;
    }

    public void setLodging_departure(Date lodging_departure) {
        this.lodging_departure = lodging_departure;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Lodging{" +
                "lodging_number=" + lodging_number +
                ", lodging_name='" + lodging_name + '\'' +
                ", lodging_arrival=" + lodging_arrival +
                ", lodging_departure=" + lodging_departure +
                ", place=" + place +
                '}';
    }
}
