package com.yedam;

import java.util.Scanner;

public class Calendar {
	
	
	static boolean isLeapYear(int year) {
		return false;
	}
	
	
	Scanner scn = new Scanner(System.in);
	static void showMonth() {
	System.out.println("Sun Mon Tue Wed Thu Fri Sat");
	System.out.println("============================");
	
	//Sun Mon Tue Wed Thu Fri Sat
	//============================
	//                 1   2   3
	// 4   5   6   7   8   9   10
	boolean run = true;
	while(run) {
//		int searching = monthInput();
		switch(searching){
		
		
		case 5:
			for(int i = 1;i<=31;i++) {
				
			}
		case 2:
			
		}
	}
	
	}//END OF showMonth
	
	 int monthInput(String mon) {
		System.out.print(mon+">>");
		return Integer.parseInt(scn.nextLine());
	
	 }
	 
	 
	 
}//END OF CLASS
