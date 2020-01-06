package com.postassesment;

public class SpecialOrder extends Order 
{
	//default constructor
	public SpecialOrder()
	{
		
	}
	//parameterized constructor
	public SpecialOrder(String orderId,String orderItem,float quantity,String dateOfOrder)
	{
		this.orderId=orderId;
		this.orderItem=orderItem;
		this.quantity=quantity;
		this.dateOfOrder=dateOfOrder;
		
	}
	//overriding base class methods 
	@Override
	public void confirm() 
	{
		System.out.println("This is Special Order confirmation.");
	}
	@Override
	public void close() 
	{
		System.out.println("This is Special Order closing.");
	}
	public void dispatch()
	{
		System.out.println("Special Order dispatched.");
	}
	//overriding the to-string method
	@Override
	public String toString() {
		return "\n\nSpecialOrder Details:\n[orderId=" + orderId + ", orderItem=" + orderItem + ", quantity=" + quantity
				+ ", dateOfOrder=" + dateOfOrder + "]";
	}
	
	

}
