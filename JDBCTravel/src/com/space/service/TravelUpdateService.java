package com.space.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.dao.functiondao.JDBCTravelDAO;
import com.space.global.AppFuncs;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.global.GlobalParams;
import com.space.global.Start;
import com.space.travel.Food;
import com.space.travel.Lodging;
import com.space.travel.Place;
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

    private boolean UpdateFood() {
    	Food food = new Food();
    	
    	boolean result = false;
    	
    	System.out.println("enter the food number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new food Name");
    	String inputWord = AppFuncs.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE FOODS SET FOOD_NAME = ? WHERE FOOD_NO = ?")){ 
    			
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, inputNum);
			
			
			int rows = pStatement.executeUpdate();
			
			if (rows > 0) {
				result = true;
			}
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		return result; 
    }


    private boolean UpdateLodging() {
    	Lodging lodging = new Lodging();
    	
    	boolean result = false;
    	
    	System.out.println("enter the lodging number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new Lodging Name");
    	String inputWord = AppFuncs.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE LODGINGS SET LODGING_NAME = ? WHERE LODGING_NO = ?")){ 
    			
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, inputNum);
			
			
			int rows = pStatement.executeUpdate(); 
			
			if (rows > 0) {
				result = true;
			}
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		return result; 

    }

    private boolean UpdatePlace() {
    	Place place = new Place();
    	
    	boolean result = false;
    	
    	System.out.println("enter the place number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new Place Name");
    	String inputWord = AppFuncs.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PLACES SET PLACE_NAME = ? WHERE PLACE_NO = ?")){ 
    		
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, inputNum);
			
			
			int rows = pStatement.executeUpdate(); 
			
			if (rows > 0) {
				result = true;
			}
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
			
		return result; 
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
