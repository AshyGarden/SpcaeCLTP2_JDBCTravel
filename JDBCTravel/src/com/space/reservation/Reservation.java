package com.space.reservation;
import com.space.travel.TravelPackage;
import com.space.customer.Customer;

public class Reservation {
	private TravelPackage travelPackage;
	private Customer customer;
	
	public Reservation() {}
	
	public Reservation(TravelPackage travelPackage, Customer customer) {
		this.travelPackage = travelPackage;
		this.customer = customer;
	}

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
	
	

}
