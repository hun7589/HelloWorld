package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {

	// "가위(1)","바위(2)","보(3)"
	// 1,2,3 <==> 가위(1),바위(2),보(3),종료(4)
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		double odd = 0;
		int win = 0;
		int lose = 0;
		int draw = 0;
		while (true) {
			int rcp = (int) (Math.random() * 3) + 1;
//			System.out.println(rcp);
		//치트키
			System.out.println("1.가위 2.바위 3.보 4.종료");
			int me = Integer.parseInt(scn.nextLine());
			if (me < 1 || me > 4) {
                System.out.println("1~4 사이의 숫자를 입력해주세요.");
                continue;
            }else if (me == 4) {
				System.out.printf("게임이 종료되었습니다.\n이긴횟수 : %d 회\n진 횟수: %d 회\n비긴 횟수 : %d 회\n승률: %.2f",win,lose,draw,(win / odd) * 100);
				break;
			} 
			else if (me == rcp) {
				System.out.println("Same");
				draw++;
				odd++;
				continue;
			} else {
				if (rcp == 1) {// 컴퓨터 가위
					switch (me) {
					case 2:
						System.out.println("You win");
						win++;
						odd++;
						break;
					case 3:
						System.out.println("You Lose");
						lose++;
						odd++;
						break;

					}
				} else if (rcp == 2) {// 컴퓨터 바위
					switch (me) {
					case 1:
						System.out.println("You Lose");
						lose++;
						odd++;
						break;
					case 3:
						System.out.println("You Win");
						win++;
						odd++;
						break;
					}
				} else if (rcp == 3) {// 컴퓨터 보
					switch (me) {
					case 1:
						System.out.println("You win");
						win++;
						odd++;
						break;
					case 2:
						System.out.println("You Lose");
						lose++;
						odd++;
						break;
					}
				}
			}
		}
	}

	public static void test() {
		// while vs. do .. while
		boolean run = false;

//		while(run) {
//			System.out.println("while문");
//		}

		do {
			System.out.println("while문");
			run = !run;
		} while (run = !run);

		System.out.println("end of porg.");
	}
}
