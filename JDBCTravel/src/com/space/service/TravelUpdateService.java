package com.space.service;

import com.space.global.*;

public class TravelUpdateService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelUpdateScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.updateTravelPackage:      //여행패키지 추가
                    UpdateTravel();
                    break;
                case GlobalParams.updateTravelPlace:        //여행지 추가
                    UpdatePlace();
                    break;
                case GlobalParams.updateTravelLodging:      //숙박시설 추가
                    UpdateLodging();
                    break;
                case GlobalParams.updateTravelFood:         //음식 추가
                    UpdateFood();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void UpdateFood() {

    }

    private void UpdateLodging() {

    }

    private void UpdatePlace() {

    }

    private void UpdateTravel() {

    }
}
