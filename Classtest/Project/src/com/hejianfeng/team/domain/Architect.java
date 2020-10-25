package com.hejianfeng.team.domain;

import com.hejianfeng.team.service.*;

public class Architect extends Designer{
	
	private int stock;

	public Architect() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Architect(int id, String name, int age, double salary,Equipment equipment,double bouns,int stock) {
		super(id, name, age, salary,equipment,bouns);
		// TODO Auto-generated constructor stub
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return getDtials() + "\t架构师\t"  + getStatus() + "\t" + getBouns() + "\t" + stock + "\t" + getEquipment().getDescription();
	}
	
	public String getDetialsForTeam() {
		return getMemberId() + "/" + getId() + "\t" + getName() + "\t" +getAge() + "\t" + getSalary() + "\t架构师\t" + getBouns() + "\t" + getStock();
	}
	
	
	
	

}
