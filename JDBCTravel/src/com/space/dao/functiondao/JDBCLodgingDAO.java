package com.space.dao.functiondao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.space.dao.interfacedao.LodgingDAO;
import com.space.global.DataSource;
import com.space.travel.Lodging;
import com.space.global.AppUI;

public class JDBCLodgingDAO implements LodgingDAO {

	@Override
	public boolean updateLodging() {
		Lodging lodging = new Lodging();
    	
    	boolean result = false;
    	
    	try(Connection connection = DataSource.getDataSource();
    			PreparedStatement pStatement = connection.prepareStatement("UPDATE LODGINGS SET LODGING_NAME = ? WHERE LODGING_NO = ?")){ 
    			
			pStatement.setString(1, lodging.getLodgingName());
			pStatement.setInt(2, lodging.getLodgingNumber());
			
			
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
}
