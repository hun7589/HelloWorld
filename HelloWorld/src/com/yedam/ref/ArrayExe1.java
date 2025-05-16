package com.yedam.ref;

public class ArrayExe1 {

	public static void main(String[] args) {
//		test0();
//		test2();
//		test3();
//Math.random 활용해서 10~100 사이의 점수를 생성.
//학생 10명의 점수를 생성해서 학생점수의 평균을 구하고 최고점수가 몇점인지 구하시오. 
		int max = 0;
		int sum = 0;
		int[] scoreAry = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = (int) (Math.random() * 91) + 10;
			scoreAry[i] = num;
			System.out.printf("%d\n",num);
		}
		for(int i = 1; i<scoreAry.length;i++) {
			sum+=scoreAry[i];
		}
		for (int i = 1; i < scoreAry.length; i++) {

			if (max < scoreAry[i]) {
				max = scoreAry[i];
			}
		}
		double avg = sum/10;
		
		System.out.printf("최대값은 %d\n", max);
		System.out.printf("점수의 평균값은 %.2f",avg);
	}

//183p 3번
	public static void test() {
		int dice = 0;
		boolean game = true;

		while (game) {
			int d1 = (int) (Math.random() * 5) + 1;
			int d2 = (int) (Math.random() * 5) + 1;
			dice = d1 + d2;
			if (dice == 5) {
				System.out.printf("{%d,%d} 주사위의 합이 5가 되었습니다.", d1, d2);
				break;
			} else if (dice != 5) {
				System.out.printf("{%d,%d}", d1, d2);
			}
		}
	}

//183p. 4번
	public static void test2() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.printf((" (%d,%d)\n"), x, y);
				}
			}
		}
	}

	// 183p
	public static void test3() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.println("#");
				if (i == j) {
					System.out.println();
				}
			}
		}
	}

	public static void test0() {
		// int배열 => intAry : 10,17,22,31,55,24
		int[] intAry = new int[] { 10, 17, 22, 31, 55, 24 };
		int temp = 0;
		// 정렬.
		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				// 큰 값 기준으로 위치변경.
				if (intAry[i] < intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}
		// 출력
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("i: %d, 값: %d\n", i, intAry[i]);
		}
		if (temp != 0) {
			return;
		}
		// 최고값

		int max = 0;
		for (int i = 0; i < intAry.length; i++) {
			// max와 배열요소를 비교. 큰값을 max에 저장.
			if (max < intAry[i]) {
				max = intAry[i];
			}
		}
		System.out.printf("최대값은 %d\n", max);

		if (max != 0) {
			return;
		}
		// 합
		int sum = 0;
		int cnt = 0;// 횟수

//		for (int i = 0; i < intAry.length; i += 2) {

		for (int i = 0; i < intAry.length; i++) {
			if (intAry[i] % 2 == 0) {
				sum += intAry[i];
				cnt++;
				System.out.printf("sum: %d, i: %d,값 : %d\n", sum, i, intAry[i]);
			}
		}
		double avg = 1.0 * sum / cnt;
		System.out.printf("평균: %.1f\n", avg);
//		}
	}// end of test0()
}// end of class.
