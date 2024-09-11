package com.space.dao.functiondao;

import com.space.dao.interfacedao.PlaceDAO;
import com.space.global.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.space.global.AppUI;


public class JDBCPlaceDAO implements PlaceDAO {

    @Override
    public void deletePlaceByNO(int placeNumber) {


        try (Connection connection = DataSource.getDataSource();
             PreparedStatement preparedStatement
                     = connection.prepareStatement("DELETE places WHERE place_no = ?")) {
            preparedStatement.setInt(1, placeNumber);
            preparedStatement.executeUpdate();
            AppUI.DeleteCompleteMessage();
        }
        catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
