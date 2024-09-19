package com.space.dao.functiondao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.space.customer.Customer;
import com.space.dao.interfacedao.FoodDAO;
import com.space.global.DataSource;
import com.space.travel.Food;
import com.space.travel.Place;
import com.space.global.AppFuncs;
import com.space.global.AppUI;

public class JDBCFoodDAO implements FoodDAO {

	@Override
	public void updateFoodByNO(int foodNumber) {
		Food food = new Food();
	   
    	System.out.println("Enter new food Name");
    	String inputWord = AppFuncs.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE FOODS SET FOOD_NAME = ? WHERE FOOD_NO = ?")){ 
    			
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, foodNumber);
			
			pStatement.executeUpdate();
		
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
	}

	@Override
	public void deleteByFoodNO(int foodNumber) {


		try (Connection connection = DataSource.getDataSource();
			 PreparedStatement preparedStatement
					 = connection.prepareStatement("DELETE foods WHERE food_no = ?")) {
			preparedStatement.setInt(1, foodNumber);
			preparedStatement.executeUpdate();
			AppUI.DeleteCompleteMessage();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertFood() {
		System.out.println("enter the food number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new food name");
    	String inputWord = AppFuncs.inputString();
    	
    	System.out.println("Enter the place number");
    	int inputNO = AppFuncs.inputInteger();
		
		try(Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("INSERT INTO FOODS VALUES(?, ?, ?)")){ 
				
			
				pStatement.setInt(1, inputNum);
				pStatement.setString(2, inputWord);
				pStatement.setInt(3, inputNO);
				
				pStatement.executeUpdate();
				
				
				
			} catch (SQLException e) { 
				e.printStackTrace();
			}
		
	}

	@Override
	public Food findFoodById(int foodNumber) {
		Food food = new Food();
		Place place = new Place();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM FOODS WHERE FOOD_NO = ?"))
				{ 
			
			pStatement.setInt(1, foodNumber);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				food.setFoodNumber(rs.getInt("food_no")); 
				food.setFoodName(rs.getString("food_name"));
				
				place.setPlaceNumber(rs.getInt("place_no"));
				food.setPlace(place);
				
				
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return food;
	}
}
