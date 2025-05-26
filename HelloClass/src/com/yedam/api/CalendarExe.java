package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Calendar: 날짜, 시간관련.
 * Date : 날짜, 시간,
 * 
 */
public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025,10);
	}
	
	public static void makeCalendar(int year,int month) {
		
		System.out.printf("	%d년    %2d월\n",year,month-1);
		System.out.println("===================================");
		System.out.println("SUN  MON  TUE  WED  THU  FRI  SAT");
		System.out.println("===================================");
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1,1);
		int x = cal.get(Calendar.DAY_OF_WEEK)-1;
		for(int i = 0; i<x;i++) {
			System.out.printf("%4s","");
		}
		for(int i =1;i<=cal.getActualMaximum(Calendar.DATE);i++) {
			System.out.printf("%4d",i);
			if((x+i)%7==0) {
				System.out.println();
			}
		}
		
		
	}
		
	public static void date() {
	Date today = new Date();
		System.out.println(today.toGMTString());
		
		//생성자의 매개값으로 포맷저장.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = sdf.format(today);
		System.out.println(timeStr);
		
		try {
			today = sdf.parse("2025-08-31 09:00:00");
		}catch(ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
		
		
	}
	
	
	public static void cId() {
		// Calendar클래스.
		Calendar now = Calendar.getInstance();
		// 시간변경.
		now.set(2025, 6, 7);
		now.set(Calendar.YEAR, 1999);

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}

		System.out.printf("년도 %d, 월: %d, 날짜: %d, 요일:%d, 말일: %d \n", now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DATE), now.get(Calendar.DAY_OF_WEEK), now.getActualMaximum(Calendar.DATE));

	}
}
