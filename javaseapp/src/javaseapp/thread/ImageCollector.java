package javaseapp.thread;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageCollector {
	FileInputStream fis;
	FileOutputStream fos;
	
	
	
	public ImageCollector() {
		InputStream is = null;
		URL url;
		try {
			url = new URL("https://images-na.ssl-images-amazon.com/images/I/516j96%2BpCOL._SY445_.jpg");
			is = url.openStream();
			fos = new FileOutputStream("C:/Users/SL/eclipse-workspace/javaseapp/data/test.jpg");
			is.read();
			
			int data = -1;
			while(true) {
			data = is.read();
			if(data == -1)  break;
			fos.write(data);
			System.out.println(data);
			
			}
			
			System.out.println("수집완료");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		
		new ImageCollector();
		
		
		
	}

}
