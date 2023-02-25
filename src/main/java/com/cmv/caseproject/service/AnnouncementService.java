package com.cmv.caseproject.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cmv.caseproject.dtos.AnnouncementDto;
import com.cmv.caseproject.entity.Announcement;
import com.cmv.caseproject.exception.AnnouncementNotFoundException;
import com.cmv.caseproject.repository.AnnouncementRepository;
import com.cmv.caseproject.requests.AnnouncementCreateRequest;
import com.cmv.caseproject.requests.AnnouncementUpdateRequest;
import com.cmv.caseproject.utils.AnnouncementDtoConverter;
import com.cmv.caseproject.utils.FileUploadUtil;

@Service
public class AnnouncementService {
	
	private AnnouncementRepository announcementRepository;
	private AnnouncementDtoConverter announcementDtoConverter;

	public AnnouncementService(AnnouncementRepository announcementRepository, AnnouncementDtoConverter announcementDtoConverter) {
		this.announcementRepository = announcementRepository;
		this.announcementDtoConverter = announcementDtoConverter;
	}


	public List<AnnouncementDto> getAll() {
		return announcementRepository.findAll().stream().map(i -> announcementDtoConverter.convertToDto(i)).collect(Collectors.toList());
	}


	public AnnouncementDto createAnnouncement(AnnouncementCreateRequest request) throws IOException {
		String imageFileName = StringUtils.cleanPath(request.getImage().getOriginalFilename());
		LocalDateTime date = LocalDateTime.parse(request.getExpirationDate(), DateTimeFormatter.ISO_DATE_TIME);
		Announcement announcement = new Announcement(request.getTopic(), request.getContent(), date, imageFileName);
		
		announcement = announcementRepository.save(announcement);
		
		String uploadDir = "target/classes/static/announcement-photos/" + announcement.getId();
		FileUploadUtil.saveFile(uploadDir, imageFileName, request.getImage());
        return announcementDtoConverter.convertToDto(announcement);
	}


	public String deleteAnnouncement(String id) throws IOException {
		Announcement announcement = announcementRepository.findById(id).orElseThrow(AnnouncementNotFoundException::new);
		String uploadDir = "target/classes/static/announcement-photos/" + announcement.getId();
		FileUploadUtil.deleteFile(uploadDir);
		announcementRepository.deleteById(id);
		return "Successfully deleted.";
	}


	public AnnouncementDto updateAnnouncement(String id, AnnouncementUpdateRequest request) throws IOException {
		Announcement announcement = announcementRepository.findById(id).orElseThrow(AnnouncementNotFoundException::new);
		announcement.setTopic(request.getTopic());
		announcement.setContent(request.getContent());
		LocalDateTime date = LocalDateTime.parse(request.getExpirationDate(), DateTimeFormatter.ISO_DATE_TIME);
		announcement.setExpirationDate(date);

		String uploadDir = "target/classes/static/announcement-photos/" + announcement.getId();
		String imageFileName = StringUtils.cleanPath(request.getImage().getOriginalFilename());
		announcement.setImage(imageFileName);
		FileUploadUtil.updateFile(uploadDir, imageFileName, request.getImage());
		return announcementDtoConverter.convertToDto(announcementRepository.save(announcement));
	}


	public AnnouncementDto getById(String id) {
		Announcement announcement = announcementRepository.findById(id).orElseThrow(AnnouncementNotFoundException::new);
		return announcementDtoConverter.convertToDto(announcement);
	}


	public AnnouncementDto notify(String announcementId) {
		return getById(announcementId);
	}

}
