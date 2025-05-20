package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
public static void main(String[] args) {
	Calculator cal = new Calculator();
	int num1 = 10;
	String str = "%";
	String star = cal.printStar(num1, str);
	System.out.print(star);
	
	double sum =cal.add(num1,3.141592);
	System.out.print(sum);
	
	int[] numAry = {10,20,30};
	sum = cal.add(numAry);
	
	//Member[] 중에서 point가 제일 많은 회원을 반환.
	Member[] members = {
			new Member("user01","홍길동","1111",1000),
			new Member("user02","김민규","2222",3333),
			new Member("user03","황선홍","3333",2555),
			new Member("user04","홍명보","4444",8888)};
	
	Member member = cal.getMaxPoint(members);

	member.showInfo();
	
	System.out.println("10");
	System.out.println(10);
	System.out.println(true);
	System.out.println(sum);
		
}
}