package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌의 금액.
		// 조건추가..10만원을초과(x),마이너스금액(x)
		while (true) {
			System.out.println("========================");
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			System.out.println("========================");
			int menu = Integer.parseInt(scn.nextLine()); // Integer.parseInt("30");
			if (menu == 1) {// 입금기능구현.
				System.out.println("입금액을 입력>>");
				int deposit = Integer.parseInt(scn.nextLine());
				if (!(balance >= 100000)) {
					if ((balance + deposit) < 100000 || (balance+deposit) == 100000){
						balance+=deposit;
						System.out.printf("%d원이 입금되었습니다.\n",deposit);
					}else if((balance+deposit)>100000) {
						System.out.println("이 계좌의 한도금액은 10만원입니다.\n ");
					}
				}else{
					System.out.println("계좌의 입금한도가 초과하였습니다.\n");
				}

			}//deposit end.
			else if (menu == 2) {// 출금기능구현
				System.out.println("출금액을 입력>>");
				int withdraw = Integer.parseInt(scn.nextLine());
				if (balance >= withdraw) {
					System.out.printf("계좌 잔고 %d원에서 %d원이 인출되었습니다.", balance, withdraw);
					balance -= withdraw;
				} else if (balance < withdraw) {
					System.out.printf("잔고가 부족합니다.");
				}
			}//withdraw end.
			else if (menu == 3) {// 잔고 확인.
				System.out.printf("현 잔액>>%d원", balance);
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
		} // end of while.
		System.out.println("end of program.");
	}
}
