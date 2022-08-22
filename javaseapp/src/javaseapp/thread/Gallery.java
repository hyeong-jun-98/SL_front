package javaseapp.thread;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// 파일 입출력
public class Gallery extends JFrame {
	JPanel p_controller;
	JPanel p_content;
	JButton bt_prev, bt_next, bt_auto;
	Image image; // 자바에서 이미지를 표현한 객체이고, 이미지 인스턴스를 얻는 방법은 상당히 다양하다.
	URL url;

	public Gallery() {

		p_controller = new JPanel();
		
			loadImage();
		p_content = new JPanel() {

			@Override
			public void paint(Graphics g) {
				System.out.println("내가 주도해서 그리고 있다.");

				g.drawImage(image, 0, 0, 600, 500, p_controller);
			}

		};
		bt_prev = new JButton("이전");
		bt_next = new JButton("다음");
		bt_auto = new JButton("auto");

		p_controller.setPreferredSize(new Dimension(600, 50));
		p_controller.setBackground(Color.orange);
		p_content.setPreferredSize(new Dimension(600, 500));
		p_content.setBackground(Color.black);

		setLayout(new FlowLayout());

		p_controller.add(bt_prev);
		p_controller.add(bt_next);
		p_controller.add(bt_auto);

		add(p_controller);
		add(p_content);

		setLocationRelativeTo(null); // 화면 가운데로 윈도우 창
		setSize(600, 550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		//다음 버튼에 대한 이벤트 구현
		bt_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				next();
				
				
			}
		});

	}
	
	//프로그램에서 사용할 데이터 가져오기
	public void init() {
		// 지금 json 데이터는 파일로 존재한다. 따라서 실행중인 자바 프로그램에서 문서파일을 읽어야 하므로
		// 지금 필요한 기술은 입력 스트림이 필요하다.
		// 1) 방향 : 모든 스트립은 데이터의 처리방향에 따라 입 출력..
		// 2) 다루는 데이터 : 바이트기반, 분자기반, 버퍼처리..
		// 
		
	}
	
	
	
	// 다음 사진 나오게
	public void next() {
		
	}
	

	public void loadImage() {
		// URL url = this.getClass().getResource("/javaseapp/res/data.json");

		File file = new File("C:/Users/SL/eclipse-workspace/javaseapp/data/data.json");
		FileReader reader = null;
		JSONParser jsonParser = null;
		try {
			reader = new FileReader(file);
			jsonParser = new JSONParser();

			// String문서로 존재했던 json파일을 읽어들여 JSON 객체화 시킨 것
			JSONObject jsonObject;

			jsonObject = (JSONObject) jsonParser.parse(reader);

			JSONArray jsonArray = (JSONArray) jsonObject.get("marvel");
			JSONObject movieJson = (JSONObject) jsonArray.get(0);

			System.out.println(movieJson.get("url"));

			URL url = new URL((String) movieJson.get("url"));
			image = ImageIO.read(url);
			
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

//		try {
//			url = new URL("https://images-na.ssl-images-amazon.com/images/I/91qvAndeVYL._RI_.jpg");
//			image = ImageIO.read(url);
//		} catch (MalformedURLException e) {
//			
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public static void main(String[] args) {
		new Gallery();
	}

}