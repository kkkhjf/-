package com.hejianfeng.team.domain;

import com.hejianfeng.team.service.*;

public class Designer extends Programer{

	private double bouns;

	public Designer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Designer(int id, String name, int age, double salary,Equipment equipment,double bouns) {
		super(id, name, age, salary,equipment);
		// TODO Auto-generated constructor stub
		this.bouns = bouns;
	}

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}
	
	
	@Override
	public String toString() {
		return getDtials() + "\t设计师\t" + getStatus() + "\t" + bouns + "\t\t" + getEquipment().getDescription();
	}
	
	
	public String getDetialsForTeam() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" +getAge() + "\t" + getSalary() + "\t" + "\t设计师\t" + getBouns();
	}
	
	
	
}
