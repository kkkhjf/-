package com.hejianfeng.team.view;

import java.util.*;

public class TSUtility {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static char readMenuSelection() {
		char num;
		while(true) {
			String str = readKeyBoard(1,false);
			num = str.charAt(0);
			if(num != '1' && num != '2' && num != '3' && num != '4' && num != '5') {
				System.out.println("请输入1-5之间的值");
				continue;
			}
			break;
		}
		return num;
	}
	
	public static void readReturn() {
		String str = "";
		while(true) {
			System.out.print("按回车继续。。。");
			str = scanner.nextLine();
			if(str.length() == 0)
				break;
		}
	}
	
	
	public static int readInt() {
		int n;
		while(true) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);   //字符串转换成数字，Integer.paresInt();
				break;
			}catch(NumberFormatException e){
				System.out.println("数字输入有误，请重新输入！");
			}
		}
		return n;
	}
	
	public static char readConfirmSelection() {
		char c;
		while(true) {
			String str = readKeyBoard(1, false).toUpperCase();
			c = str.charAt(0);
			if(c == 'Y'|| c == 'N') {
				break;
			}
			else {
				System.out.println("选择错误，请重新输入！");
			}
		}
		return c;
	}
	
	
	
	public static String readKeyBoard(int limit,boolean flag) {
		String str = "";
		while(scanner.hasNextLine()) {
			str = scanner.nextLine();
			if(str.length() == 0)
				if(flag)
					return str;
				else {
					System.out.println("请输入有效信息！");
					continue;
				}
			
			if(str.length() < 1 || str.length() > limit) {
				System.out.println("请按规定输入信息！");
				continue;
			}
			break;
		}
		return str;
		
		
	}
}