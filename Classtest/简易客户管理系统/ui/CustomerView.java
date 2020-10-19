package com.hejianfeng.ui;

import com.hejianfeng.bean.Customer;
import com.hejianfeng.service.*;
import com.hejianfeng.util.CMUtility;

public class CustomerView {
	
	private CustomerList customerList = new CustomerList(10);
	
	CustomerView(){
		Customer cust = new Customer("何剑锋",'男',22,"12344567890","hjfking@gmail.com");
		customerList.addCustomer(cust);
	}
	
	public void enterMainMenu() {
		
		boolean loopflag = true;
		do {
		System.out.println("---------------客户信息关系软件-------------");
		System.out.println("                 1、添加客户");
		System.out.println("                 2、修改客户");
		System.out.println("                 3、删除客户");
		System.out.println("                 4、客户列表");
		System.out.println("                 5、退出系统");
		System.out.print("  请输入（1-5）进行操作：");
		
		char key = CMUtility.readMeanSelection();
		System.out.println();
		
		switch(key) {
		case '1':
			addNewCustomer();
			break;
		case '2':
			modifyCustomer();
			break;
		case '3':
			deleteCustomer();
			break;
		case '4':
			listAllCustomer();
			break;
		case '5':{
			//System.out.println("确定退出（Y/N）：");
			char isExit = CMUtility.readConfirmSelection();
			if(isExit == 'Y')
				loopflag = false;
		}
		
		}
		}while(loopflag);
	}
	
	
	public void addNewCustomer() {
		System.out.println("-----------------------添加客户------------------------");
		
		System.out.print("姓名：");
		String name = CMUtility.readString(10);
		
		System.out.print("性别：");
		char gender = CMUtility.readChar();
		
		System.out.print("年龄：");
		int age = CMUtility.readInt();
		
		System.out.print("电话号码：");
		String phone = CMUtility.readString(11);
		
		System.out.print("邮箱：");
		String email = CMUtility.readString(20);
		//customerList.getCustomer(customerList.getTotal()).setName(name); 不能这么写，要先创建一个新的Customer对象，然后再添加进CustomerList中
		Customer cust = new Customer(name, gender, age, phone, email);
		
		boolean isSus = customerList.addCustomer(cust);
		if(isSus)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
		
	}
	
	/**
	 * 
	 */
	public void modifyCustomer() {
		System.out.println("-------------------修改客户-------------------");
		boolean flag = true;
		int number;
		do {
			System.out.println("请选择需要修改的客户编号(-1): ");
			number = CMUtility.readInt();
			//Customer cust = customerList.getCustomer(number);
			
			if(number == -1)
				return;
			if(customerList.getCustomer(number) != null) {
				flag = false;
			}
			else
				System.out.println("输入错误，请按规定重新输入！");	
		}while(flag);
		
		Customer cust = customerList.getCustomer(number);
		
		System.out.print("原名"+cust.getName()+"，请输入新名称：");
		cust.setName(CMUtility.readString(10));
		
		System.out.print("原号码"+cust.getPhone()+"，请输入新号码：");
		cust.setPhone(CMUtility.readString(11));
		
		System.out.print("原邮箱"+cust.getEmail()+"，请输入新邮箱：");
		cust.setEmail(CMUtility.readString(20));
		
		System.out.println("-------------------修改完成-------------------");
		
	}
	
	public void deleteCustomer() {
		System.out.println("-------------------删除客户-------------------");
		boolean flag = true;
		int number;
		
		do {
			System.out.println("请选择需要删除的客户编号(-1): ");
			number = CMUtility.readInt();
			//Customer cust = customerList.getCustomer(number);
			
			if(number == -1)
				return;
			if(customerList.getCustomer(number) != null) {
				flag = false;
			}
			else
				System.out.println("输入错误，请按规定重新输入！");	
		}while(flag);
		
		if(customerList.deleteCustomer(number))
			System.out.println("-------------------删除成功-------------------");
		else
			System.out.println("-------------------删除失败-------------------");
		
		
		
	}
	
	public void listAllCustomer() {
		System.out.println("所有客户信息如下：");
		System.out.println("--------------------客户列表-----------------");
		if(customerList.getTotal() == 0)
			System.out.println("没有用户信息，请先注册！");
			else
			{
				System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
				Customer[] custs = customerList.getAllcustomers();
				for(int i = 0;i < customerList.getTotal();i++) {
					Customer cust = custs[i];
					System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()+"\t"+cust.getAge()+"\t\t"+cust.getPhone()+"\t"+cust.getEmail());
				}
			}
		
		
		System.out.println("------------------客户列表完成----------------");
		
		
		
	}
	
	public static void main(String[] args) {
		CustomerView view = new CustomerView();
		view.enterMainMenu();
		System.out.println("***欢迎再次使用！***");
	}
}
