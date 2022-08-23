package javase.io;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MemoApp extends JFrame { // 문자기반 스트림을 이용하여 메모장 편집기를 제작해본다.

	JMenu m_file, m_edit, m_style, m_view, m_help;
	JMenuItem item_open, item_save, item_exit;
	JMenuBar bar;
	JTextArea content;
	JScrollPane scroll;
	JFileChooser chooser; // 탐색기
	FileReader reader; // 문자기반 스트림 (한글이 깨지면 안되기 때문에 문자기반을 사용한다.)

	public MemoApp() {
		super("메모장");

		m_file = new JMenu("파일");
		m_edit = new JMenu("편집");
		m_style = new JMenu("서식");
		m_view = new JMenu("보기");
		m_help = new JMenu("도움말");
		item_open = new JMenuItem("파일 열기");
		item_save = new JMenuItem("저장하기");
		m_file.addSeparator(); // 분리자 선 긋는 것.
		item_exit = new JMenuItem("종료하기");

		bar = new JMenuBar();
		content = new JTextArea();
		scroll = new JScrollPane(content);

		chooser = new JFileChooser("C:/Users/SL/eclipse-workspace/javaseapp/data"); // 기본경로로 설정

		m_file.add(item_open);
		m_file.add(item_save);
		m_file.add(item_exit);

		bar.add(m_file);
		bar.add(m_edit);
		bar.add(m_style);
		bar.add(m_view);
		bar.add(m_help);

		// bar는 유리가 원하는 곳에 붙일 수 잇지 아노고 윈도우 창 상단에 고정
		this.setJMenuBar(bar);
		add(scroll);

		setSize(800, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 파일 이벤트 열기 구현
		item_open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
			}

		});

	}

	public void openFile() {
		int result = chooser.showOpenDialog(this); // 윈도우 탐색기 (열기하면 0, 취소하면 1 반환)

		if (result == JFileChooser.APPROVE_OPTION) { // 파일을 선택했을 때
			File file = chooser.getSelectedFile();
			try {
				reader = new FileReader(file);

				// 한 문자 읽기
				int data = -1;

				while (true) {
					data = reader.read();
					if(data == -1) {
						break;
					}
					content.append(Character.toString((char) data));		// char 형으로 바꿔준 후 다시 그걸 문자열로 변환.
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {

		new MemoApp();
	}

}
