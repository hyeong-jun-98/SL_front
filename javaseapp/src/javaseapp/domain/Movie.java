package javaseapp.domain;

// 로직을 작성하기 위함이 아닌 오직 데이터를 담기위한 자바 객체
// DTO, VO  (개발 개념)
public class Movie {
	
	private String url;
	private String title;
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	


}
