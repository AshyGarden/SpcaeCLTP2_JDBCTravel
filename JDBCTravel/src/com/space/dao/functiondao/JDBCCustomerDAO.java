package com.space.dao.functiondao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.space.customer.Customer;
import com.space.dao.interfacedao.CustomerDAO;
import com.space.global.AppFuncs;
import com.space.global.AppUI;
import com.space.global.DataSource;
import com.space.travel.Lodging;
import com.space.travel.Place;

public class JDBCCustomerDAO implements CustomerDAO {

    @Override
    public void insertCustomer() {

        AppUI.TypeSelection("고객번호");
        int inputCustomerNO = AppFuncs.inputInteger();

        AppUI.TypeSelection("고객이름");
        String inputCustomerName = AppFuncs.inputString();

        AppUI.TypeSelection("고객 핸드폰 번호");
        String inputCustomerPhoneNO = AppFuncs.inputString();

        AppUI.TypeSelection("고객 이메일 주소");
        String inputCustomerEmail = AppFuncs.inputString();

        try(Connection connection = DataSource.getDataSource();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  customers " +
                "(CUSTOMER_NO, CUSTOMER_NAME, CUSTOMER_PHONENO,CUSTOMER_EMAIL) VALUES (?,?,?,?)"))
            {

                preparedStatement.setInt(1, inputCustomerNO);
                preparedStatement.setString(2, inputCustomerName);
                preparedStatement.setString(3, inputCustomerPhoneNO);
                preparedStatement.setString(4, inputCustomerEmail);
                preparedStatement.executeUpdate();


        }catch (SQLException e){

            e.printStackTrace();
        }

    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customers = new ArrayList<Customer>();
        String sortOrder = AppFuncs.SortingLogic();

        try (Connection conn = DataSource.getDataSource();
             PreparedStatement pStat = conn.prepareStatement("SELECT * FROM CUSTOMERS "
                     + "ORDER BY CUSTOMER_NO " + sortOrder);
             ResultSet rs = pStat.executeQuery()) {

            while(rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerNo(rs.getInt("CUSTOMER_NO"));
                customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
                customer.setCustomerPhoneNo(rs.getString("CUSTOMER_PHONENO"));
                customer.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    @Override
	public Customer findCustomerById(int customerNumber) {
		Customer customer = new Customer();
		
		try (Connection connection = DataSource.getDataSource();
				PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS WHERE CUSTOMER_NO = ?"))
				{ 
			
			pStatement.setInt(1, customerNumber);		
			ResultSet rs = pStatement.executeQuery();
			if(rs.next()) {
				
				customer.setCustomerNo(rs.getInt("customer_no")); 
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerPhoneNo(rs.getString("customer_phoneNo"));
				customer.setCustomerEmail(rs.getNString("customer_email"));
				
			
			}
				 
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return customer;
	}

    @Override
    public Customer findCustomerByName(String customerName) {
        Customer customer = new Customer();

        try (Connection connection = DataSource.getDataSource();
             PreparedStatement pStatement = connection.prepareStatement("SELECT * FROM CUSTOMERS " +
                     "WHERE CUSTOMER_NAME = ?")){

            pStatement.setString(1, customerName);
            ResultSet rs = pStatement.executeQuery();
            if(rs.next()) {
                customer.setCustomerNo(rs.getInt("customer_no"));
                customer.setCustomerName(rs.getString("customer_name"));
                customer.setCustomerPhoneNo(rs.getString("customer_phoneNo"));
                customer.setCustomerEmail(rs.getNString("customer_email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

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
