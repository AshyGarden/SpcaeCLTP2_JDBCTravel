package com.space.travel;

import java.sql.Date;

public class Place {

    private int placeNumber;
    private String placeName;
    private Date placeArrival;
    private Date placeDeparture;
    private TravelPackage travelPackage;

    public Place() {
    }

    public Place(int placeNumber, String placeName, Date placeArrival, Date placeDeparture, TravelPackage travelPackage) {
        this.placeNumber = placeNumber;
        this.placeName = placeName;
        this.placeArrival = placeArrival;
        this.placeDeparture = placeDeparture;
        this.travelPackage = travelPackage;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Date getPlaceArrival() {
        return placeArrival;
    }

    public void setPlaceArrival(Date placeArrival) {
        this.placeArrival = placeArrival;
    }

    public Date getPlaceDeparture() {
        return placeDeparture;
    }

    public void setPlaceDeparture(Date placeDeparture) {
        this.placeDeparture = placeDeparture;
    }

    public TravelPackage getTravelPackage() {
        return travelPackage;
    }

    public void setTravelPackage(TravelPackage travelPackage) {
        this.travelPackage = travelPackage;
    }

    @Override
    public String toString() {
        return "[여행지 번호: " + placeNumber +
                " / 여행지명: " + placeName +
                " / 여행지도착일: " + placeArrival +
                " / 여행지출발일: " + placeDeparture +
                "  / 여행패키지번호: " + travelPackage +
                "]";
    }
}
