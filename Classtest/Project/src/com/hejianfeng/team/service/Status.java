package com.hejianfeng.team.service;

public class Status { //枚举类

	private final String NAME;
	private Status(String NAME) {
		this.NAME = NAME;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");
	
	public String getName() {
		return NAME;
	}
	
	@Override
		public String toString() {
			return getName();
		}
}
