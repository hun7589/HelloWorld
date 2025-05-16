package com.yedam.ref;

import java.util.Scanner;

public class TodoExe {
	public static void test6() {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.학생수| 2.점수입력| 3.점수리스트 | 4.분석 | 5.종료 |");
			System.out.println("------------------------------------------------");
			System.out.println("선택>");

			int selectNo = Integer.parseInt(scn.nextLine());

			if (selectNo == 1) {
			//학생수	
				studentNum = Integer.parseInt(scn.nextLine());
				break;

			} else if (selectNo == 2) {
				//입력된값 점수에 저장
				int score = Integer.parseInt(scn.nextLine());
				for(int i =0;i<studentNum;i++) {
					System.out.printf("score[%d]",i);
					int score = Integer.parseInt(scn.nextLine());
					scores[i]=score;
				}
			} else if (selectNo == 3) {
				//목록
				for(int i)
				
			} else if (selectNo == 4) {
				//최고점수&평균점수
			} else if (selectNo == 5) {
				run = false;
			}

		}
		System.out.println("프로그램종료");
	}
}
