package com.space.dao.functiondao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.space.dao.interfacedao.FoodDAO;
import com.space.global.DataSource;
import com.space.travel.Food;
import com.space.global.AppUI;

public class JDBCFoodDAO implements FoodDAO {

	@Override
	public boolean updateFood() {
		Food food = new Food();
		
		boolean result = false;
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE FOODS SET FOOD_NAME = ? WHERE FOOD_NO = ?")){ 
    			
			pStatement.setString(1, food.getFoodName());
			pStatement.setInt(2, food.getFoodNumber());
			
			
			int rows = pStatement.executeUpdate(); 
			
			if (rows > 0) {
				result = true;
			}
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		return result; 

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
}
