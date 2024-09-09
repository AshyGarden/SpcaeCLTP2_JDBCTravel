package com.space.travel;

public class Food {
    private int foodNumber;
    private String foodName;
    private Place place;

    public Food() {
    }

    public Food(int foodNumber, String foodName, Place place) {
        this.foodNumber = foodNumber;
        this.foodName = foodName;
        this.place = place;
    }

    public int getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
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
                "foodNumber=" + foodNumber +
                ", foodName='" + foodName + '\'' +
                ", place=" + place +
                '}';
    }
}
