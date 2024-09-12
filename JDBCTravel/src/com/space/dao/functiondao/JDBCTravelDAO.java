package com.space.dao.functiondao;

import com.space.dao.interfacedao.TravelDAO;
import com.space.global.AppFuncs;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.service.TravelUpdateService;
import com.space.travel.TravelPackage;

import java.sql.*;

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
	public boolean updateTravelByNo(int travelNumber) {
		TravelUpdateService travelUpdateService = new TravelUpdateService();
		
    	TravelPackage travelPackage = new TravelPackage();
    	travelPackage = travelUpdateService.findById(travelNumber);
    	
    	boolean result = false;
    	
    	System.out.println("Enter new travel package name");
    	String inputName = AppFuncs.inputString();
    	
    	System.out.println("Enter new travel package price/if no change, press -1");
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
	public void insertTravel() {
		AppUI.TypeSelection("패키지 번호");
		int inputTravelNO = AppFuncs.inputInteger();

		AppUI.TypeSelection("패키지 이름");
		String inputTravelName = AppFuncs.inputString();

		AppUI.TypeSelection("패키지 가격");
		int inputTravelPrice = AppFuncs.inputInteger();

		AppUI.TypeSelection("출발 시간");
		Date inputTravleDeparture = AppFuncs.inputDate();

		AppUI.TypeSelection("출발 시간");
		Date inputTravleArrival = AppFuncs.inputDate();



		try(Connection connection = DataSource.getDataSource();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Travels " +
					"(TRAVEL_NO, TRAVEL_NAME, TRAVEL_PRICE, TRAVEL_DEPARTURE, TRAVEL_ARRIVAL) VALUES (?,?,?,?,?)"))
		{

			preparedStatement.setInt(1, inputTravelNO);
			preparedStatement.setString(2, inputTravelName);
			preparedStatement.setInt(3, inputTravelPrice);
			preparedStatement.setDate(3, inputTravleDeparture);
			preparedStatement.setDate(3, inputTravleArrival);


			preparedStatement.executeUpdate();

		}catch (SQLException e){

			e.printStackTrace();
		}
	}
}
