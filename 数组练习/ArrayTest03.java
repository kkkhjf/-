package com.hejianfeng.contact;

import java.util.Random;

public class ArrayTest03 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		for(int i = 0;i < 10;i++)
			arr[i] = (int) (Math.random()*100);
		
		for(int i = 0;i < 10;i++)
		    System.out.print(arr[i]+"\t");
		
		//最大值、最小值、平均值和总和
		
		int maxvalue = 0;
		for(int i = 0;i < 10;i++) {
			if(maxvalue < arr[i])
				maxvalue = arr[i];
		}
		System.out.println("最大值为："+maxvalue);
	}

}
