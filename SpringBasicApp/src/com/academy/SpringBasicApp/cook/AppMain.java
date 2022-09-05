package com.academy.SpringBasicApp.cook;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
	
	public static void main(String[] args) {
	
//		Chef chef = new Chef();
//		chef.cook();

		// 요리사가 쓰고자 하는 갹체를 스프링이 관여하여 직접 객체를 주입시켜주자. -> Injection
		// 주입하는 이유 -> 요리사 클래스에서  new 하는것을 피하기 위해... new 하는 순간 정확한 자료형 명시와 함께
		// 결합도가 강해지므로.....
		
		// 앱에서 사용할 객체들을 스프링이 솬리해줄 수 있는데 이때 사용되는 스프링의 객체를 가리켜
		// 스프링 빈 컨테이너라고 하면 자료형은 ApplicationContext이다.
		
		// 앞으로 개발자가 프로그램에서 사용할 객체들은 자바 클래스에서 생성하지 말고 XML에 명시해놓으면
		// 스프링 컨테이너가 알아서 인스턴스를 생성하여 관리해준다.
		// 아래의 ApplicationContext를 객체를 메모리에 올릴 때 지정한 xml을 파싱하고 그 xml에 명시된 모든 bean들은
		// 객체의 인스턴스가 만들어져서 컨테이너에 관리된다.
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("app/config/context.xml");
		Chef chef = (Chef) context.getBean("chef");		// 새롭게 린스터스를 생성하지 않고 이미 컨테이너ㅏ 생성된 bean을 얻어오기
		chef.cook();
		
	}

}
