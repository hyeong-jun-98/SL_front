package javaseapp.collection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ListTest extends JFrame {

	JButton bt_create, bt_color;
	JPanel p; // 비어있는 컴포넌트 div와 비슷
	List<JButton> btList = new ArrayList<JButton>();

	public ListTest() {
		bt_create = new JButton("버튼 생성");
		bt_color = new JButton("색상적용");
		p = new JPanel();

		setLayout(new FlowLayout()); // 화면 생성
		add(bt_create);
		add(bt_color); // 추가
		add(p);

		p.setBackground(Color.orange);
		p.setPreferredSize(new Dimension(380, 450));
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫을 때 프로그램도 종료된다..

		// 이벤트 연결 코드는 1회성이므로, 즉 .java로 만들 실익이 없다. 따라서 내부 익명 클래스로 가자.

		bt_create.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 종적으로 버튼 생성하기
				createBtn();

			}
		});

		bt_color.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setColor();
			}
		});

	}
//
	public void createBtn() {
		JButton bt = new JButton("버튼 1");
		p.add(bt); // 패널에 버튼 추가
		p.updateUI(); // 화면 갱신 요청
		btList.add(bt);
		System.out.println("현재 생성된 버튼의 수는 : " + btList.size());

	}

	public void setColor() {
		// 동적으로 생성된 모든 버튼의 배경색을 blue색으로 변경해보기
//		for (int i = 0; i < btList.size(); i++) {
//			JButton bt = btList.get(i);		// 제네릭 타입이므로 형변환이 필요없다.
//			bt.setBackground(Color.cyan);
//		}
		for (JButton bt : btList) {		// 향상된  for문
			bt.setBackground(Color.cyan);
		}

	}

	public static void main(String[] args) {
		new ListTest();
	}

}
