package com.yedam.inheritance;
/*
 * 부모 : CellPhone
 * 	-전원on/off기능,볼륨up/down기능
 * 	-Model,Color
 * 자식 : SmartPhone
 * 	-TV보기
 */

public class CellPhone /*extends Object*/{
	String model;
	String color;
	
	void powerOn() {
		System.out.println("전원 ON");
	}
	void powerOff() {
		System.out.println("전원 OFF");
	}
	void 통화하기() {
		System.out.println("통화");
	}
	void VolUp() {
		System.out.println("볼륨UP");
	}
	void VolDn() {
		System.out.println("볼륨DOWN");
	}
	//toString() 오버라이딩.
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
	
}
