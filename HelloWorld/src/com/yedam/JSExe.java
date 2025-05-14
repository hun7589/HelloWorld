package com.yedam;

public class JSExe {
	public static void main(String[] args) {
		// 임의의 수를 생성. 1~1000 사이의 임의의 값 생성   .
		// 1<= x < 11 의 값
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 10) + 1;
			sum += result;
		}
		System.out.println("결과: "+sum);
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

}// end of JSExe
