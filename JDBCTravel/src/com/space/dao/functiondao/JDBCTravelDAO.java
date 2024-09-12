package com.space.dao.functiondao;

import com.space.dao.interfacedao.TravelDAO;
import com.space.global.AppFuncs;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.service.TravelUpdateService;
import com.space.travel.TravelPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class JDBCTravelDAO implements TravelDAO{
    @Override
    public void deleteTravelByNO(int travelNumber) {

        try (Connection connection = DataSource.getDataSource();
             PreparedStatement preparedStatement
                     = connection.prepareStatement("DELETE travels WHERE travel_no = ?"))
        {
            preparedStatement.setInt(1, travelNumber);
            preparedStatement.executeUpdate();
            AppUI.DeleteCompleteMessage();
        } catch (SQLIntegrityConstraintViolationException e) {
            // Specific catch block for foreign key violation
            System.out.println("예약된 정보를 먼저 삭제해주세요");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateTravelByNo(int travelNumber) {
		TravelUpdateService travelUpdateService = new TravelUpdateService();
		
    	TravelPackage travelPackage = new TravelPackage(); 
    	travelPackage = travelUpdateService.findById(travelNumber);
    	
    	System.out.println("Enter new travel package name");
    	String inputName = AppFuncs.inputString();
    	
    	System.out.println("Enter new travel package price(If no change, press -1): ");
    	int inputPrice = AppFuncs.inputInteger();
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE TRAVELS SET TRAVEL_NAME = ?, TRAVEL_PRICE = ? WHERE TRAVEL_NO = ?")){ 
    			
    		if(!inputName.isEmpty()) {
    			pStatement.setString(1, inputName);
    		} else {
    			pStatement.setString(1, travelPackage.getPackageName());
    		}
			
    		if(inputPrice == -1) {
    			pStatement.setInt(2, travelPackage.getPackagePrice());
    		} else {
    			pStatement.setInt(2, inputPrice);
    			
    		}
			
		
			pStatement.setInt(3, travelNumber);
		
			
			pStatement.executeUpdate(); 
			

    			
		} catch (SQLException e) { 
			e.printStackTrace();
		} 
		
		
	}
    
    
}
