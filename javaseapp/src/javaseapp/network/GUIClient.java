package javaseapp.network;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*
 * telnet 으로는 영문으로만 지원하므로 대화를 나누기에 ㅜ한계가 잇다.
 * 따라서 대화용 프로그램을 자바기반으로 제작
 * */
public class GUIClient extends JFrame {
	Choice ch; //
	JTextField t_port;
	JButton bt_connect;
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt_send;

	int port = 9999;
	Socket socket;
	BufferedWriter bw;		// 말하기
	BufferedReader br;		// 듣기

	public GUIClient() {

		ch = new Choice();
		t_port = new JTextField(Integer.toString(port), 6);
		bt_connect = new JButton("접속");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(20);
		bt_send = new JButton("전송");

		for (int i = 13; i <= 136; i++) {
			ch.add("192.168.25." + i);
			if (i == 135) {
				ch.select("192.168.25." + i);
			}
		}

		// 스타일

		scroll.setPreferredSize(new Dimension(280, 270));
		area.setBackground(Color.yellow);

		// 조립
		setLayout(new FlowLayout());
		add(ch);
		add(t_port);
		add(bt_connect);
		add(scroll);
		add(t_input);
		add(bt_send);

		setVisible(true);
		setBounds(200, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 접속버튼에 리스너 연결

		bt_connect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				connect();

			}
		});

		bt_send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});

	}

	// 입력한 데이터를 서버로 보내자ㅓ
	public void send() {
		String msg = t_input.getText();
		
		try {
			bw.write(msg + "\n");			// 버퍼로 모은 문장의 끝을 알려주기 위해 반드시 줄바꿈 문자를 포함해서 보내야 서버가 무한정으로 대기하지 않는다.
													// 붙이지 않으면 readLine()에서 대기상태에 빠진다.		
			// 출력 스트림은 입력 스트림과는 다르게 버퍼를 처리할 경우 데이터를 전송 시 반드시 버퍼를 비워줘야 한다.
			// 화장실 물 내리듯이....
			bw.flush();			// 버퍼 비우기	
			t_input.setText("");
			//서버가 보ㅓ낸 메시지 받기
			
			String data = null;
			
			data = br.readLine();
			area.append(data + "\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connect() {
		// 원하는 서버의 IP와 포트번호를 이용해서 접속 즉 연결을 시도하자!
		try {
			socket = new Socket(ch.getSelectedItem(), port); // choice에서 가져옴
			if (socket != null) {
				System.out.println("접속성공");
			}
			 bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			 br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new GUIClient();
	}

}
