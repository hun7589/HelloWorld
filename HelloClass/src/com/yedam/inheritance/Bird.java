package com.yedam.inheritance;

public class Bird extends Animal {

	@Override
	public void sound() {
		// 부모클래스의 sound() 재정의 해야함.
		System.out.println("짹짹");
		
	}

}
