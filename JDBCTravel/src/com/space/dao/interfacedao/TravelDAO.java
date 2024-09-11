package com.space.dao.interfacedao;

import com.space.travel.TravelPackage;

import java.time.LocalDateTime;
import java.util.List;

public interface TravelDAO {


    //Search(Select)
    List<TravelPackage> findAllTravels();                         // 모든 여행 패키지 찾기
    List<TravelPackage> findTravel(int i);                        // 숫자로 여행패키지 찾기
    List<TravelPackage> findTravel(String name);                  // 이름으로 여행패키지 찾기
    List<TravelPackage> findTravel(LocalDateTime localDateTime);  // 날짜로 여행패키지 찾기


}
