package com.yedam.inheritance;

public class PhoneExe {
	public static void main(String[] args) {
		// 부모클래스.
		CellPhone phone1 = new CellPhone();
		phone1.model = "IT203";
		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		phone1.VolDn();
		phone1.VolUp();
		phone1.통화하기();
		System.out.println(phone1.toString());

		// 자식클래스.
		SmartPhone phone2 = new SmartPhone();
		phone2.model = "S22 ULTRA";
		phone2.color = "WHITE";
		phone2.powerOn();
		phone2.powerOff();

		SmartPhone phone3 = null;
		if (phone2 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone2;// casting
			phone3.channel = 2;
			phone3.watch();
			System.out.println(phone3.toString());
		}

		// instanceof 메소드를 변환 가능한지 체크
		if (phone1 instanceof SmartPhone) {
			phone3 = (SmartPhone)phone1;
			phone3.channel = 3;
			phone3.watch();

		}
	}
}
