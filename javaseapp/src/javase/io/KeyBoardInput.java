package javase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyBoardInput {

	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader reader = new InputStreamReader(is);			// 이미 존재하는 스트림을 얻음
		BufferedReader br = new BufferedReader(reader);
		
		String data = null;
		try {
			data = br.readLine();
			
			
			// 모니터에 출력하자
			System.out.print(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
