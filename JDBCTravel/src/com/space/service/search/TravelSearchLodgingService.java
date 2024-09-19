package com.space.service.search;

import com.space.dao.functiondao.JDBCLodgingDAO;
import com.space.dao.interfacedao.LodgingDAO;
import com.space.global.*;
import com.space.travel.Lodging;

import java.util.List;

public class TravelSearchLodgingService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchLodgingScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchTravelLodgingAll:             //여행패키지 전체 조회
                    TravelLodgingSearchAll();
                    break;
                case GlobalParams.searchTravelLodgingByID:            //여행패키지 ID(번호) 조회
                    TravelLodgingSearchByID();
                    break;
                case GlobalParams.searchTravelLodgingByName:          //여행패키지 이름 조회
                    TravelLodgingSearchByName();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void TravelLodgingSearchAll() {
        LodgingDAO lodgingDAO = new JDBCLodgingDAO();
        List<Lodging> lodgings = lodgingDAO.findAllLodging();
        System.out.println("--- 숙박시설 전체 조회 결과는 다음과 같습니다---");
        for(Lodging l: lodgings) {
            System.out.println(l.toString());
        }
    }

    private void TravelLodgingSearchByID() {
        LodgingDAO lodgingDAO = new JDBCLodgingDAO();
        System.out.println("--- 숙박시설 ID 조회 결과는 다음과 같습니다---");
        System.out.println(lodgingDAO.findLodgingByNO().toString());
    }

    private void TravelLodgingSearchByName() {
        LodgingDAO lodgingDAO = new JDBCLodgingDAO();
        System.out.println("--- 숙박시설 이름 조회 결과는 다음과 같습니다---");
        System.out.println(lodgingDAO.findLodgingByNO().toString());
    }

}
