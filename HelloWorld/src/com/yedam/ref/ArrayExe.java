package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {
//		strAry();
//		deleteAry();
		friendApp();
	}

	// test3()
	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[10];

		boolean run = true;
		while (run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.println("선택>> ");
			// 메뉴 선택.
			int menu = Integer.parseInt(scn.nextLine());
			//
			switch (menu) {
			case 1:
				System.out.print("이름 입력>> "); // 추가.
				String name = scn.nextLine();
				// 배열에 추가.
				for (int i = 0; i < friendAry.length; i++) {
					// 빈공간(null)이 있는지 체크.
					if (friendAry[i] == null) {
						friendAry[i] = name;
						System.out.println("입력성공");
						break;
					}
					if(friendAry[i].equals(name)) {
						System.out.println("동일한 이름이 이미 있습니다. 추가하시겠습니까?  Y/N");
						String x = scn.nextLine();
						if(x.equals('y')||x.equals('Y')) {
							friendAry[i+1]=name;
							break;
						}else if(x.equals('n')||x.equals('N')){
						break;
						}
					}
				}

				break;
			case 2:
				// 목록.

				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.printf("친구이름 : %s\n", friendAry[i]);
					}
				}

				break;
			case 3:
				System.out.print("삭제할 친구 이름>> \n");
				String menu2 = scn.nextLine();
				for (int i = 0; i < friendAry.length; i++) {
					if ((friendAry[i] != null) && (friendAry[i].equals(menu2))) {
						friendAry[i] = null;
					}
				}
		
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null) {
						System.out.print("입력하신 값은 삭제되었습니다.\n");
					}
				

				}
			
				// 삭제.

				break;
			case 4:
				run = false;
				// 종료.
			}
		} // end of while.
		System.out.println("end of prog.");
	}// end of friendApp()

	// 문자열배열.
	// 배열을 쓸 때에는 null값을 항상 확인.

//test1()
	public static void strAry() {
		Scanner scn = new Scanner(System.in);

		String[] stringAry = new String[10]; // 입력값을 저장.

		while (true) {
			System.out.println("이름을 입력>> ");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break;// while문 종료
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null)이 있는지 체크.
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공");
					break;
				}
			} // end of for.
		} // end of while.
			// 입력값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}

		}
		System.out.println("end of prog.");

	}// end of strAry.

//test2()
	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";
		stringAry[1] = "이준영";
		stringAry[2] = "이승용";
		stringAry[3] = "최원호";

		System.out.print("삭제할 친구 이름>> ");
		String name = scn.nextLine();

		// 삭제할 친구이름을 검색.
		for (int i = 0; i < stringAry.length; i++) {
			if ((stringAry[i] != null) && (stringAry[i].equals(name))) {
				stringAry[i] = null;
			}
		} // end of for.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("%d번째 이름은 %s\n", i, stringAry[i]);
			}

		}
		System.out.println("end of prog.");
	}
}// end of class.
