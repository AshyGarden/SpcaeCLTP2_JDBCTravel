package com.space.delete;

import com.space.global.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete implements DeleteInterface {
    @Override
    public void deleteByCustomerNO(int customerNO) {
        try {
            Connection connection = DataSource.getDataSource();
            connection.setAutoCommit(false);
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement("DELETE customers WHERE customer_no = ?")) {
                preparedStatement.setInt(1, customerNO);
                preparedStatement.executeUpdate();
            }
            try (PreparedStatement preparedStatement
                         = connection.prepareStatement("DELETE reservations WHERE customer_no = ?")) {
                preparedStatement.setInt(1, customerNO);
                preparedStatement.executeUpdate();
            }
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUnderCondition() {

    }
}
