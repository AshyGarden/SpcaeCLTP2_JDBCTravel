package com.space.dao.interfacedao;

import com.space.travel.TravelPackage;

import java.time.LocalDateTime;
import java.util.List;

public interface TravelDAO {

    //Search(Select)
    List<TravelPackage> findAllTravels();                          // 모든 여행 패키지 찾기
    TravelPackage findTravel(int inputNum);                        // 숫자로 여행패키지 찾기     // 숫자로 여행패키지들 찾기
    List<TravelPackage> findTravels(int criteriaPrice);            // 가격 기준에 따라 여행패키지 찾기
    List<TravelPackage> findTravels(String name);                  // 나라 이름으로 여행패키지들 찾기
    List<TravelPackage> findTravels(LocalDateTime localDateTime);  // 날짜로 여행패키지 찾기

    //update
    void updateTravelByNo(int travelNumber);

    //Delete
    void deleteTravelByNO(int travelNumber);

}
