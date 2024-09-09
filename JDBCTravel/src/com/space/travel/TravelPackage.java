package com.space.travel;

import java.sql.Date;

public class TravelPackage {
    private int package_number;
    private String package_name;
    private int package_price;
    private Date package_departure;
    private Date package_arrival;


    public TravelPackage() {
    }

    public TravelPackage(int package_number, String package_name, int package_price, Date package_departure, Date package_arrival) {
        this.package_number = package_number;
        this.package_name = package_name;
        this.package_price = package_price;
        this.package_departure = package_departure;
        this.package_arrival = package_arrival;
    }

    public int getPackage_number() {
        return package_number;
    }

    public void setPackage_number(int package_number) {
        this.package_number = package_number;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public int getPackage_price() {
        return package_price;
    }

    public void setPackage_price(int package_price) {
        this.package_price = package_price;
    }

    public Date getPackage_departure() {
        return package_departure;
    }

    public void setPackage_departure(Date package_departure) {
        this.package_departure = package_departure;
    }

    public Date getPackage_arrival() {
        return package_arrival;
    }

    public void setPackage_arrival(Date package_arrival) {
        this.package_arrival = package_arrival;
    }

    @Override
    public String toString() {
        return "TravelPackage{" +
                "package_number=" + package_number +
                ", package_name='" + package_name + '\'' +
                ", package_price=" + package_price +
                ", package_departure=" + package_departure +
                ", package_arrival=" + package_arrival +
                '}';
    }
}
