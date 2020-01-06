package com.postassesment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application 
{
	static List customerList=new ArrayList();
	
	public static void main(String[] args) 
	{
		//creating and instantiating object of class SpecialOrder and NormalOrder
		SpecialOrder specialorder=new SpecialOrder("s01","special order",1.5f,"2nd-Jan-2020");
		NormalOrder normalorder=new NormalOrder("n01","normal order",1.0f,"3th-Jan-2020");
	
		//creating an array of customer objects
		Customer customer[]=new Customer[5];	
		
		customer[0]=new Customer(1,"Megha","Jaipur",specialorder,normalorder);
		customer[1]=new Customer(2,"Shriya","Cuttack",specialorder,normalorder);
		customer[2]=new Customer(3,"Subbu","Tamil Nadu",specialorder,normalorder);
		
		
		customerList.add(customer[0]);
		customerList.add(customer[1]);
		
		Scanner sc=new Scanner(System.in);
		
		
		//choice of operations
		
		int choice;
		do{
			System.out.println("Enter choice of operation:\n1.Add Customer\n2.FindCustomer\n3.Delete Customer\n4.Update Customer\n5.Display Customer List\n6.Display Special Order Details\n7.Display Normal Order Details\n8.Exit");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1: 
				boolean status=addCustomer(customer[2]);
				if(status==true)
				{
					System.out.println("Customer added successfully!");
					System.out.println("New customer list is:\n"+customerList);
				}
				else
					System.out.println("Unable to add customer!!");
				break;
			case 2: 
					findCustomer(2);
					break;
			case 3:
					deleteCustomer(3);
					break;
			case 4:
					updateCustomer(customer[1]);
					break;
			case 5:
				System.out.println(customerList);
				System.out.println("***************************************************************************************************");
				break;
			case 6:
				System.out.println("Enter special order id");
				String specialOrderId=sc.next();
				if(specialOrderId.equals(specialorder.orderId))
				{
					System.out.println("Special Order Details are:"+specialorder);
				}
				else
					System.out.println("Order details not present ");
					break;
			case 7:
				System.out.println("Enter normal order id");
				String normalOrderId=sc.next();
				if(normalOrderId.equals(normalorder.orderId))
				{
					System.out.println("Normal Order Details are:"+normalorder);
				}
				else
					System.out.println("Order details not present ");
					break;
				
			default:
				System.out.println("Wrong Choice!!");
			}
		}while(choice!=8);
		
	}
	public static boolean addCustomer(Customer customer) 
	{
		try {
			customerList.add(customer);
			return true;
		} catch (CustomerException customerException) {
			return false;
		}
		
	}
	
	public static void findCustomer(int customerId)
	{
		for(int i=0;i<customerList.size();i++)
		{
			Customer customer=(Customer) customerList.get(i);
		
			if(customer.customerId == customerId) {
				System.out.println("Found Customer : " + customer);
				return;
			}
		}
		
		System.out.println("Customer not found");
	}
	public static void deleteCustomer(int customerId)
	{
		for(int i=0;i<customerList.size();i++)
		{
			Customer customer=(Customer) customerList.get(i);
		
			if(customer.customerId == customerId) {
				System.out.println("\n\nDeleting customer");
				customerList.remove(i);
				return;
			}
		}
		
		System.out.println("Customer not found");
	}
	public static void updateCustomer(Customer customer)
	{
		int flag=0;
		for(int i=0;i<customerList.size();i++)
		{
			Customer customernew=(Customer) customerList.get(i);
		
			if(customernew.customerId == customer.customerId) {
				flag=1;
			}
		}
		if(flag==1)
		{
			System.out.println("Customer already present!!");
		}
		else
		{
			customerList.add(customer);
			System.out.println("Customer added successfully");
		}
	}
}
