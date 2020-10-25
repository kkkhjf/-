package com.hejianfeng.team.Jutil;

import com.hejianfeng.team.domain.*;
import com.hejianfeng.team.service.NameListService;
import com.hejianfeng.team.service.TeamException;

import static com.hejianfeng.team.service.Date.*;


public class NameListServiceTest {
	
	public static void main(String[] args) throws TeamException {
		
		NameListService list = new NameListService();
		
		Employee[] employees = list.getAllEmployees();
		
		for(int i = 0;i < employees.length;i++)
			System.out.println(employees[i]);
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println(list.getemployee(15));
	}
	
}
