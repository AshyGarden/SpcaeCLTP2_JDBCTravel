package com.space.customer;

public class Customer {
	
	private int customerNo;
	private String customerName;
	private String customerPhoneNo;
	private String customerEmail;
	
	public Customer() {}

	public Customer(int customerNo, String customerName, String customerPhoneNo, String customerEmail) {
		super();
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
		return "Customer [customerNo=" + customerNo + ", customerName=" + customerName + ", customerPhoneNo="
				+ customerPhoneNo + ", customerEmail=" + customerEmail + "]";
	}
}
