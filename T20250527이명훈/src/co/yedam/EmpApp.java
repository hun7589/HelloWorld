package co.yedam;

import java.util.List;
import java.util.Scanner;

public class EmpApp {
	public static void main(String[] args) {
		// 앱을 실행하는 클래스.
		EmpDAO dao = new EmpDAO();
		
		// 사용자의 입력을 처리하도록 작성하세요.
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			// 이곳에 메뉴작성.
			// 1.등록 2.목록 3.수정(급여) 4.삭제 5.조회(입사일자) 6.종료
		System.out.println("1.등록  2.목록  3.수정(급여) 4.삭제  5.조회(조건:입사일자)  6.종료");	
		System.out.println("메뉴 선택>> ");
		String menu = scn.nextLine();
		switch(menu) {
		case "1" ://등록
			System.out.println("사번입력>> ");
			String empNo =scn.nextLine(); 
			System.out.println("이름입력>> ");
			String name = scn.nextLine();
			System.out.println("전화번호입력>> ");
			String phone = scn.nextLine();
			System.out.println("입사일입력>> ");
			String hiredate = scn.nextLine();
			System.out.println("급여입력>> ");
			int salary =Integer.parseInt(scn.nextLine()); 
			Employee emp = new Employee(empNo, name, phone, hiredate, salary);
			dao.add(emp);
			System.out.println("등록 완료되었습니다.");
            break;
			
			
		case "2" ://목록
			List<Employee> list = dao.list();
			if(list.isEmpty()) {
				System.out.println("등록된 사원이 없습니다.");
			}else {
				System.out.println("사번   이름    전화번호");
				for(Employee e : list) {
					System.out.println(e);
				}
			}
			break;
		case "3" ://수정
			System.out.print("사번>>  ");
			String chempNo = scn.nextLine();
			System.out.println("급여>> ");
			int chsalary = Integer.parseInt(scn.nextLine());
			
			boolean update = dao.modify(chempNo,chsalary);
			if(update) {
				System.out.println("급여가 변동되었습니다.");
			}else {
				System.out.println("없는 사원입니다.");
			}break;
		case "4" ://삭제
			System.out.println("사번>> ");
			String delete = scn.nextLine();
			
			boolean deleted = dao.remove(delete);
			if(deleted) {
				System.out.println("삭제하였습니다.");
			}else {
				System.out.println("그런 사번의 사원은 없습니다.");
			}
			break;
		case "5" ://조회(입사일자)
			System.out.println("입사일자>> ");
			String date = scn.nextLine();
			
			List<Employee> found = dao.searching(date);
			if(found.isEmpty()) {
				System.out.println("그 날짜의 입사인원은 없습니다.");
			}else {System.out.println("사번   이름    입사일자");
	        for (Employee e : found) {
	            System.out.println(e.hireDay());
	        }
	    }
	    break;
		case "6" ://종료
			System.out.println("프로그램을 종료합니다.");
            scn.close();
            return;
		}
		}
		System.out.println("end of prog.");
	} // end of main.
}
