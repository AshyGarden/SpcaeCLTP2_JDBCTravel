package com.space.dao.interfacedao;

import com.space.travel.TravelPackage;

import java.time.LocalDateTime;
import java.util.List;

public interface TravelDAO {

    //Search(Select)
    List<TravelPackage> findAllTravels();                         // 모든 여행 패키지 찾기
    TravelPackage findTravel(int i);                              // 숫자로 여행패키지 찾기
    List<TravelPackage> findTravels(int i);                        // 숫자로 여행패키지들 찾기
    List<TravelPackage> findTravels(String name);                  // 나라 이름으로 여행패키지들 찾기
    List<TravelPackage> findTravels(LocalDateTime localDateTime);  // 날짜로 여행패키지 찾기



    //Delete
    void deleteTravelByNO(int travelNumber);
    boolean updateTravelByNo(int travelNumber);


}
