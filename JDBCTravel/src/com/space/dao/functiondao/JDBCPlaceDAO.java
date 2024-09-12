package com.space.dao.functiondao;

import com.space.dao.interfacedao.PlaceDAO;
import com.space.global.DataSource;
import com.space.travel.Food;
import com.space.travel.Place;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.space.global.AppFuncs;
import com.space.global.AppUI;


public class JDBCPlaceDAO implements PlaceDAO {

    @Override
    public void deletePlaceByNO(int placeNumber) {


        try (Connection connection = DataSource.getDataSource();
             PreparedStatement preparedStatement
                     = connection.prepareStatement("DELETE places WHERE place_no = ?")) {
            preparedStatement.setInt(1, placeNumber);
            preparedStatement.executeUpdate();
            AppUI.DeleteCompleteMessage();
        }
        catch (SQLException e) {
        e.printStackTrace();
    }
    }

	@Override
	public void updatePlaceByNO(int placeNumber) {
		Place place = new Place();
    	
    	System.out.println("enter the place number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new Place Name");
    	String inputWord = AppFuncs.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE PLACES SET PLACE_NAME = ? WHERE PLACE_NO = ?")){ 
    		
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, inputNum);
			
			
			pStatement.executeUpdate(); 
			
			
    		
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void insertPlace() {
		System.out.println("enter the place number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new place name");
    	String inputWord = AppFuncs.inputString();
    	
    	System.out.println("Enter the travel number");
    	int inputNO = AppFuncs.inputInteger();
    	
    	System.out.println("Enter the departure date");
    	Date inputDeparture = AppFuncs.inputDate();
    	
    	System.out.println("Enter the arrival date");
    	Date inputArrival = AppFuncs.inputDate();
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO PLACES VALUES (?, ?, ?, ?, ?)")){ 
				
			
				pStatement.setInt(1, inputNum);
				pStatement.setString(2, inputWord);
				pStatement.setDate(3, inputArrival);
				pStatement.setDate(4, inputDeparture);
				pStatement.setInt(5, inputNO);
				
				
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
	}
	
}
