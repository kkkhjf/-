package com.hejianfeng.team.view;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.hejianfeng.team.domain.*;
import com.hejianfeng.team.service.*;
import static com.hejianfeng.team.service.Date.*;

public class TeamView {

	private NameListService listSvc = new NameListService();//个人类
	private TeamService teamSvc = new TeamService();//团队类
	
	public void enterMainMenu(){
		char menu = '0'; 
		boolean flag = true;
		while(flag) {
			System.out.println();
			if(menu != '1')
				listAllEmployees();
			System.out.print("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4) :");
			menu = TSUtility.readMenuSelection();
			
			
			switch(menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("是否要退出(Y/N) :");
				char c = TSUtility.readConfirmSelection();
				if(c == 'Y') {
					System.out.println("正在退出系统...");
					flag = false;
				}
				break;
			}
		}
	}
	
	
	public void listAllEmployees() {
//		System.out.println("显式所有员工信息");
		System.out.println("---------------------------------开发团队调度软件--------------------------------");
		Employee[] employees =  listSvc.getAllEmployees();
		if(employees == null && employees.length == 0)
			System.out.println("系统内没有员工，请先添加员工！");
		else{
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t态度\t奖金\t股票\t领用设备");
			
			for(int i = 0;i < employees.length;i++) {
				System.out.println(employees[i]); 
			}	
			
		}
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public void getTeam(){
//		System.out.println("查看开发团队");
		System.out.println("--------------------------团队列表-----------------------------");
		Programer[] team = null;
		try {
			team = teamSvc.getTeam();
		} catch (TeamException e) {
			// TODO Auto-generated catch block
			System.out.println("获取列表失败，原因：" + e.getMessage());;
		}
		
		if(team.length != 0 && team != null){
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			for(int i = 0;i < team.length;i++) {
				System.out.println(team[i].getDetialsForTeam());
			}
		}
		
		System.out.println("-------------------------------------------------------------");
		
	}
	
	
	public void addMember() {
//		System.out.println("添加团队成员");
		System.out.println("--------------------------添加成员-----------------------------");
		System.out.print("请输入员工ID：");
		int id = TSUtility.readInt();
		Employee e;
		try {
			e = listSvc.getemployee(id);
			teamSvc.addMember(e);
			TSUtility.readReturn();
		} catch (TeamException e1) {
			// TODO Auto-generated catch block
			System.out.println("添加失败，原因：" + e1.getMessage());
		}
		
	}
	
	public void deleteMember() {
//		System.out.println("删除团队成员");
		System.out.println("--------------------------删除成员-----------------------------");
		System.out.print("请输入要删除的员工ID：");
		int memberId = TSUtility.readInt();
		
		System.out.print("是否要删除该员工(Y/N): ");
		char confirm = TSUtility.readConfirmSelection();
		if(confirm == 'Y') {
			try {
				teamSvc.removeMember(memberId);
			} catch (TeamException e) {
				// TODO Auto-generated catch block
				System.out.println("删除失败，原因：" + e.getMessage());
			}
		}
		
	}
	
	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
