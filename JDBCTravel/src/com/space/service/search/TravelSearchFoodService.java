package com.space.service.search;

import com.space.dao.functiondao.JDBCFoodDAO;
import com.space.dao.functiondao.JDBCLodgingDAO;
import com.space.dao.interfacedao.FoodDAO;
import com.space.global.*;
import com.space.travel.Food;
import com.space.travel.Lodging;

import java.util.List;

public class TravelSearchFoodService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchFoodScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchTravelFoodAll:             //여행패키지 전체 조회
                    TravelFoodSearchAll();
                    break;
                case GlobalParams.searchTravelFoodByID:            //여행패키지 ID(번호) 조회
                    TravelFoodSearchByID();
                    break;
                case GlobalParams.searchTravelFoodByName:          //여행패키지 이름 조회
                    TravelFoodSearchByName();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void TravelFoodSearchAll() {
        FoodDAO foodDAO = new JDBCFoodDAO();
        List<Food> foods = foodDAO.findAllFoods();
        System.out.println("--- 음식 전체 조회 결과는 다음과 같습니다---");
        for(Food f: foods) {
            System.out.println(f.toString());
        }
    }

    private void TravelFoodSearchByID() {
        FoodDAO foodDAO = new JDBCFoodDAO();
        System.out.println(foodDAO.findFoodByNo().toString());
    }

    private void TravelFoodSearchByName() {
        FoodDAO foodDAO = new JDBCFoodDAO();
        System.out.println(foodDAO.findFoodByName().toString());
    }
}
