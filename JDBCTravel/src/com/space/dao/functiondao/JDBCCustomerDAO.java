package com.space.dao.functiondao;

import com.space.dao.interfacedao.CustomerDAO;
import com.space.global.AppUI;
import com.space.global.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCCustomerDAO implements CustomerDAO {
    @Override
    public void deleteByCustomerNO(int customerNumber) {

        try (Connection connection = DataSource.getDataSource();
            PreparedStatement preparedStatement = connection.prepareStatement("Delete customers WHERE customer_no = ?"))
        {
            preparedStatement.setInt(1, customerNumber);
            preparedStatement.executeUpdate();
            AppUI.DeleteCompleteMessage();
        }
        catch (SQLException e) {
        e.printStackTrace();
        }
    }

}
