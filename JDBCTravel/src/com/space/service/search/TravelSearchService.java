package com.space.service.search;

import com.space.global.*;
import com.space.dao.functiondao.*;
import com.space.dao.interfacedao.*;
import com.space.travel.Food;
import com.space.travel.Lodging;
import com.space.travel.Place;

public class TravelSearchService implements Start {

    TravelSearchRsvService travelSearchRsvService = new TravelSearchRsvService();
    TravelSearchPackageService travelSearchPackageService = new TravelSearchPackageService();
    TravelSearchPlaceService travelSearchPlaceService = new TravelSearchPlaceService();
    TravelSearchLodgingService travelSearchLodgingService = new TravelSearchLodgingService();
    TravelSearchFoodService travelSearchFoodService = new TravelSearchFoodService();

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchRsv:                //예약 조회
                    travelSearchRsvService.start();
                    break;
                case GlobalParams.searchTravelPackage:      //여행패키지 조회
                    travelSearchPackageService.start();
                    break;
                case GlobalParams.searchTravelPlace:        //여행지 조회
                    travelSearchPlaceService.start();

                    break;
                case GlobalParams.searchTravelLodging:      //숙박시설 조회
                    travelSearchLodgingService.start();
                    break;
                case GlobalParams.searchTravelFood:         //음식 조회
                    travelSearchFoodService.start();

                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }






}
