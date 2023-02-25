package com.cmv.caseproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmv.caseproject.requests.AdminLoginRequest;
import com.cmv.caseproject.responses.AdminLoginResponse;
import com.cmv.caseproject.service.AdminService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping("/login")
    public ResponseEntity<AdminLoginResponse> authenticateAdmin(@RequestBody AdminLoginRequest adminLoginRequest) {
		AdminLoginResponse adminLoginResponse = adminService.authenticateAdmin(adminLoginRequest);
    	return new ResponseEntity<>(adminLoginResponse, HttpStatus.OK);
    }
}
