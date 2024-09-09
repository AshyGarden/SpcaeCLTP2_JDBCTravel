package com.space.travel;

public class Food {
    private int food_number;
    private String food_name;
    private Place place;

    public Food() {
    }

    public Food(int food_number, String food_name, Place place) {
        this.food_number = food_number;
        this.food_name = food_name;
        this.place = place;
    }

    public int getFood_number() {
        return food_number;
    }

    public void setFood_number(int food_number) {
        this.food_number = food_number;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_number=" + food_number +
                ", food_name='" + food_name + '\'' +
                ", place=" + place +
                '}';
    }
}
