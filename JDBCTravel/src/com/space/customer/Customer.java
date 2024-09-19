package com.space.customer;

public class Customer {

    private int customerNo;
    private String customerName;
    private String customerPhoneNo;
    private String customerEmail;

    public Customer() {}

    public Customer(String customerEmail, String customerPhoneNo, String customerName, int customerNo) {
        this.customerNo = customerNo;
        this.customerName = customerName;
        this.customerPhoneNo = customerPhoneNo;
        this.customerEmail = customerEmail;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public String toString() {
        return "[고객번호: " + customerNo +
                " / 고객이름: " + customerName +
                " / 고객번호: " + customerPhoneNo +
                " / 고객이메일: " + customerEmail +
                "]";
    }
}
