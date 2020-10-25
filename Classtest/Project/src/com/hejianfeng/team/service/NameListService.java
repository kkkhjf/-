package com.hejianfeng.team.service;

import com.hejianfeng.team.domain.*;
import static com.hejianfeng.team.service.Date.*;

public class NameListService {

	private Employee[] employees;
	
	public NameListService() {
		
		employees = new Employee[EMPLOYEES.length];
		
		for(int i = 0; i < employees.length;i++) {//switch 也可以
			
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			if(Integer.parseInt(EMPLOYEES[i][0]) == EMPLOYEE) {
				employees[i] = new Employee(id,name,age,salary);
			}
			
			if(Integer.parseInt(EMPLOYEES[i][0]) == PROGRAMMER) {
				Equipment equipment = creatEquipment(i);//接口作为类型
				employees[i] = new Programer(id,name,age,salary,equipment);
			}
			
			if(Integer.parseInt(EMPLOYEES[i][0]) == DESIGNER) {
				Equipment equipment = creatEquipment(i);
				employees[i] = new Designer(id,name,age,salary,equipment,Double.parseDouble(EMPLOYEES[i][5]));
			}
			
			if(Integer.parseInt(EMPLOYEES[i][0]) == ARCHITECT) {
				Equipment equipment = creatEquipment(i);
				employees[i] = new Architect(id,name,age,salary,equipment,Double.parseDouble(EMPLOYEES[i][5]),Integer.parseInt(EMPLOYEES[i][6]));
			}
		}
	}
	
	public Equipment creatEquipment(int index) {
		int type = Integer.parseInt(EQUIPMENTS[index][0]);
		switch(type) {
			case PC:
				return new PC(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
			case NOTEBOOK:
				return new NoteBook(EQUIPMENTS[index][1],Double.parseDouble(EQUIPMENTS[index][2]));
			case PRINTER:
				return new Printer(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
			default:
				System.out.println("创建失败！");
				break;
		}
		
		return null;
	}

	public Employee[] getAllEmployees() {
		return employees;
		
	}
	
	public Employee getemployee(int id) throws TeamException{
		
		for(int i = 0;i < employees.length;i++) {
			if(employees[i].getId() == id)
				return employees[id-1];
		}
		
		throw new TeamException("找不到指定地用户！");
	}
}
