package javaseapp.thread;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class ProgressApp extends JFrame {
	JProgressBar bar, bar2, bar3;
	JButton bt;
	MyThread myThread;

	public ProgressApp() {//
		bar = new JProgressBar();
		bar2 = new JProgressBar();
		bar3 = new JProgressBar();
		
		bt = new JButton("download");
		myThread = new MyThread(bar, bar2, bar3);
		
		// 스타일
		bar.setPreferredSize(new Dimension(380, 50));
		bar2.setPreferredSize(new Dimension(380, 50));
		bar3.setPreferredSize(new Dimension(380, 50));

		// 배치 관리자 적용
		setLayout(new FlowLayout());

		// 조립
		add(bar);
		add(bar2);
		add(bar3);
		add(bt);

		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 생성된 스레드를 JVM의 Runnable 영역으로 밀어넣자.
				myThread.start();
			}
		});
	}

	
	// 자바는 쓰레드 기반의 언어이다. 우리가 쓰레드를 정의하지 않더라도 기본적으로 이령 프로그램의 실행부라고 불리는 단위가
	// 바로 메인 쓰레드였더ㅏ. 특히 이 메인 쓰레드는 개발자가 정의할 수 있는 쓰레드가 아닌 시스ㅜ템에서 이미 지원하는 특별한 쓰레드이다.
	public static void main(String[] args) {

		new ProgressApp();
	}
}
