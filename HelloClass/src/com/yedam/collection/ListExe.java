package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 활용하여 객체를 관리.
 * 순서를 가지고 중복된 값도 사용 가능.
 */
class Student{
	private int studentNo; //1001,1002,1003....1010;
	private int score;
	public Student(int studentNo,int score) {
		this.studentNo = studentNo;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}



public class ListExe {
	public static void main(String[] args) {
//		exe1();
// 		exe2();
		//10~100점 점수를 임의의 값으로 생성. 정수10개 생성.
		int sum = 0;
		double avg = 0;
		
		
		List<Student>numbers = new ArrayList<>();
		for(int i =0;i<10;i++) {
			numbers.add(new Student(1000+i,(int)(Math.random()*91)+10));
			sum+= numbers.get(i).getScore();
			System.out.println(numbers.get(i).getScore());
		}
		avg = (double)sum/numbers.size();
		
		System.out.printf("점수의 합계 : %d점\n점수의 평균 : %.1f점",sum,avg);
		
	}
	public static void exe2() {	
		List<Member>members = new ArrayList<>();
		Member member = new Member("금은동",20);
		
		members.add(new Member("홍길동",10));
		members.add(member);
		members.add(new Member("홍길은",12));
		
		
		String search = "홍길은";
		for(int it = 0;i<members.size();i++) {
			
		}
		//삭제
//		members.remove(member);
		
		for(int i = 0;i<members.size();i++) {
			System.out.println(members.get(i).toString());
		}
	}
	public static void exe1() {
		// int[] ary = {10,20,30.4};
		// 인터페이스 -구현클래스
//		List list = new ArrayList();
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add(new String("Hello"));
		list.add(1, "20");

		// 삭제
		list.remove(0);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		for (Object item : list) {
			System.out.println(item);
		}
	}
}
