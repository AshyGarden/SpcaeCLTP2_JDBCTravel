package com.space.service.search;

import com.space.dao.functiondao.JDBCPlaceDAO;
import com.space.dao.functiondao.JDBCTravelDAO;
import com.space.dao.interfacedao.PlaceDAO;
import com.space.dao.interfacedao.TravelDAO;
import com.space.global.*;
import com.space.travel.Place;
import com.space.travel.TravelPackage;

import java.util.List;

public class TravelSearchPlaceService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchPlaceScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                        //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchTravelPlaceAll:             //여행패키지 전체 조회
                    TravelPlaceSearchAll();
                    break;
                case GlobalParams.searchTravelPlaceByID:            //여행패키지 ID(번호) 조회
                    TravelPlaceSearchByID();
                    break;
                case GlobalParams.searchTravelPlaceByName:          //여행패키지 이름 조회
                    TravelPlaceSearchByName();
                    break;
//                case GlobalParams.searchTravelPackageByDate:      //여행패키지 날짜 조회
//                    TravelPlaceSearchByDate();
//                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void TravelPlaceSearchAll() {
        PlaceDAO placeDAO = new JDBCPlaceDAO();
        List<Place> places = placeDAO.findAllPlaces();
        System.out.println("--- 여행지 전체 조회 결과는 다음과 같습니다---");
        for(Place p: places) {
            System.out.println(p.toString());
        }
    }

    private void TravelPlaceSearchByID() {
        PlaceDAO placeDAO = new JDBCPlaceDAO();
        System.out.println("--- 여행지 ID 조회 결과는 다음과 같습니다---");
        System.out.println(placeDAO.findPlaceByNo().toString());
    }

    private void TravelPlaceSearchByName() {
        PlaceDAO placeDAO = new JDBCPlaceDAO();
        System.out.println("--- 여행지 이름 조회 결과는 다음과 같습니다---");
        System.out.println(placeDAO.findPlaceByName().toString());
    }

//    private void TravelPlaceSearchByDate() {
//
//    }

}
