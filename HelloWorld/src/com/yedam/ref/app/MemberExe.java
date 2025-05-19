package com.yedam.ref.app;

import java.util.Scanner;

/*
 * 회원추가, 수정,삭제,조회 기능.
 * 1)추가
 * -아이디,이름,전화번호,포인트
 * 2)수정
 * -아이디
 * -전화번호(바뀔항목)
 * 3)삭제
 * -아이디
 * 4)조회
 * -이름(조회)
 */
public class MemberExe {
	static member[] members = null;
	public static void main(String[]args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("----------------------------------------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.조회");
			System.out.println("----------------------------------------------------------------");
			System.out.print("선택>>");
			int selec = Integer.parseInt(scn.nextLine());
			if(selec ==1) {
				for(int i =0;i<members.length;i++) {
					
				}
				
			}else if(selec ==2) {
				
			}else if(selec ==3) {
				
			}else if(selec ==4) {
				
			}
		}
		
	}
	
	public static void joinMem() {
		
	}
}
