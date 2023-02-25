package com.cmv.caseproject.utils;

import org.springframework.stereotype.Service;

import com.cmv.caseproject.dtos.AnnouncementDto;
import com.cmv.caseproject.entity.Announcement;

@Service
public class AnnouncementDtoConverter {
	public AnnouncementDto convertToDto(Announcement announcement) {
		AnnouncementDto announcementDto = new AnnouncementDto(announcement.getId(), announcement.getTopic(), announcement.getContent(),
				  announcement.getExpirationDate(), "announcement-photos/" + announcement.getId() +"/" + announcement.getImage());
	    return announcementDto;
	}
}
