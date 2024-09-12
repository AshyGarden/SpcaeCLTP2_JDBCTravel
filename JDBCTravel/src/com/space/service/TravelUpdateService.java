package com.space.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.functiondao.JDBCFoodDAO;
import com.space.dao.functiondao.JDBCLodgingDAO;
import com.space.dao.functiondao.JDBCPlaceDAO;
import com.space.dao.functiondao.JDBCTravelDAO;
import com.space.global.AppFuncs;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.global.GlobalParams;
import com.space.global.Start;
import com.space.travel.TravelPackage;

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
    	JDBCFoodDAO jdbcFoodDao = new JDBCFoodDAO();
    	System.out.println("enter the food number to change");
    	int foodNumber = AppFuncs.inputInteger();
    	jdbcFoodDao.updateFoodByNO(foodNumber);
    }


    private void UpdateLodging() {
    	JDBCLodgingDAO jdbcLodingDao = new JDBCLodgingDAO();
    	System.out.println("enter the lodging number to change");
    	int lodingNumber = AppFuncs.inputInteger();
    	jdbcLodingDao.updateLodgingByNO(lodingNumber);
    }

    private void UpdatePlace() {
    	JDBCPlaceDAO jdbcPlaceDao = new JDBCPlaceDAO();
    	System.out.println("enter the place number to change");
    	int placeNumber = AppFuncs.inputInteger();
    	jdbcPlaceDao.updatePlaceByNO(placeNumber);
    }

    private void UpdateTravel() {
    	JDBCTravelDAO jdbcTravelDao = new JDBCTravelDAO();
    	System.out.println("enter the travel number to change");
    	int travelNumber = AppFuncs.inputInteger();
    	jdbcTravelDao.updateTravelByNo(travelNumber);
    	

    }
    
    public TravelPackage findById(int packageNumber){
    	TravelPackage travelPackage = new TravelPackage();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM TRAVELS WHERE TRAVEL_NO = ?"))
				{ 
			pStatement.setInt(1, packageNumber);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				travelPackage.setPackageName(rs.getString("travel_name")); 
				travelPackage.setPackagePrice(rs.getInt("travel_price"));
				travelPackage.setPackageDeparture(rs.getDate("travel_Departure"));
				travelPackage.setPackageArrival(rs.getDate("travel_Arrival"));
			
			}
				
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return travelPackage ;
    }
}
