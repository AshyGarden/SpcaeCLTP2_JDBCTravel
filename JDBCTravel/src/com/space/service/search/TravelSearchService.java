package com.space.service.search;

import com.space.dao.functiondao.JDBCTravelDAO;
import com.space.dao.interfacedao.TravelDAO;
import com.space.global.*;

public class TravelSearchService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchRsv:                //예약 조회
                    SearchReservation();
                    break;
                case GlobalParams.searchTravelPackage:      //여행패키지 조회
                    SearchTravel();
                    break;
                case GlobalParams.searchTravelPlace:        //여행지 조회
                    SearchPlace();
                    break;
                case GlobalParams.searchTravelLodging:      //숙박시설 조회
                    SearchLodging();
                    break;
                case GlobalParams.searchTravelFood:         //음식 조회
                    SearchFood();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void SearchFood() {

    }

    private void SearchLodging() {

    }

    private void SearchPlace() {

    }

    private void SearchTravel() {
        TravelDAO dao = new JDBCTravelDAO();
        dao.findAllTravels();
    }

    private void SearchReservation() {

    }

}
