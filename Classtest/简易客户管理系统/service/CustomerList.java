package com.hejianfeng.service;


import com.hejianfeng.bean.*;

public class CustomerList {
	
	private int total = 0;
	private Customer[] customers = null;

	
	public CustomerList(int custNum) {
		
		customers = new Customer[custNum];
	}
	
	public boolean addCustomer(Customer custmer) {
		
		if(total >= customers.length)
			return false;
		
		customers[total++] = custmer;
		return true;
	}
	
	public boolean replaceCustomer(int index,Customer cust) {
		
		if(index < 0 || index >=total)
			return false;
		
		customers[index] = cust;
		return true;
	}
	
	public boolean deleteCustomer(int index) {
		
		if(index < 0 || index >total)
			return false;
		
		for(;index < total;index++)
			customers[index-1] = customers[index];
		total--;
		customers[total] = null;
		
		return true;
	}
	
	public Customer[] getAllcustomers() {
		// return customers;不能直接返回customers，数组不一定被填满
		
		Customer[] custs = new Customer[total];
		for(int i = 0;i < total;i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	
	public Customer getCustomer(int index) {
		
		if(index < 0 || index > total)
			return null;
		
		return customers[index-1];
	}
	
	public int getTotal() {
		
		return total;
	}
}
