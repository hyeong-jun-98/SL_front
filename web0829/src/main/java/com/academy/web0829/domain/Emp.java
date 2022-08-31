package com.academy.web0829.domain;

import lombok.Data;

@Data
public class Emp {
	
	private String ename;
	private String job;
	private String hiredate;
	private int empno;
	private int mgr;
	private int sal;
	private int comm;
	private Dept dept; 		// EMP가 dept를 가지고 잇음 (deptno를 int로 만드는 대신)

}
