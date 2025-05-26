package com.yedam.exception;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("1,메뉴 2.종료");
			System.out.println("선택>> ");
			int menu = 0;
			while(true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("1,메뉴 2.종료");
					System.out.println("메뉴를 다시 선택>> ");
					continue;
				}catch(NoSuchElementException e) {
					if(!scn.hasNext()) {
						scn.close();
						scn = new Scanner(System.in);
						
					}
					continue;
				}
				break;
			}
			
			switch(menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
			default:
				System.out.println("없는 메뉴를 선택해서 종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
		public static void 백업() {
		// NullPointerException
		//NumberFormatException
		//ClassCastException
		//ArrayIndexOutOfBoundsException
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();

		try {
			System.out.print(str.toString());
			int num = Integer.parseInt("a");
		}

		catch (NullPointerException e) {
			System.out.println("NULL값을 참조.");
		} catch (NumberFormatException e) {
			System.out.println("포맷이 비정상.");

		}finally {//정상실행, 예외발생 반드시 실행해야할 코드.
//			scn.close();//리소스를 환원.
			
		}
		System.out.println("end of prog.");
	}
}
