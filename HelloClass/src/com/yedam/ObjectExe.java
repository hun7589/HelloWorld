package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
		//호출(Calendar)
//		Calendar.showMonth();
		Scanner scn = new Scanner(System.in);
		System.out.println("년도를 입력하세요>>>");
		int year = scn.nextInt();
		Calendar.isLeapYear(year);
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "년은 윤년");
		} else {
			System.out.println(year + "년은 평년");
		}


		
		//"2010년은 평년입니다."
		//"2000년은 윤년입니다."
	}
}
