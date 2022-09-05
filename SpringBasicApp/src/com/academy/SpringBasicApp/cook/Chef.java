package com.academy.SpringBasicApp.cook;



public class Chef {
	// 자바에서 특정 객체가 다른 객체를 부품으로 가질 때 has a 관계가 하고 이때 부품이 되는 객체는 멤버변수로 선언한다.
	// 아래와 가이 has 관계로 특정 객체를 보유할 때 너무 정확한 자료형을 보유하면 유지보수성이 떨어진다. 보다 상위 바료형을 선언하여 우연한 방법을 이용한다.
	// 상위 자료형일수록 많은 자료형들을 가리킬 수 있기 때문.
	Pan pan;		// has-a 관계  Chef has a pan
	
	
	// 이 setter는 스프링 컨테이너가 인스턴스를 전달할 때 해당 인스턴스를 받기위한 setter이다
	//  
	


	public void cook() {
//		pan = new ElectPan();		// 결합도가 굉장히 높다. -> 유연해야 한다  new 연산자를 사용하지 않는다.
		pan.boil();
		
	}



	public void setPan(Pan pan) {
		this.pan = pan;
	}
}
