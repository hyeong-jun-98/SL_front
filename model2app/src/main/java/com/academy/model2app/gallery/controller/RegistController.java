package com.academy.model2app.gallery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.model2app.controller.Controller;
import com.academy.model2app.domain.Gallery;
import com.academy.model2app.model.repository.GalleryDAO;
import com.academy.model2app.util.FileManager;

/*텍스트 파라미터 뿐만 아니라 바이너리 파일이 포람된 업로드 요청을 처리해본다
 * 지난 시간에 이용한 업로드 컵포넌트 cos.jar (Oerilly 사)
 * 	이번 시간은 apache.org에서 제공안 apache commons 프로젝트 하위 컴포넌트 fileupload 컴포넌트
 * */
public class RegistController implements Controller {
	FileManager fileManager = new FileManager();
	GalleryDAO galleryDAO = new GalleryDAO();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Gallery gallery = fileManager.getParam(request);		// id는 없음

		galleryDAO.insert(gallery);	// id도 들어가있음
		
		// mybatis에 의해 기존의 Gallery DTO의 pk 값이 채워지게 된다.
		int gallery_id = gallery.getGallery_id();
		
		fileManager.saveAs(fileManager.getDest()+"/"+gallery_id+"."+fileManager.getExtension());
		
	}

	@Override
	public String getViewName() {
		return "/gallery/result/write";
	}

	@Override
	public boolean isFoward() {
		return false;
	}

}
