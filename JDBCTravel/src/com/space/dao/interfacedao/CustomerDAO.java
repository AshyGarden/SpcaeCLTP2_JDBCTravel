package com.space.dao.interfacedao;

import com.space.customer.Customer;

public interface CustomerDAO {
    void deleteByCustomerNO(int customerNumber);
    void insertCustomer();
    Customer findCustomerById(int cumstomerNumber);
}
