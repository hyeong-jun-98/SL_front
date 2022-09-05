package com.academy.SpringBasicApp.cook;

// 인덕션
public class ElectPan implements Pan{
	
	@Override
	public void boil() {
		
		System.out.println("전기로 음식을 데워요");     
		
	}
}
