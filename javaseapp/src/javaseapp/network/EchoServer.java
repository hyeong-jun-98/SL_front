package javaseapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 메아리 서버를 구축한다 (채팅 서버의 가장 기초적인 단계)
public class EchoServer {
	int port = 9999; // 1~1024 : 이미 os차원에서 점유되는 포트라서 사용을 피해야한다.
	ServerSocket server; // 네트워크를 통해 데이터를 주고 받기 전에 먼저 클라이언트어ㅏ 서버와의 연결이
							// 선행되어야 하는데 이 연결을 처리해주는 전담객체를 가리켜 서버소켓이라고 한다. (주의 우리가 흔히 알고 있는 대화용 소켓이 아니다.)

	public EchoServer() {
		try {
			server = new ServerSocket(port); // 서버생성
			
			// 소켓을 통해 데이터를 클라이언트와 주고 받을 수 있다. 이때 개발자는 네트워크에 대한 지식이 필요없다.
			// 오직 데이터 IO에만 집중한다. (결국 스트림 제어에 집중하라)
			// 가능한 이유는 소켓이 네트워크 하부 구조에 대한 추상화를 담당하기 때문

			String data = null;
			while (true) {
				Socket socket = server.accept(); // 클라이언트가 접속하길 기다린다.
				String ip = socket.getInetAddress().getHostAddress();		// 상대 IP를 뺏어오는 것
				System.out.println(ip + "접속자 발견");
				
				InputStream is = socket.getInputStream(); // 소켓으로 연결설정하고 inputstream (바이트)으로 받아온다.
				InputStreamReader reader = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(reader);
				
				
				data = br.readLine(); // 1바이트 읽기
				System.out.println(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EchoServer();
	}

}
