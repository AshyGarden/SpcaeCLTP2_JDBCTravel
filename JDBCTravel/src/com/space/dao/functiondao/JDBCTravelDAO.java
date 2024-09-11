package com.space.dao.functiondao;

import com.space.dao.interfacedao.TravelDAO;
import com.space.global.AppUI;
import com.space.global.DataSource;

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
}
