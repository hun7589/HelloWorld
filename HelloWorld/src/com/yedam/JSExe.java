package com.yedam;

import java.util.Scanner;

public class JSExe {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
//		System.out.println(num1 == num2);

//		String str1 = new String("Hello");
//		String str2 = new String("Hello");
//		System.out.println(str1);
//		System.out.println(str2);
//		System.out.println(str1.equals(str2));// 문자열을 비교할 때에는 equals를 사용함.
//
//		String str3 = "30";
//		int num3 = 30;
//
//		System.out.println(str3.equals("" + num3));
//		int num4 = Integer.parseInt(str3); // 문자열 숫자.
//		System.out.println(num3 == num4);// 30 vs. "30" ->30
//		test3();
//		test4();
//		test2(); // 평균 구하기
		test0();
	}// end of main.

	public static void test() {
		int sum = 0;
		// 1~10 까지의 누적.
		for (int i = 1; i < 11; i++) {
			if (i % 2 == 1) {// i를 2로 나누었을 때 나머지가 1일때 (==홀수일때)
				sum += i;
			}
		}
		System.out.println("1에서 10까지 홀수를 더한 값은 : " + sum);

	}// end of test

	public static void test2() {
		// 임의의 수를 생성. 1~1000 사이의 임의의 값 생성.
		// 평균 : 173/5 => 34.6
		// 1<= x < 11 의 값
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			double result = (double) (Math.random() * 100) + 1;
			sum += result;
		}
		double x = ((double) sum) / 3;
		System.out.println("3명 점수의 합: " + sum);
		System.out.println("3명의 평균 점수: " + x + "점");
//				System.out.println(Math.round(x*100)/100.0);
		System.out.printf("소숫점 둘째자리 까지 표현 : " + "%.2f", x);
	}// end of test2

	public static void test3() {

		// 사용자의 입력값을 읽어들이기.
		Scanner scn = new Scanner(System.in); // eclipse import 단축키 : ctrl+shift+o
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환.
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("점수의 합계 : " + sum);
		System.out.println("합계: " + sum + ",평균 : " + avg);
	}// end of test3

	public static void test4() {

		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("메시지 입력. 종료하려면 quit>>");
			String msg = scn.nextLine();
			// equals로 비교.
			if (msg.equals("quit")) {
				break;
			}
			System.out.println("입력한 값은 " + msg + " 입니다.");

		}
		// 홍길동,김민규,최석영
		// 친구목록은 홍길동, 김민규, 최석영 입니다 에추 에추 에추 에추.

		System.out.println("End of Program.");
	}

	public static void test0() {
		Scanner scn = new Scanner(System.in);
		String str = "친구목록은 ";
		while (true) {
			System.out.println("친구 이름을 입력하세요.");
			String fri = scn.nextLine();
			if(fri.equals("quit")) {
				str +=" 입니다.";
				break;
			}
			str += fri+"  ";
			
		}
		System.out.println(str);
		
	}// end of JSExe
}