package com.hejianfeng.team.domain;

import com.hejianfeng.team.service.Status;


public class Programer extends Employee{
	
	private int memberId;//开发团队中的ID
	private Status status = Status.FREE;
	private Equipment equipment;
	public Programer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Programer(int id, String name, int age, double salary,Equipment equipment) {
		super(id, name, age, salary);this.status = status;
		this.equipment = equipment;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	@Override
	public String toString() {
		return getDtials() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}
	
	public String getDetialsForTeam() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" +getAge() + "\t" + getSalary() + "\t" + "程序员";
	}
	
}
