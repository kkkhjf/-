package com.hejianfeng.keytest;

public class Overload {
	public static void main(String[] args) {
		double n = 10;
		double m = 7;
		double x = 5;
		Overload col = new Overload();
		col.max(m, n, x);
	}
	
	public void mOl(int m,int n) {
		System.out.println(m+" "+n);
	}
	
	
	public void mOl(int m) {
		System.out.println(m);
	}
	
	public void mOl(String m) {
		System.out.println(m);
	}
	
	public void max(int m,int n) {
		if(m>n) {
			System.out.println("两个数的最大值："+m);
		}
		else {
			System.out.println("两个数的最大值："+n);
		}
	}
	
	public void max(double m,double n) {
		if(m>n) {
			System.out.println("两个数的最大值："+m);
		}
		else {
			System.out.println("两个数的最大值："+n);
		}
	}
	
	public void max(double m,double n,double x) {
		if(m>n) {
			if(m>x)
				System.out.println("三个数中最大值为："+m);
			else
				System.out.println("三个数中的最大值是："+x);
		}
		else if(n>x) {
			System.out.println("三个数中的最大值为："+n);
		}
			
	}

}
