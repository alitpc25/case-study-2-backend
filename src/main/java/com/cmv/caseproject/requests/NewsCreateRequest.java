package com.cmv.caseproject.requests;

public class NewsCreateRequest {
	private String topic;
	private String content;
	private String expirationDate;
	private String link;
	public NewsCreateRequest(String topic, String content, String expirationDate, String link) {
		this.topic = topic;
		this.content = content;
		this.expirationDate = expirationDate;
		this.link = link;
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
	public String getLink() {
		return link;
	}
	
}
