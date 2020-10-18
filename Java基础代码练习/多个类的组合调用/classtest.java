package com.hejianfeng.keytest;

//Java生成指定范围内的随机数：random.nextInt(maxnum)%(maxnum-minnum+1)+minnum

public class classtest {
	private double base;
	private double height;
	private double tri;
	
	public classtest() {
		base = 0;
		height = 0;
		tri = 0;
	}
	
	public void Set(double n,double m,double k) {
		base = n;
		height = m;
		tri = k;
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getTri() {
		return tri; 
	}
		
}

//动态定义数组（int 为例）
//
//int[] arr null;
//
//int n = 10;
//arr = new int[n];
//
//
//
//
//
//
