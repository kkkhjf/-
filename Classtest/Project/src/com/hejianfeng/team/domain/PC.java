package com.hejianfeng.team.domain;

import com.hejianfeng.team.service.*;

public class PC implements Equipment{

	private String model;
	private String display;
	
	public PC(String model,String display){
		this.model = model;
		this.display = display;
	}
	
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		
		
		return model+"("+display+")";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	
}
