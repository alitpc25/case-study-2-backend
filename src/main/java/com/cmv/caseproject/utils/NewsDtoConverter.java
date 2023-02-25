package com.cmv.caseproject.utils;

import org.springframework.stereotype.Service;

import com.cmv.caseproject.dtos.NewsDto;
import com.cmv.caseproject.entity.News;

@Service
public class NewsDtoConverter {
	public NewsDto convertToDto(News news) {
		NewsDto postDto = new NewsDto(news.getId(), news.getTopic(), news.getContent(), news.getExpirationDate(), news.getLink());
	    return postDto;
	}
}