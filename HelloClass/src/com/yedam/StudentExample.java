package com.yedam;

/*
 * 실행클래스.
 */
public class StudentExample {
	public static void main(String[] args) {
		// 클래스 변수 인스턴스 생성.
		Student student = new Student();
//		student.studentNo = 1001;
//		student.studentName = "홍길동";
		student.setStudentNo(1001);
		student.setStudentName("홍길동");
//		student.engScore = 90;
//		student.mathScore = 88;
		student.setEngScore(90);
		student.setMathScore(88);
		student.height = 189;
		student.introduce();
		System.out.printf("이름 : %s \n 영어: %d 수학: %d\n"
				+ "",student.studentName,student.engScore,student.mathScore);

		Student student2 = new Student(1002, "김민규");
//		student2.studentNo = 1002;
//		student2.studentName = "김민규";
//		student.engScore = 75;
//		student.mathScore = 78;
		student.setEngScore(-75);
		student.setMathScore(-78);
		student2.study();
		student2.introduce();
		System.out.printf("이름 : %s \n 영어: %d 수학: %d\n"
				+ "",student2.studentName,student2.engScore,student2.mathScore);

	}
}
