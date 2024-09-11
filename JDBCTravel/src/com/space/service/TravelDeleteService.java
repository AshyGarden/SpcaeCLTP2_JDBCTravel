package com.space.service;

import com.space.global.*;
import com.space.dao.functiondao.*;
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
                case GlobalParams.deleteTravelCustomer:   //고객 정보 삭제
                    DeleteCustomer();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void DeleteFood() {
        JDBCFoodDAO jdbcFoodDAO = new JDBCFoodDAO();
        AppUI.SelectID();
        int no = AppFuncs.inputInteger();
        jdbcFoodDAO.deleteByFoodNO(no);
    }

    private void DeleteLodging() {
        JDBCLodgingDAO jdbcLodgingDAO = new JDBCLodgingDAO();
        AppUI.SelectID();
        int no = AppFuncs.inputInteger();
        jdbcLodgingDAO.deleteByLodgingNO(no);

    }

    private void DeletePlace() {
        JDBCPlaceDAO jdbcPlaceDAO = new JDBCPlaceDAO();
        AppUI.SelectID();
        int no = AppFuncs.inputInteger();
        jdbcPlaceDAO.deletePlaceByNO(no);

    }

    private void DeleteTravel() {
        JDBCTravelDAO jdbcTravelDAO = new JDBCTravelDAO();
        AppUI.SelectID();
        int no = AppFuncs.inputInteger();
        jdbcTravelDAO.deleteTravelByNO(no);
    }

    private void DeleteReservation() {
        JDBCRsvDAO jdbcRsvDAO = new JDBCRsvDAO();
        AppUI.SelectID();
        int no = AppFuncs.inputInteger();
        jdbcRsvDAO.deleteByRsvNO(no);

    }

    private void DeleteCustomer() {
        JDBCCustomerDAO jdbcCustomerDAO = new JDBCCustomerDAO();
        AppUI.SelectID();
        int no = AppFuncs.inputInteger();
        jdbcCustomerDAO.deleteByCustomerNO(no);
    }
}
