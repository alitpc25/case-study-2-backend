package com.cmv.caseproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmv.caseproject.dtos.NewsDto;
import com.cmv.caseproject.requests.NewsCreateRequest;
import com.cmv.caseproject.requests.NewsUpdateRequest;
import com.cmv.caseproject.service.NewsService;


@RestController
@RequestMapping("/api/v1/news")
public class NewsController {
	private final NewsService newsService;
	
	public NewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NewsDto> getById(@PathVariable String id) {
		return new ResponseEntity<>(newsService.getById(id) ,HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<NewsDto>> getAll() {
		return new ResponseEntity<>(newsService.getAll() ,HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<NewsDto> createNews(@RequestBody NewsCreateRequest request) {
		return new ResponseEntity<>(newsService.createNews(request) ,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNews(@PathVariable String id) {
		return new ResponseEntity<>(newsService.deleteNews(id) ,HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<NewsDto> updateNews(@PathVariable String id, @RequestBody NewsUpdateRequest request) {
		return new ResponseEntity<>(newsService.updateNews(id, request) ,HttpStatus.OK);
	}
}
