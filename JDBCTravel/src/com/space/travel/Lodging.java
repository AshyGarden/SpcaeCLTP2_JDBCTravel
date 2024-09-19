package com.space.travel;

import java.sql.Date;

public class Lodging {
    private int lodgingNumber;
    private String lodgingName;
    private Date lodgingArrival;
    private Date lodgingDeparture;
    private Place place;


    public Lodging() {
    }

    public Lodging(int lodgingNumber, String lodgingName, Date lodgingArrival, Date lodgingDeparture, Place place) {
        this.lodgingNumber = lodgingNumber;
        this.lodgingName = lodgingName;
        this.lodgingArrival = lodgingArrival;
        this.lodgingDeparture = lodgingDeparture;
        this.place = place;
    }

    public int getLodgingNumber() {
        return lodgingNumber;
    }

    public void setLodgingNumber(int lodgingNumber) {
        this.lodgingNumber = lodgingNumber;
    }

    public String getLodgingName() {
        return lodgingName;
    }

    public void setLodgingName(String lodgingName) {
        this.lodgingName = lodgingName;
    }

    public Date getLodgingArrival() {
        return lodgingArrival;
    }

    public void setLodgingArrival(Date lodgingArrival) {
        this.lodgingArrival = lodgingArrival;
    }

    public Date getLodgingDeparture() {
        return lodgingDeparture;
    }

    public void setLodgingDeparture(Date lodgingDeparture) {
        this.lodgingDeparture = lodgingDeparture;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return  "[숙박시설번호: " + lodgingNumber +
                " / 숙박시설명: " + lodgingName + '\'' +
                " / 숙박시설 도착일: " + lodgingArrival +
                " / 숙박시설 출발일: " + lodgingDeparture +
                "]";
    }
}
