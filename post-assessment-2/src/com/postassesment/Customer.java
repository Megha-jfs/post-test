package com.postassesment;

public class Customer 
{
	int customerId;
	String customerName;
	String location;
	Order specialorder;
	Order normalorder;
	//default constructor
	public Customer()
	{
		
	}
	//parameterized constructor
	public Customer(int customerId,String customerName,String location,Order specialorder,Order normalorder)
	{
		this.customerId=customerId;
		this.customerName=customerName;
		this.location=location;
		this.specialorder=specialorder;
		this.normalorder=normalorder;
	}
	public void sendOrder()
	{
		System.out.println("Sending Customer Order.");
	}
	public void receiveOrder()
	{
		System.out.println("Receiving Customer Order.");
	}
	//overriding the to-string method
	@Override
	public String toString() {
		return "Customer Details:\n\n[Customer Id=" + customerId + ", Customer Name=" + customerName + ", Location=" + location
				+ specialorder + "\n\n" + normalorder + "]\n";
	}
	
}
