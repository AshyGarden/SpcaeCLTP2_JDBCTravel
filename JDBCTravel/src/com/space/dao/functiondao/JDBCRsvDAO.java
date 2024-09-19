package com.space.dao.functiondao;

import com.space.customer.Customer;
import com.space.dao.interfacedao.RsvDAO;
import com.space.global.*;
import com.space.reservation.Reservation;
import com.space.travel.TravelPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCRsvDAO implements RsvDAO {
    //insert start
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
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //insert end

    //search start
    @Override
    public List<Reservation> findAllRsvs() {
        List<Reservation> reservations = new ArrayList<Reservation>();
        String sortOrder = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM RESERVATIONS "
                     + "ORDER BY RSV_NO " + sortOrder);

             ResultSet rs = pStat.executeQuery()) {

            while(rs.next()) {
                Reservation rsv = new Reservation();
                rsv.setRsvNo(rs.getInt("RSV_NO"));

                int customerNo = rs.getInt("CUSTOMER_NO");
                Customer customer = new Customer();
                customer.setCustomerNo(customerNo);
                rsv.setCustomer(customer);

                int travelNo = rs.getInt("TRAVEL_NO");
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(travelNo);
                rsv.setTravelPackage(travel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    @Override
    public Reservation findRsvsByID() {
        Reservation rsv = new Reservation();
        System.out.println("예약 번호를 입력해주세요.");
        System.out.print(">>>");
        int inputNum = AppFuncs.inputInteger();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM RESERVATIONS "+
                             "WHERE RSV_NO = ? ")) {

            pStat.setInt(1,inputNum);
            ResultSet rs = pStat.executeQuery();

            if(rs.next()) {
                rsv.setRsvNo(rs.getInt("RSV_NO"));

                int customerNo = rs.getInt("CUSTOMER_NO");
                Customer customer = new Customer();
                customer.setCustomerNo(customerNo);
                rsv.setCustomer(customer);

                int travelNo = rs.getInt("TRAVEL_NO");
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(travelNo);
                rsv.setTravelPackage(travel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rsv;
    }

    @Override
    public List<Reservation> findRsvsByName() {
        List<Reservation> reservations = new ArrayList<Reservation>();
        System.out.println("찾고자 하는 이름을 입력해주세요");
        System.out.print(">>>");
        String inputName = AppFuncs.inputString();

        String sortOrder = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * "+
                     "FROM RESERVATIONS R LEFT JOIN CUSTOMERS C "+
                     "on R.CUSTOMER_NO = C.CUSTOMER_NO "+
                     "WHERE C.CUSTOMER_NAME = ? "+
                     "ORDER BY RSV_NO " + sortOrder)) {

            pStat.setString(1, inputName);
            ResultSet rs = pStat.executeQuery();

            while(rs.next()) {
                Reservation rsv = new Reservation();
                rsv.setRsvNo(rs.getInt("RSV_NO"));

                int customerNo = rs.getInt("CUSTOMER_NO");
                Customer customer = new Customer();
                customer.setCustomerNo(customerNo);
                rsv.setCustomer(customer);

                int travelNo = rs.getInt("TRAVEL_NO");
                TravelPackage travel = new TravelPackage();
                travel.setPackageNumber(travelNo);
                rsv.setTravelPackage(travel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }
    //search end

    //delete start
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
