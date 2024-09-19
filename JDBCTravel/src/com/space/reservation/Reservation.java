package com.space.reservation;
import com.space.travel.TravelPackage;
import com.space.customer.Customer;

import java.sql.ResultSet;

public class Reservation {
	private int rsvNo;
	private TravelPackage travelPackage;
	private Customer customer;
	
	public Reservation() {}

	public Reservation(int rsvNo, TravelPackage travelPackage, Customer customer) {
		this.rsvNo = rsvNo;
		this.travelPackage = travelPackage;
		this.customer = customer;
	}

	public int getRsvNo() { return rsvNo; }
	public void setRsvNo(int rsvNo) { this.rsvNo = rsvNo; }

	public TravelPackage getTravelPackage() {
		return travelPackage;
	}
	public void setTravelPackage(TravelPackage travelPackage) {
		this.travelPackage = travelPackage;
	}

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "[예약번호: " + rsvNo +
				" / 예약패키지 이름: " + travelPackage.getPackageName() +
				" / 예약자: " + customer.getCustomerName() +
				"]";
	}
}
