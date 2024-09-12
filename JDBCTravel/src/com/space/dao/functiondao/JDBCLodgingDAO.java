package com.space.dao.functiondao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.space.dao.interfacedao.LodgingDAO;
import com.space.global.DataSource;
import com.space.travel.Lodging;
import com.space.global.AppFuncs;
import com.space.global.AppUI;

public class JDBCLodgingDAO implements LodgingDAO {
	@Override
	public void deleteByLodgingNO(int lodgingNumber) {
		try (Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement
				 = connection.prepareStatement("DELETE lodgings WHERE lodging_no = ?")) {
			preparedStatement.setInt(1, lodgingNumber);
			preparedStatement.executeUpdate();
			AppUI.DeleteCompleteMessage();
		}

		catch (SQLException e) {
		e.printStackTrace();
	}
	}

	@Override
	public void updateLodgingByNO(int lodgingNumber) {
		Lodging lodging = new Lodging();
    	
    	System.out.println("enter the lodging number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new Lodging Name");
    	String inputWord = AppFuncs.inputString();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE LODGINGS SET LODGING_NAME = ? WHERE LODGING_NO = ?")){ 
    			
			pStatement.setString(1, inputWord);
			pStatement.setInt(2, inputNum);
			
			pStatement.executeUpdate(); 
		
    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
	}

	@Override
	public void insertLodging() {
		System.out.println("enter the lodging number");
    	int inputNum = AppFuncs.inputInteger();
    	
    	System.out.println("Enter new lodging name");
    	String inputWord = AppFuncs.inputString();
    	
    	System.out.println("Enter the place number");
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
