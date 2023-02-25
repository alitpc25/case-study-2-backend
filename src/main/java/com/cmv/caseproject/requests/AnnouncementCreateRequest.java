package com.cmv.caseproject.requests;

import org.springframework.web.multipart.MultipartFile;

public class AnnouncementCreateRequest {
	private String topic;
	private String content;
	private String expirationDate;
	private MultipartFile image;
	public AnnouncementCreateRequest(String topic, String content, String expirationDate, MultipartFile image) {
		this.topic = topic;
		this.content = content;
		this.expirationDate = expirationDate;
		this.image = image;
	}
	public String getTopic() {
		return topic;
	}
	public String getContent() {
		return content;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public MultipartFile getImage() {
		return image;
	}
}
