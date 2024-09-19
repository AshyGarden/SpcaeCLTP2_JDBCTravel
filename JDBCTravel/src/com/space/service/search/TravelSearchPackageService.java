package com.space.service.search;

import com.space.dao.functiondao.JDBCTravelDAO;
import com.space.dao.interfacedao.TravelDAO;
import com.space.global.*;

public class TravelSearchPackageService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchPackageScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchTravelPackageAll:             //여행패키지 전체 조회
                    TravelPackageSearchAll();
                    break;
                case GlobalParams.searchTravelPackageByID:            //여행패키지 ID(번호) 조회
                    TravelPackageSearchByID();
                    break;
                case GlobalParams.searchTravelPackageByName:          //여행패키지 이름 조회
                    TravelPackageSearchByName();
                    break;
                case GlobalParams.searchTravelPackageByPrice:         //여행패키지 가격 조회
                    TravelPackageSearchByPrice();
                    break;
                case GlobalParams.searchTravelPackageByDate:          //여행패키지 날짜 조회
                    TravelPackageSearchByDate();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void TravelPackageSearchAll() {
        TravelDAO travelDAO = new JDBCTravelDAO();
        travelDAO.findAllTravels();
    }

    private void TravelPackageSearchByID() {
        TravelDAO travelDAO = new JDBCTravelDAO();
        System.out.println("--- 여행 패키지 ID 조회 결과는 다음과 같습니다---");
        System.out.println(travelDAO.findTravelByID().toString());
    }

    private void TravelPackageSearchByName() {
        TravelDAO travelDAO = new JDBCTravelDAO();
        travelDAO.findTravelsByName();
    }

    private void TravelPackageSearchByPrice() {
        TravelDAO travelDAO = new JDBCTravelDAO();
        travelDAO.findTravelsByPrice();
    }

    private void TravelPackageSearchByDate() {
        TravelDAO travelDAO = new JDBCTravelDAO();
        travelDAO.findTravelsByDate();
    }


}
