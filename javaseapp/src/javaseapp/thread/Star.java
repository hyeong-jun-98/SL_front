package javaseapp.thread;


// 별을 출력하는 쓰레드 정의
public class Star extends Thread{
	String mark;
	
	public Star(String mark) {
		this.mark = mark;
	}
	//
	public void run() {
		while(true) {
		System.out.println(mark);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	
	
	
}
