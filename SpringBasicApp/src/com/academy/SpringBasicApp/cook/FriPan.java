package com.academy.SpringBasicApp.cook;

// 현실의 프라이팬을 정의한다
public class FriPan implements Pan{
	
	@Override
	public void boil() {
		System.out.println("불로 음식을 데워요.");
	}

}
