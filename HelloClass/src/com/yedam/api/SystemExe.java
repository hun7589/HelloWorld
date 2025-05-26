package com.yedam.api;

public class SystemExe {
public static void main(String[] args) {
	//
	long start = System.nanoTime();
	//currentTimeMillis();
	int sum =0;
	for(int i =0;i<100000000;i++) {
		sum += i;
	}
	long end = System.nanoTime();	//currentTimeMillis();
	
	long now = System.currentTimeMillis();
	
	long sec = now/1000;
	sec = sec%60;
	long min = (long)now/(1000*60);
	min = min%60;
	long hour =(long)now/(1000*60*60);
	hour = hour%60;
	long day = (long)now/(1000*60*60*24);
	day = day/24;
	long year = (long)now/(1000*60*60*24*365);
	year = day;
	
	
	System.out.printf("초:%d  분:%d 시간:%d 일:%d  년:%d\n",sec,min,hour,day,year);
	
	
	System.out.printf("합계 %d, 걸린시간 %d\n",sum,(end-start));
	
}
}
