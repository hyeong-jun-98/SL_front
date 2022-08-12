package javaseapp.thread;

import javax.swing.JProgressBar;

// ProgressBar를 증가시킬 스레드 정의

public class MyThread extends Thread {
	JProgressBar bar, bar2, bar3;
	int n = 0;
	int n2 = 0;
	int n3 = 0;

	public MyThread(JProgressBar bar, JProgressBar bar2, JProgressBar bar3) {
		this.bar = bar;
		this.bar2 = bar2;
		this.bar3 = bar3;
	}

	// 개발자는 스레드 정의 시 원하는 로직을 run 메서드에 작성한다.
	public void run() {
		while (true) {
			n+=2;
			n2++;
			n3+=3;
			bar.setValue(n);
			bar2.setValue(n2);
			bar3.setValue(n3);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
