package javase.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImageReader {
	FileInputStream fis; // 바이트 기반 스트림( 파일을 대상으로 데이터를 읽어온다)
	FileReader reader;	// 파일을 대상으로 데이터를 읽어오되, 2바이트를 하나의 문자로 읽을 수 있는 스트림
	BufferedReader br;
	public ImageReader() {
		try {
			// 대상자원에 빨대 꽂기
			fis = new FileInputStream("C:/Users/SL/eclipse-workspace/javaseapp/data/memo.txt"); // 바이트기반 한글이 깨짐
			reader = new FileReader("C:/Users/SL/eclipse-workspace/javaseapp/data/memo.txt");	// 문자기반 한글이 깨지지 않음
			System.out.println("스트임 생성 성공");
			
			int data = -1;
			
			while(true) {
				data = reader.read();
				if(data == -1) break;
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		new ImageReader();
	}
}
