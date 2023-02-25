package com.cmv.caseproject.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.cmv.caseproject.dtos.AnnouncementDto;
import com.cmv.caseproject.service.AnnouncementService;

@RestController
public class NotificationController {
	
	private final AnnouncementService announcementService;
	
	public NotificationController(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}
	
	@MessageMapping("/notify")
	@SendTo("/topic/newNotifications")
	public AnnouncementDto notify(String announcementId) {
		return announcementService.notify(announcementId);
	}
}
