package com.space.dao.functiondao;

import com.space.dao.interfacedao.RsvDAO;
import com.space.global.AppFuncs;
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

    @Override
    public void insertRSV() {
        AppUI.TypeSelection("예약 번호");
        int inputReservationNO = AppFuncs.inputInteger();

        AppUI.TypeSelection("고객 번호");
        int inputCustomerNO = AppFuncs.inputInteger();

        AppUI.TypeSelection("패키지 번호");
        int inputTravelNO = AppFuncs.inputInteger();


        try(Connection connection = DataSource.getDataSource();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO reservations " +
                    "(RSV_NO, CUSTOMER_NO, TRAVEL_NO) VALUES (?,?,?)"))
        {

            preparedStatement.setInt(1, inputCustomerNO);
            preparedStatement.setInt(2, inputCustomerNO);
            preparedStatement.setInt(3, inputTravelNO);
            preparedStatement.executeUpdate();


        }catch (SQLException e){

            e.printStackTrace();
        }
    }
}
