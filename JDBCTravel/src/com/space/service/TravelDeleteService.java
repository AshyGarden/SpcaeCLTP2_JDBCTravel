package com.space.service;

import com.space.global.*;

public class TravelDeleteService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelDeleteScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:     //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.deleteReservation:        //예약 삭제
                    DeleteReservation();
                    break;
                case GlobalParams.deleteTravelPackage:      //여행패키지 삭제
                    DeleteTravel();
                    break;
                case GlobalParams.deleteTravelPlace:        //여행지 삭제
                    DeletePlace();
                    break;
                case GlobalParams.deleteTravelLodging:      //숙박시설 삭제
                    DeleteLodging();
                    break;
                case GlobalParams.deleteTravelFood:         //음식 삭제
                    DeleteFood();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void DeleteFood() {

    }

    private void DeleteLodging() {

    }

    private void DeletePlace() {

    }

    private void DeleteTravel() {

    }

    private void DeleteReservation() {

    }
}
