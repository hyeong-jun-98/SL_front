package com.academy.SpringBasicApp.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

import lombok.Setter;

// 지금까지 작성했던 GUI 프로그래밍을 Spring DI를 적용하여 개발해본다.
@Setter
public class MyWin extends JFrame {
	
	// 상위 자료형으로 선언한 이유? 결합도를 약화시키기 위해
	private JComponent area;		// 스프링으로부터 주입 받으려고
	private JComponent t_input;
	private JComponent bt;
	
	
	
	public void init() {
		// 객체의 생성은 고민할 필요없다. 왜? Spring Container가 알아서 주입시켜주니까.
		area.setPreferredSize(new Dimension(295, 340));
		
		
		// 조립
		setLayout(new FlowLayout());
		add(t_input);
		add(area);
		add(bt);
		
		
		// 보이기
		setVisible(true);
		setSize(300,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
}
