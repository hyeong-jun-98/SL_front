package com.academy.model2app.util;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.academy.model2app.domain.Gallery;

import lombok.Data;

// 파일과 관련된 업무 처리를 담당하는 유틸리티 클래스
// 파일 명 추출하기.... 확장자 추출하기,,,,,
@Data
public class FileManager {
	DiskFileItemFactory factory = new DiskFileItemFactory(); // 업로드 전 설정정보를 관리하는 객체
	int maxSize = 5 * 1024 * 1024;
	FileItem fileItem; // 파일 정보가 들어있는 아이쳄
	private String dest;
	private String extension;

	// 파일을 지정한 경로에 저장하는 메서드
	public Gallery getParam(HttpServletRequest request) {
		// jsp의 application 내장객체이자 ServletContext 자료형인 객체를 request 객체로부터 얻어올 수 있나/ 그렇다
		String savePath = request.getServletContext().getRealPath("/data");
		dest = savePath;
		
		factory.setSizeThreshold(maxSize);
		factory.setRepository(new File(savePath)); // 저장경로 잡아주는 것. data 폴더로 들어감

		// 업로드 담당하는 객체
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		Gallery gallery = new Gallery();
		String ext;

		try {
			// 우리의 경우 input="text" 3개, input type="file" 1개, 총 4개를 리스트에 담는다
			List<FileItem> uploadList = servletFileUpload.parseRequest(request); // 요청 분석 후 텍스트와 파일을 Item에 담는다
			System.out.println("업로드 분석 후 발견된 수 : " + uploadList.size());

			for (int i = 0; i < uploadList.size(); i++) {

				FileItem item = uploadList.get(i); // 파일인지 텍스트인지 우린 몰라 리스트안에 다 들어가 있어서 그래서 조건을 줘서 구분하는거야

				if (item.isFormField()) { // 텍스트 데이터
					System.out.println(item.getFieldName() + "의 값은 " + item.getString()); // 텍스트 name을 가져오는 것.

					switch (item.getFieldName()) {
					case "title":
						gallery.setTitle(item.getString());
						break;
					case "writer":
						gallery.setWriter(item.getString());
						break;
					case "content":
						gallery.setContent(item.getString());
						break;
					}

				} else { // 바이너리 파일 인 경우
					System.out.println("파일 명은 " + item.getName()); // 파일 명 가져오기
					ext = FileManager.getExt(item.getName());
					extension = ext;
					fileItem = item; // 멤버변수에 보관해랴 다른 메서드에서 접근할 수 있다.
				}

			}
			// insert

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		return gallery;
	}

	public void saveAs(String path) {
		System.out.println(path);
		try {
			fileItem.write(new File(path));	// 파일 저장
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 확장자 추출
	public static String getExt(String path) {
		int index = path.lastIndexOf("."); // 문자열 내의 가장 마지막 .의 인덱스 반환
		return path.substring(index + 1, path.length());

	}

//	public static void main(String[] args) {
//		String result = getExt("d:sdsdsdsd/sdsd/s/ds/dsd/sdsdsd.jpg");
//		System.out.println(result);
//	}
}
