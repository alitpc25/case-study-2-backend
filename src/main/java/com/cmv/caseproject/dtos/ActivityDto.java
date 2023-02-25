package com.cmv.caseproject.dtos;

import java.time.LocalDateTime;

public class ActivityDto {
	private String id;
	private String topic;
	private String content;
	private LocalDateTime expirationDate;
	public ActivityDto(String id, String topic, String content, LocalDateTime expirationDate) {
		this.id = id;
		this.topic = topic;
		this.content = content;
		this.expirationDate = expirationDate;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
