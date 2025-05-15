package com.yedam.operator;

public class OperatorExe {
	public static void main(String[] args) {
//		test();
//		test1();
//		test2();
//		test3();
//		test4();
		test5();
	}

	// 연습1.
	public static void test() {
		// 증가, 감소 연산자(++,--)
		byte num1 = -128;
		num1 = 127;
		num1++;
		System.out.println(num1);

		char ch1 = 'A';
		ch1 = 66;
		ch1 = '가';

	}// end of test

	public static void test1() {

		byte a1 = 10;
		byte a2 = 20;
		byte sum = (byte) (a1 + a2);
		long a3 = 10000000000000L;
		System.out.println(Long.MAX_VALUE);
		System.out.println(a3);
	}// end of test1

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		System.out.printf("num1 => %d, num2 => %d, result => %d", num1, num2, result);

		// 논리부정연산자 (!)
		// == 부정은 !=, >부정은 <=, >=부정은 >
		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("거짓입니다.");

		}
		result = 30;
		if (!(result > 30)) {
			System.out.println("\nresult 는 30보다 작거나 같음.");
		}
		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 => %d", num1);
		}
	}

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글 (on->off,off->on)
		}
	}// end of test3

	// "월"정보를 입력하면 "공란"을 반환하는 메소드.getSpace()

	public static int getSpace(int month) {
		int space = 0;
		if (month == 3) {
			space = 6;
		} else if (month == 4) {
			space = 2;
		} else if (month == 5) {
			space = 4;
		} else if (month == 1) {
			space = 3;
		} else if (month == 2) {
			space = 6;
		} else if (month == 7) {
			space = 2;
		} else if (month == 8) {
			space = 5;
		} else if (month == 9) {
			space = 1;
		} else if (month == 10) {
			space = 3;
		} else if (month == 11) {
			space = 6;
		} else if (month == 12) {
			space = 1;
		}
		return space;
	}

	// "월"정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	}

	public static void test4() {
		System.out.println("Sun Mon Tue Wed Thu Fri Sat");
		// 빈공간
		int mon = 6; // "월"정보 입력
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);

		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", "");
		}

		// 날짜 출력.
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day);
			if (day % 7 == 3) {
				System.out.println();
			}
		}
	}

	public static void test5() {
		String pass = "";
		int score = (int) (Math.random() * 100);
//		if (score > 60) {
//			if(score>=80) {
//				pass = "우수";
//			}else {
//			pass = "합격";
//		}
//		}else {
//			pass = "불합격";
//		}
		// 삼항연산자로 변경.
		pass = (score > 60) ?(score>=80)?"우수": "합격" : "불합격";
		System.out.println(pass);
		System.out.printf("%d점은 %s\n", score, pass);
	}
}
