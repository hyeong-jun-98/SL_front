package com.aca.web0810_1.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.aca.web0810_1.domain.Board;
import com.aca.web0810_1.model.BoardDAO;
//
// 웹 기반이 아닌 독립 실행형 기반의 GUI 모드로 등록폼을 정의하자.
public class FormWin extends JFrame {
	JTextField t_title, t_writer;
	JTextArea area;
	JButton bt; // has a 관계 : 객체가 다른 객체를 멤버로 보유한 관계
	BoardDAO bm;
	
	public FormWin() {
		
		t_title = new JTextField(17);
		t_writer = new JTextField(17);
		area = new JTextArea(10,23);  
		bt = new JButton("등록");
		bm = new BoardDAO();
		area.setBackground(Color.ORANGE);
		
		//div 대신 레이아웃 스타일 적용
		this.setLayout(new FlowLayout());  // 일렬로 배치되는 레이아웃
		add(t_title);
		add(t_writer);
		add(area);
		add(bt);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 윈도우 창을 닫을 때 프로그램도 같이 종료.
		
		bt.addActionListener(new ActionListener() {  
			// 내부 익명 클래스는 언제쓰나? 일반적으로 .java를 개발자가 파일로 만들엇다는 것은 재사용 가능성을
			// 염두해두고 정의하는 것이다. 하지만 개발을 하다보면 굳이 .java까지 만들필요없는 1회성 코드들이 있을 수 있다.
			// 주로 이벤트 연결의 재사용 가능성이 없다. 이때 개발자는 이름없는 내부 클래스로 간단히 처리할 수 있다..
			@Override
			public void actionPerformed(ActionEvent e) {
				regist();
			}
		});
		
		
		
	}
	public void regist() {
		String title = t_title.getText();
		String writer = t_writer.getText();
		String content = area.getText();
		Board board = new Board();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		int result = bm.insert(board);
		
		if(result == 0 ) {
			JOptionPane.showMessageDialog(this, "등록실패");
		} else {
			JOptionPane.showMessageDialog(this, "등록성공");
		}
	}

	public static void main(String[] args) {

		new FormWin();

	}
}
