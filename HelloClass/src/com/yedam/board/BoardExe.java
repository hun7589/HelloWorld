package com.yedam.board;

import java.util.Scanner;

//BoardExe : 추가, 수정, 삭제, 목록.조회.순번부여
public class BoardExe {
	// 필드.
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);
	private int bno = 2; // 배열인덱스를

	// 생성자.
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다.", "오늘 기온이 30도가 넘습니다", "강호동");
		boards[1] = new Board(11, "자바가 힘들어요", "자바는 힘들지 않습니다?", "유재석");
		boards[2] = new Board(12, "자바가 힘들어요", "자바는 힘들지 않습니다?", "이수근");
		boards[3] = new Board(13, "자바가 힘들어요", "자바는 힘들지 않습니다?", "김종민");
		boards[4] = new Board(14, "자바가 힘들어요", "자바는 힘들지 않습니다?", "김c");
		boards[5] = new Board(15, "자바가 힘들어요", "자바는 힘들지 않습니다?", "하하");
		boards[6] = new Board(16, "자바가 힘들어요", "자바는 힘들지 않습니다?", "김종국");
		boards[7] = new Board(17, "자바가 힘들어요", "자바는 힘들지 않습니다?", "최홍만");
		boards[8] = new Board(18, "자바가 힘들어요", "자바는 힘들지 않습니다?", "하정우");
		boards[9] = new Board(19, "자바가 힘들어요", "자바는 힘들지 않습니다?", "최민식");
		boards[10] = new Board(20, "자바가 힘들어요", "자바는 힘들지 않습니다?", "공유");
		boards[11] = new Board(21, "자바가 힘들어요", "자바는 힘들지 않습니다?", "김유정");
		boards[12] = new Board(22, "자바가 힘들어요", "자바는 힘들지 않습니다?", "김희정");
		boards[13] = new Board(23, "자바가 힘들어요", "자바는 힘들지 않습니다?", "이지안");

	}

	// method.
	void execute() {
		boolean run = true;
		//아이디 입력.
		//비밀번호 입력.
		String id = userInput("아이디를 입력");
		String pw = userInput("비밀번호를 입력");
		if(!UserExe.login(id,pw)){
			System.out.println("아이디 혹은 비밀번호를 확인하세요.");
			return;
		}
		while (run) {
			System.out.println("========================================");
			System.out.println("1.추가   2.수정   3.삭제   4.목록   5.종료");
			System.out.println("========================================");
			System.out.print("선택>>");
			int selec = Integer.parseInt(scn.nextLine());
			switch (selec) {
			case 1:// 추가
				addBoard();
				break;
			case 2:// 수정
				editBoard();
				break;
			case 3:// 삭제
				delBoard();
				break;
			case 4:// 목록
				listBoard();
				break;
			case 5:// 종료

			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}// end of switch.
		} // end of while.
	}// end of execute.

	// 기능
	// 글 번호를 입력하세요>>
	// 제목을 입력하세요>>
	// 내용을 입력하세요>>
	// 작성자를 입력하세요>>
	// 추가 성공/추가 실패
	void addBoard() {
		nextSequence();
		int bNo = Integer.parseInt(userInput("글 번호를 입력하세요"));
		String title = userInput("제목을 입력하세요");
		String content = userInput("내용을 입력하세요");
		String author = userInput("작성자를 입력하세요");
		// Board인스턴스 선언하고 값을 지정.
		Board board = new Board(bNo, title, content, author);
		// 배열에 저장.
		boards[bno++] = board;
		System.out.println("추가 되었습니다.");
	}

	void editBoard() {// 수정
		int bno = userMenu("수정할 글 번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다");
			return;
		}
		String title = userInput("수정할 제목 입력");
		String content = userInput("수정할 내용 입력");

		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정 완료");

	}

	void delBoard() {// 삭제
	}

	void listBoard() {// 목록
		int page = 1;
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5;
			System.out.println("글번호   |  제목	  | 작성자");
			System.out.println("===================================");
			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			// 상세보기.
			System.out.println("\n===================================");
			System.out.println("상세보기ㅣ 글번호입력, (다음:n)  메뉴로이동(q)");
			System.out.println("===================================");
			String str = scn.nextLine();
			// 메뉴,상세
			if (str.equals("q")) {
				break;// return;
			} else if (str.equals("n")) {
				page++;
			} else {

				int no = Integer.parseInt(str);
				// 배열에서 조회
				Board search = getBoard(no);
				if (search == null) {
					System.out.println("조회결과 없음.");
					return;
				}
				search.showAllInfo();
			}
		}
//			for (int i = 0; i < boards.length; i++) {
//				if (boards[i] != null && boards[i].getbNo() == no) {
//					boards[i].showAllInfo();
//				}
//			}

		System.out.println();

	} // end of listBoard.

	// 단건조회(getBoard)
	// 글번호를 활용해서 배열에서 조회하고 Board 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getbNo() == bno) {
				return boards[i];
			}
		}
		return null; // 조건에 맞는 글번호 없으면 null반환.
	}// END OF getBoard

	// 사용자의 입력값을 반환.
	String userInput(String msg) {
		System.out.print(msg + ">>");
		return scn.nextLine();
	}

	int userMenu(String msg) {
		System.out.print(msg + ">>");
		return Integer.parseInt(scn.nextLine());
	}

	void nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getbNo()) {
				max = boards[i].getbNo();
			}
		}

	}

	void sort() {

	}

}// end of BoardExe.
