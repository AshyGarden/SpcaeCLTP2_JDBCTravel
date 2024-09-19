package com.space.dao.interfacedao;

import com.space.customer.Customer;

import java.util.List;

public interface CustomerDAO {

    //Insert
    void insertCustomer();

    //Select
    List<Customer> findAllCustomers();
    Customer findCustomerById(int cumstomerNumber);
    Customer findCustomerByName(String customerName);

    //Delete
    void deleteByCustomerNO(int customerNumber);
}
