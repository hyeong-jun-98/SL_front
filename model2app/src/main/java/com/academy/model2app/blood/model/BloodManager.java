package com.academy.model2app.blood.model;

// 플랫폼에 중립적인 로직 클래스를 정의한다
// MVC 패턴을 기준으로 판단하자면 Model이다.

public class BloodManager {

	public String getAdvice(String blood) {

		String msg = null;

		if (blood.equals("A")) {
			msg = "소심";
		} else if (blood.equals("B")) {
			msg = "고집이 쌔고, 자기 주장이 강하다";
		} else if (blood.equals("O")) {
			msg = "오지랖이 넓고, 친구가 많다";
		} else if (blood.equals("AB")) {
			msg = "수시로 변한다";
		}

		return msg;
	}

}
