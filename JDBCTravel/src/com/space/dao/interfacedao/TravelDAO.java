package com.space.dao.interfacedao;

import com.space.travel.TravelPackage;

import java.util.List;

public interface TravelDAO {

    //insert
    void insertTravel();

    //Search(Select)
    List<TravelPackage> findAllTravels();
    TravelPackage findTravelByID();
    List<TravelPackage> findTravelsByName();
    void findTravelsByPrice();
    void findTravelsByDate();

    //Update
    void updateTravelByNo(int travelNumber);

    //Delete
    void deleteTravelByNO(int travelNumber);
}
