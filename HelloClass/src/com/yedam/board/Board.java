package com.yedam.board;
//글 번호, 제목, 내용, 작성자 : 필드
//getter/setter 작성 : 메소드.
//기본생성자, 전체매개값을 갖는 생성자.
public class Board {
	
	private int bNo;	//글 번호.
	private String title; //제목
	private String content;//내용
	private String author;//작성자
	
	//생성자.
	public Board() {}
	public Board(int bNo,String title,String content, String author) {
		this.bNo = bNo;
		this.title = title;
		this.author = author;
		this.content = content;
	}
	
	
	
	
	//	getter/setter
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void showInfo() {
		System.out.printf("\n%3d %10s  %8s",bNo,title,author);
	}
	//상세보기.
	public void showAllInfo() {
		//글번호: 5      작성자:OOO
		//제목 : 날씨가 좋아요
		//내용 : 오늘 30도가 넘는데도 좋아요.
		String strFormat = "글번호: %d     작성자:%s\n";
		strFormat +="제목 : %s\n";
		strFormat +="내용 : %s\n";		
		System.out.printf(strFormat,bNo,title,content,author);
	}
}
