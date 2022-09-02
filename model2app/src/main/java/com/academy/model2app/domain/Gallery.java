package com.academy.model2app.domain;

import lombok.Data;

@Data
public class Gallery {
	
	private int gallery_id;
	private int hot;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private String filename;

}
