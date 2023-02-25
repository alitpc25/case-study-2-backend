package com.cmv.caseproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("0")
public class Announcement extends Activity {
	private String image;

	public Announcement(String topic, String content, LocalDateTime expirationDate, String image) {
		super(topic, content, expirationDate);
		this.image = image;
	}
	
	public Announcement() {}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
