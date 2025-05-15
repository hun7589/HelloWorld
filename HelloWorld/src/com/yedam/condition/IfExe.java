package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
	public static void main(String[]args) {
//		test();
		
		// 1~1000 사이의 임의의 값을 생성.
		//500 입력하면 "입력값보다 큽니다" 출력.
		//
		int ran = (int)(Math.random()*1000)+1;	
		System.out.println("임의의 수(1~1000)를 생성하였습니다. 재주껏 맞춰보십시오.");		
		System.out.printf("정답은 %d(이)지만 양심상 몇번 입력 해봐바",ran);	
		int cnt = 0;
		

		while(true) {
			Scanner scn = new Scanner(System.in);
			int s = Integer.parseInt(scn.nextLine());
			if(s==ran) {
				cnt++;
				System.out.printf("정답입니다.%d번만에 맞추셨습니다.",cnt);
			}else if(s>ran) {
				cnt++;
				System.out.printf("오답\n 입력값보다 큽니다.%d번째 시도입니다.",cnt);
			}else if(s<ran) {
				cnt++;
				System.out.printf("오답\n 입력값보다 작습니다.%d번째 시도입니다.",cnt);
			}
		}
	}
	
	
	public static void test() {
	int score = (int)(Math.random()*100)+1;
		
		//if.
//		if(score>=90) {
//			System.out.println("A");
//		}else if(score>=80) {
//			System.out.println("B");
//		}else if(score>=70) {
//			System.out.println("C");
//		}else {
//			System.out.println("불합격");
//		}
		
		score = score/10;
		
		switch(score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		}//end of switch
		System.out.println(score);
		
		
char grade = 'a';
		
		switch(grade) {
		case 'A':
		case 'a':
			System.out.println("우수회원입니다.");
			break;
		case 'B':
		case 'b':
			System.out.println("일반 회원입니다.");
			break;
		default:
			System.out.println("손님입니다.");
		}
		
		
	}
	
	
	
}

