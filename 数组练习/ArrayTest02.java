package com.hejianfeng.contact;

// 抽奖问题
import java.util.Random;

public class ArrayTest02 {
	public static void main(String[] args) {
		Random ran = new Random();
		boolean flag = true;
		int count = 0,i = 0;
		int[] arr = new int[]{0,0,0,0,0,0};
		while(true) {
			int b = ran.nextInt(30);
			//System.out.print("=="+b+"==");
			for(;i < 6;i++) {
				//System.out.print("--"+i+"--");
				for(int j = 0;j <= i;j++) {
					if(arr[j] == b) {
						flag = false;
						break;
					}
					else if(j == i) {
						arr[j] = b;
						count++;
					}
				}
				if(!flag) {
					flag = true;
					break;
				}
				
			}
			if (count == 6)
				break;
		}
		
		for(int j = 0;j < 6;j++) {
			System.out.print(arr[j] + " ");
		}
	}

}
