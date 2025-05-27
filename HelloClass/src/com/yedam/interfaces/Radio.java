package com.yedam.interfaces;

public class Radio implements RemoteControl{
	@Override
	public void turnOn() {
		System.out.println("라디오 킴");
	}
	@Override
	public void turnOff() {
		System.out.println("라디오 끔");
	}
}
