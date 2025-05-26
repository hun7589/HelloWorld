package com.yedam.interfaces;

public class Radio implements RemoteControl{
	public void turnOn() {
		System.out.println("라디오 킴");
	}
	public void turnOff() {
		System.out.println("라디오 끔");
	}
}
