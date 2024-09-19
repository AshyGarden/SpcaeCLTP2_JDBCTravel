package com.space.service.search;

import com.space.dao.functiondao.JDBCRsvDAO;
import com.space.dao.interfacedao.RsvDAO;
import com.space.global.*;
import com.space.reservation.Reservation;
import com.space.travel.TravelPackage;

import java.util.List;

public class TravelSearchRsvService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchRsvScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchTravelRsvAll:             //여행패키지 전체 조회
                    TravelRsvSearchAll();
                    break;
                case GlobalParams.searchTravelRsvByID:            //여행패키지 ID(번호) 조회
                    TravelRsvSearchByID();
                    break;
                case GlobalParams.searchTravelRsvByRsvName:          //여행패키지 이름 조회
                    TravelRsvSearchByName();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void TravelRsvSearchAll() {
        RsvDAO rsvDAO = new JDBCRsvDAO();
        List<Reservation> rsvs = rsvDAO.findAllRsvs();
        System.out.println("--- 여행 예약 전체 조회 결과는 다음과 같습니다---");
        for(Reservation r: rsvs) {
            System.out.println(r.toString());
        }
    }

    private void TravelRsvSearchByID() {
        RsvDAO rsvDAO = new JDBCRsvDAO();
        Reservation rsv = rsvDAO.findRsvsByID();
        System.out.println("--- 여행 예약 ID 조회 결과는 다음과 같습니다---");
        System.out.println(rsv.toString());
    }

    private void TravelRsvSearchByName() {
        RsvDAO rsvDAO = new JDBCRsvDAO();
        List<Reservation> rsvs = rsvDAO.findRsvsByName();
        System.out.println("--- 여행 예약 사용자 이름 조회 결과는 다음과 같습니다---");
        for(Reservation r: rsvs) {
            System.out.println(r.toString());
        }
    }
}
