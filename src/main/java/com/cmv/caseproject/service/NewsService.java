package com.cmv.caseproject.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cmv.caseproject.dtos.NewsDto;
import com.cmv.caseproject.entity.News;
import com.cmv.caseproject.exception.NewsNotFoundException;
import com.cmv.caseproject.repository.NewsRepository;
import com.cmv.caseproject.requests.NewsCreateRequest;
import com.cmv.caseproject.utils.NewsDtoConverter;

@Service
public class NewsService {

	private NewsRepository newsRepository;
	private NewsDtoConverter newsDtoConverter;

	public NewsService(NewsRepository newsRepository, NewsDtoConverter newsDtoConverter) {
		this.newsRepository = newsRepository;
		this.newsDtoConverter = newsDtoConverter;
	}

	public List<NewsDto> getAll() {
		return newsRepository.findAll().stream().map(i -> newsDtoConverter.convertToDto(i)).collect(Collectors.toList());
	}

	public NewsDto createNews(NewsCreateRequest request) {
		LocalDateTime date = LocalDateTime.parse(request.getExpirationDate(), DateTimeFormatter.ISO_DATE_TIME);
		News news = new News(request.getTopic(), request.getContent(), date, request.getLink());
		return newsDtoConverter.convertToDto(newsRepository.save(news));
	}

	public String deleteNews(String id) {
		newsRepository.deleteById(id);
		return "Successfully deleted";
	}

	public NewsDto getById(String id) {
		News news = newsRepository.findById(id).orElseThrow(NewsNotFoundException::new);
		return newsDtoConverter.convertToDto(news);
	}

}
