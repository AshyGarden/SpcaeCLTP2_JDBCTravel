package com.space.service.search;

import com.space.customer.Customer;
import com.space.dao.functiondao.JDBCCustomerDAO;
import com.space.dao.interfacedao.CustomerDAO;
import com.space.global.*;

import java.util.ArrayList;
import java.util.List;

public class TravelSearchCustomerService implements Start {

    @Override
    public void start() {
        while(true) {
            AppUI.TravelSearchFoodScreen();
            int selection = AppFuncs.inputInteger();

            switch (selection) {
                case GlobalParams.returnNum:                //상위 메뉴로 돌아가기
                    return; //메인화면으로 돌아가기
                case GlobalParams.searchTravelCustomersAll:             //여행패키지 전체 조회
                    TravelCustomersSearchAll();
                    break;
                case GlobalParams.searchTravelCustomersByID:            //여행패키지 ID(번호) 조회
                    TravelCustomerSearchByID();
                    break;
                case GlobalParams.searchTravelCustomersByName:          //여행패키지 이름 조회
                    TravelCustomerSearchByName();
                    break;
                default:
                    AppUI.DefaultMessages();
            }
            AppUI.PressEnter();
            AppFuncs.inputString();
        }
    }

    private void TravelCustomersSearchAll() {
        CustomerDAO customerDAO = new JDBCCustomerDAO();
        List<Customer> customers = new ArrayList<Customer>();
        System.out.println("--- 고객 전체 조회 결과는 다음과 같습니다---");
        for(Customer c: customers) {
            System.out.println(c.toString());
        }
    }

    private void TravelCustomerSearchByID() {
        JDBCCustomerDAO jdbcCustomerDao = new JDBCCustomerDAO();
        System.out.println("enter the customer number to see");
        int customerNumber = AppFuncs.inputInteger();
        jdbcCustomerDao.findCustomerById(customerNumber);
        System.out.println(jdbcCustomerDao.findCustomerById(customerNumber).toString());
    }

    private void TravelCustomerSearchByName() {
        JDBCCustomerDAO jdbcCustomerDao = new JDBCCustomerDAO();
        System.out.println("enter the customer name to see");
        String customerName = AppFuncs.inputString();
        jdbcCustomerDao.findCustomerByName(customerName);
        System.out.println(jdbcCustomerDao.findCustomerByName(customerName).toString());
    }
}
