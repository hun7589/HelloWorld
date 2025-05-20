package com.yedam.board;

import java.util.Scanner;

//BoardExe : 추가, 수정, 삭제, 목록.
public class BoardExe {
	//필드.
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);
	private int bno = 2; //배열인덱스를
	
	//생성자.
	public BoardExe() {
		boards = new Board[100];
		boards[0]= new Board(10,"날씨가 좋습니다.","오늘 기온이 30도가 넘습니다","강호동");
		boards[1]= new Board(11,"자바가 힘들어요","자바는 힘들지 않습니다?","유재석");
	}
	
	//method.
	void execute() {
		boolean run = true;
		while(run) {
			System.out.println("========================================");
			System.out.println("1.추가   2.수정   3.삭제   4.목록   5.종료");
			System.out.println("========================================");
			System.out.print("선택>>");
			int selec = Integer.parseInt(scn.nextLine());
			switch(selec) {
			case 1://추가
				addBoard();	
				break;
			case 2://수정
				
			case 3://삭제
				
			case 4://목록
				listBoard();
				break;
			case 5://종료
				
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			}//end of switch.
		}//end of while.
	}// end of execute.
	
	
	//기능
	//글 번호를 입력하세요>>
	//제목을 입력하세요>>
	//내용을 입력하세요>>
	//작성자를 입력하세요>>
	//추가 성공/추가 실패
	void addBoard() {
		System.out.print("글 번호를 입력하세요>> ");
		int bNo = Integer.parseInt(scn.nextLine());
		System.out.println("제목을 입력하세요>> ");
		String title = scn.nextLine();
		System.out.println("내용을 입력하세요>> ");
		String content = scn.nextLine();
		System.out.println("작성자를 입력하세요>> ");
		String author = scn.nextLine();
		//Board인스턴스 선언하고 값을 지정.
		Board board = new Board(bNo,title,content,author);
		//배열에 저장.
		boards[bno++] = board;
		System.out.println("추가 되었습니다.");
	}
	void editBoard() {//수정
		
		
		
	}
	
	void delBoard() {//삭제
		
	}
	
	void listBoard() {//목록
		System.out.println("글번호   |  제목	  | 작성자");
		System.out.println("===================================");
		for(int i=0;i<boards.length;i++) {
			if(boards[i]!=null) {
				boards[i].showInfo();
			
			}
			
			
		}
		//상세보기.
		System.out.println("\n===================================");
		System.out.println("상세보기ㅣ 글번호입력,   메뉴로이동(q)");
		System.out.println("===================================");
		String str = scn.nextLine();
		//메뉴,상세
		if(str.equals("q")) {
			return;
		}else {
			int no = Integer.parseInt(str);
			//배열에서 조회
			for(int i= 0; i<boards.length;i++) {
				if(boards[i]!=null && boards[i].getbNo()==no) {
					boards[i].showAllInfo();
				}
			}
		}
		
		
		System.out.println();
	}
	
}//end of BoardExe.
