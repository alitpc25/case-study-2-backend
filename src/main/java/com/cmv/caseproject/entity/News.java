package com.cmv.caseproject.entity;

import java.time.LocalDateTime;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class News extends Activity {
	private String link;

	public News(String topic, String content, LocalDateTime expirationDate, String link) {
		super(topic, content, expirationDate);
		this.link = link;
	}
	
	public News() {}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
