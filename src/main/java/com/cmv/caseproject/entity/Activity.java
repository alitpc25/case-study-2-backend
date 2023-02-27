package com.cmv.caseproject.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="activity_type", 
discriminatorType = DiscriminatorType.INTEGER)
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String topic;
	
	@Lob
	private String content;
	
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime expirationDate;
	
	public Activity(String topic, String content, LocalDateTime expirationDate) {
		this.topic = topic;
		this.content = content;
		this.expirationDate = expirationDate;
	}
	
	public Activity() {	}
	
	public String getId() {
		return id;
	}
	public String getTopic() {
		return topic;
	}
	public String getContent() {
		return content;
	}
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
}
