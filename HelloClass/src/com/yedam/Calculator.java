package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1)메소드의 선언.
 * 2)매개변수.
 * 3)반환유형
 */
public class Calculator {
	/*
	 * 필드. 생성자. 메소드
	 */

	String printStar(int times,String shape) {//매개변수(times)지정.
		String str = "";
		for (int i = 1; i <= times; i++) {
//			System.out.print("☆");
			str+=shape+"\n";
		}
		return str;
	}//end of printStar.
	
	
	
	//method overloading
	int add(int num1,int num2){
		return num1+num2;
		
	}
	
	double add(double num1,double num2){
		return num1+num2;
	}
	
	//정수 배열을 매개값으로 받는 add.
	double add(int[] x) {
		int cnt = 0;
		for(int i = 0;i<x.length;i++) {
			cnt += x[i];
		}
		//int => double 타입으로 자동형변환.
		return cnt; 
		
	}

	//배열에서 point가 가장 많은 사람을 찾아서 반환.
	
	Member getMaxPoint(Member[] memAry) {
		Member max = null;//아이디,이름,연락처,포인트
		int maxPoint = 0;//포인트를 비교하기 위한 변수
		for(int i =0;i<memAry.length;i++) {
		if(maxPoint<memAry[i].getPoint()) {
			maxPoint = memAry[i].getPoint(); //비교용도.
			max = memAry[i];
				
			}
		}
		return max;

	}

}
