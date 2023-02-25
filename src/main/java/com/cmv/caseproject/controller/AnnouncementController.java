package com.cmv.caseproject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmv.caseproject.dtos.AnnouncementDto;
import com.cmv.caseproject.requests.AnnouncementCreateRequest;
import com.cmv.caseproject.requests.AnnouncementUpdateRequest;
import com.cmv.caseproject.service.AnnouncementService;

@RestController
@RequestMapping("/api/v1/announcement")
public class AnnouncementController {
	
	private final AnnouncementService announcementService;
	
	public AnnouncementController(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@GetMapping
	public ResponseEntity<List<AnnouncementDto>> getAll() {
		return new ResponseEntity<>(announcementService.getAll() ,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnnouncementDto> getById(@PathVariable String id) {
		return new ResponseEntity<>(announcementService.getById(id) ,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<AnnouncementDto> createAnnouncement(@ModelAttribute AnnouncementCreateRequest request) throws IOException {
		return new ResponseEntity<>(announcementService.createAnnouncement(request) ,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnnouncement(@PathVariable String id) throws IOException {
		return new ResponseEntity<>(announcementService.deleteAnnouncement(id) ,HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	@ModelAttribute
	public ResponseEntity<AnnouncementDto> updateAnnouncement(@PathVariable String id, AnnouncementUpdateRequest request) throws IOException {
		return new ResponseEntity<>(announcementService.updateAnnouncement(id, request) ,HttpStatus.OK);
	}
}
