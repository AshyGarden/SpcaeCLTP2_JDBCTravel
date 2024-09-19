package com.space.dao.interfacedao;

import com.space.travel.TravelPackage;

import java.util.List;

public interface TravelDAO {

    //insert
    void insertTravel();

    //Search(Select)
    List<TravelPackage> findAllTravels();               // 모든 여행 패키지 찾기
    TravelPackage findTravelByID();                     // 가격 기준에 따라 여행패키지 찾기
    List<TravelPackage> findTravelsByName();            //
    void findTravelsByPrice();           //
    void findTravelsByDate();            //

    //update
    void updateTravelByNo(int travelNumber);

    //Delete
    void deleteTravelByNO(int travelNumber);

}
