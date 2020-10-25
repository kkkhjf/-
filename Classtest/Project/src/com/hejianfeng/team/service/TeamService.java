package com.hejianfeng.team.service;

import com.hejianfeng.team.domain.*;
import static com.hejianfeng.team.service.Date.*;


public class TeamService {
	
	
	private int count = 0;
	private final int  MAX = 5;
	private int total = 0;
	private Programer[] team = new Programer[MAX];
	

	
	
	public Programer[] getTeam() throws TeamException{
		if(total == 0)
			throw new TeamException("团队尚未组建，请添加成员！");
		Programer[] team_ = new Programer[total];
		for(int i = 0;i < team_.length;i++)
			team_[i] = this.team[i];
		return team_;
	}

	
	public void addMember(Employee e) throws TeamException{

		 Programer p = (Programer) e;
		
		 if(total >= 5)
			 System.out.println("小组已满！");
		 else if(!(e instanceof Programer))
			 throw new TeamException("该成员不是开发人员，无法添加！");
		 else if(isExist(e)){
			 throw new TeamException("该员工已经存在团队中！");
		 }
		 else {
			 if(p.getStatus().getName().equals("BUSY") || p.getStatus().getName().equals("VOCATION") ) {
				 throw new TeamException("该成员加入其他团队或正在休假，无法加入本团队！");
			 }//"BUSY".equals(p.getStatus().getName())可以防止空指针异常	
		 }
		 
//		 if(Integer.parseInt(EMPLOYEES[e.getId()-1][0]) == PROGRAMMER) {
//			 if(PROGRAMMER_NUM < 3)
//				 PROGRAMMER_NUM++;
//			 else {
//				 throw new TeamException("该团队程序员以满！");
//			 }
//		 }
//		 
//		 if(Integer.parseInt(EMPLOYEES[e.getId()-1][0]) == DESIGNER) {
//			 if(DESIGNER_NUM < 2) {
//				 DESIGNER_NUM++;
//			 }
//			 else {
//				 throw new TeamException("该团队设计师已满！");
//			 }
//		 }
//
//		 if(Integer.parseInt(EMPLOYEES[e.getId()-1][0]) == ARCHITECT) {
//			 if(ARCHITECT_NUM < 1)
//				 ARCHITECT_NUM++;
//			 else {
//				 throw new TeamException("该团队架构师已满！");
//			 }
//		 }
		 int DESIGNER_NUM = 0;
		 int PROGRAMMER_NUM = 0;
		 int ARCHITECT_NUM = 0;
		 for(int i = 0;i < total;i++) {
			 if(team[i] instanceof Architect)
				 ARCHITECT_NUM++;
			 if(team[i] instanceof Designer)
				 DESIGNER_NUM++;
			 else
				 PROGRAMMER_NUM++;
		 }
//		 if(PROGRAMMER_NUM < 3)
		 if(p instanceof Architect) {
			 if(ARCHITECT_NUM >= 1)
				 throw new TeamException("该团队架构师已满！");
		 }
		 else if(p instanceof Designer) {
			 if(DESIGNER_NUM >= 2)
				 throw new TeamException("该团队设计师已满！");
		 }
		 else
			 if(PROGRAMMER_NUM >= 3)
				 throw new TeamException("该团队程序员以满！");
		 

			 team[total++] = p;
			 p.setStatus(Status.BUSY);
			 p.setMemberId(++count);
			 System.out.println("添加成功！");
			 
			 
}
	
	private boolean isExist(Employee e) {
		for(int i = 0;i < total;i++) {
			if(team[i].getId() == e.getId())
				return true;
		}
		return false;
	}


	public void removeMember(int memberId) throws TeamException{
		boolean flag = true;
		for(int i = 0;i < total;i++) {
			if(team[i].getMemberId() == memberId) {
				int j = i+1;
				flag = false;
				team[i].setStatus(Status.FREE);
				if(j == total) {
					team[i] = null;
					total--;
				}
				else {
					while(j < total) {
						team[j-1] = team[j];
						j++;
					}
					team[--total] = null;
				}
			}
		}
		
		if(flag)
			throw new TeamException("输入的团队ID不存在！");
			
		
		
	}
	
}
