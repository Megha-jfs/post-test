package com.postassesment;

public class NormalOrder extends Order {
	// default constructor
	public NormalOrder()
		{
			
		}

	// parameterized constructor
	public NormalOrder(String orderId,String orderItem,float quantity,String dateOfOrder)
		{
			this.orderId=orderId;
			this.orderItem=orderItem;
			this.quantity=quantity;
			this.dateOfOrder=dateOfOrder;
			
		}

	// overriding base class methods
	@Override
	public void confirm() {
		System.out.println("This is Normal Order confirmation.");
	}

	@Override
	public void close() {
		System.out.println("This is Normal Order closing.");
	}

	public void dispatch() {
		System.out.println("Normal Order dispatched.");
	}

	public void receive() {
		System.out.println("Normal Order received.");
	}
	//overriding the to-string method
	@Override
	public String toString() {
		return "NormalOrder Details:\n[orderId=" + orderId + ", orderItem=" + orderItem + ", quantity=" + quantity
				+ ", dateOfOrder=" + dateOfOrder + "]";
	}
	

}
