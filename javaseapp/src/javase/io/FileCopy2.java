package javase.io;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class FileCopy2 extends JFrame { // 파일 복사하기.
	JButton bt;
	JTextField t_ori, t_dest;
	JProgressBar bar;
	FileReader fis; // 바이트 기반
	FileWriter fos;

	public FileCopy2() {
		bt = new JButton("복사실행");
		t_ori = new JTextField(30);
		t_dest = new JTextField(30);
		bar = new JProgressBar();

		// 스타일
		bar.setPreferredSize(new DimensionUIResource(380, 55));
		bar.setBackground(Color.cyan);

		// 조립
		setLayout(new FlowLayout());
		add(bt);
		add(t_ori);
		add(t_dest);
		add(bar);

		// 윈도우 창 보이기
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 이벤트 구현하기
		bt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				copy();

			}
		});
	}

	private void copy() {
		// JOptionPane.showMessageDialog(this, "눌렀니?");
		try {

			String oriPath = t_ori.getText(); // 오리지널 파일 경로
			String destPath = t_dest.getText(); // 목적지 파일 경로

			fis = new FileReader(oriPath); // 파일을 대상으로 빨대를 꽂는다
			fos = new FileWriter(destPath); // 파일을 대상으로 한 출력 스트림인 FileOutputStream은 생성 시 빈 파일을 생성해준다. 사용자가 원하는
													// 이름으로

			int data = -1;
			
			while (true) {

				data = fis.read(); // 입력 스트림으로부터 1바이트 읽기
				if(data == -1) break;
				System.out.println(data);
				fos.write(data); // 파일 출력 스트림으로 1바이트 쓰기

				
			}
			JOptionPane.showMessageDialog(this, "복사완료?");
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

	public static void main(String[] args) {

		new FileCopy2();

	}

}
