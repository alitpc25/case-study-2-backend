package com.cmv.caseproject.dtos;

import java.time.LocalDateTime;

public class AnnouncementDto extends ActivityDto {

	public AnnouncementDto(String id, String topic, String content, LocalDateTime expirationDate) {
		super(id, topic, content, expirationDate);
	}
	
	public AnnouncementDto(String id, String topic, String content, LocalDateTime expirationDate, String image) {
		super(id, topic, content, expirationDate);
		this.image = image;
	}

	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
