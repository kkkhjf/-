package com.hejianfeng.keytest;

//Java生成指定范围内的随机数：random.nextInt(maxnum)%(maxnum-minnum+1)+minnum

import java.util.*;

public class classtest {
	public static void main(String[] args) {
		Student[] arr = new Student[20];
		for(int i = 0;i<arr.length;i++) {
			arr[i] = new Student();//注意对象数组只是一个对象名的数组，其中每个数组元素都还没有new一个存储空间
			arr[i].num = (int) (Math.random()*100);
			arr[i].score = (int)(Math.random()*100);
			arr[i].state = (int)(Math.random()*3+1);
		}
		
		for(int i = 0;i < arr.length;i++) {
			System.out.println(arr[i].num+"\t"+arr[i].score+"\t"+arr[i].state);
		}
	}

}

class Student{
	int num;
	int state;
	int score;
	
	
}
