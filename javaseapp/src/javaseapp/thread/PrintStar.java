package javaseapp.thread;

public class PrintStar {
	
	//
	public static void main(String[] args) {
		// 스레드 하나를 만들어서 일을 시켜보자
		
		Star s1 = new Star("★");
		Star s2 = new Star("☆");
		s1.start();
		s2.start();
		
	}

}
