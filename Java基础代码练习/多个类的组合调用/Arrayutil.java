package com.hejianfeng.keytest;

public class Arrayutil {
	
	//求数组最大值
	public int getMax(int[] arr) {
		int max = 0;
		for(int i = 0;i<arr.length;i++) {
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}
	//求数组最小值
	public int getMin(int[] arr) {
		int min = 0;
		for(int i = 0;i<arr.length;i++) {
			if(min > arr[i])
				min = arr[i];
		}
		return min;
	}
	//求平均值
	public int getAvg(int[] arr) {
		int avg = 0;
		for(int i = 0;i<arr.length;i++) {
			avg +=arr[i];
		}
		avg /=arr.length;
		return avg;
	}
	//
	//
	//
	
	


}
