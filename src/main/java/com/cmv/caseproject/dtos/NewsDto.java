package com.cmv.caseproject.dtos;

import java.time.LocalDateTime;

public class NewsDto extends ActivityDto {
	public NewsDto(String id, String topic, String content, LocalDateTime expirationDate) {
		super(id, topic, content, expirationDate);
	}
	
	public NewsDto(String id, String topic, String content, LocalDateTime expirationDate, String link) {
		super(id, topic, content, expirationDate);
		this.link = link;
	}

	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
