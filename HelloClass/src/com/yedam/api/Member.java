package com.yedam.api;

public class Member extends Object {
	String memberName;
	int age;
	
	public Member() {}
	public Member(String memberName,int age) {
		this.memberName=memberName;
		this.age=age;
	}

	// 이름,점수 => 같으면 논리적으로 동등한지.
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member member = (Member) obj;
			return this.memberName == member.memberName && this.age == member.age;
		}
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
		
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
}
