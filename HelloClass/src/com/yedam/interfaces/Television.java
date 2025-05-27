package com.yedam.interfaces;

public class Television implements RemoteControl {
	@Override
	public void turnOn() {
		System.out.println("tv 킴");
	}

	@Override
	public void turnOff() {
		System.out.println("tv끔");
	}
}
