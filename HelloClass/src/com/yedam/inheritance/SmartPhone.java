package com.yedam.inheritance;

/*
 * CellPhone을 상속.
 */
public class SmartPhone extends CellPhone {
	int channel;

	void watch() {
		System.out.println(channel + "번 채널 시청합니다.");
	}

	// 부모클래스의 기능을 자식클래스 재정의 (overriding)
	@Override
	public void powerOn() {
		System.out.println("전원 킨다?");
	}

	@Override
	public void powerOff() {
		System.out.println("전원 끌게?");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"channel="+channel+"]";
	}
}
