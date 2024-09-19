package com.space.service;

import com.space.dao.functiondao.JDBCCustomerDAO;
import com.space.dao.functiondao.JDBCFoodDAO;
import com.space.global.AppFuncs;
import com.space.global.AppUI;
import com.space.global.GlobalParams;
import com.space.global.Start;

public class TravelSearchService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchRsv:        //예약 삭제
                    SearchReservation();
                    break;
                case GlobalParams.searchTravelPackage:      //여행패키지 추가
                    SearchTravel();
                    break;
                case GlobalParams.searchTravelPlace:        //여행지 추가
                    SearchPlace();
                    break;
                case GlobalParams.searchTravelLodging:      //숙박시설 추가
                    SearchLodging();
                    break;
                case GlobalParams.searchTravelFood:         //음식 추가
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

    }

    private void SearchReservation() {

    }
    
    private void SearchFoodByNo() {
    	JDBCFoodDAO jdbcFoodDao = new JDBCFoodDAO();
    	System.out.println("enter the food number to see");
    	int foodNumber = AppFuncs.inputInteger();
    	jdbcFoodDao.findFoodById(foodNumber);
    	
    }
    
    private void SearchCustomerByNo() {
    	JDBCCustomerDAO jdbcCustomerDao = new JDBCCustomerDAO();
    	System.out.println("enter the customer number to see");
    	int customerNumber = AppFuncs.inputInteger();
    	jdbcCustomerDao.findCustomerById(customerNumber);
    }
    

}
