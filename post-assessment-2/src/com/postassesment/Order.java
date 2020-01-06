package com.postassesment;

public abstract class Order 
{
	String orderId;
	String orderItem;
	float quantity;
	String dateOfOrder;
	public abstract void confirm();
	public abstract void close();
	
}
