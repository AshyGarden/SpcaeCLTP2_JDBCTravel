package com.space.dao.functiondao;

import com.space.dao.interfacedao.RsvDAO;
import com.space.global.AppUI;
import com.space.global.DataSource;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class JDBCRsvDAO implements RsvDAO {
    @Override
    public void deleteRSVByCustomerNO(int customerNumber) {
        try {
            Connection connection = DataSource.getDataSource();
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement("DELETE reservations WHERE customer_no = ?")) {
                preparedStatement.setInt(1, customerNumber);
                preparedStatement.executeUpdate();
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteByRsvNO(int reservationNumber) {

        try (
                Connection connection = DataSource.getDataSource();
                PreparedStatement preparedStatement
                     = connection.prepareStatement("DELETE reservations WHERE rsv_no = ?")) {
            preparedStatement.setInt(1, reservationNumber);
            preparedStatement.executeUpdate();
            AppUI.DeleteCompleteMessage();
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
    }
}
