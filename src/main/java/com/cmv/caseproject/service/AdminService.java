package com.cmv.caseproject.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cmv.caseproject.configs.JwtService;
import com.cmv.caseproject.exception.BadCredentialsException;
import com.cmv.caseproject.repository.AdminRepository;
import com.cmv.caseproject.requests.AdminLoginRequest;
import com.cmv.caseproject.responses.AdminLoginResponse;

@Service
public class AdminService {
	
	private AdminRepository adminRepository;
	private PasswordEncoder passwordEncoder;
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	
	public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	public UserDetails getByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	public AdminLoginResponse authenticateAdmin(AdminLoginRequest adminLoginRequest) {
		UserDetails admin = getByUsername(adminLoginRequest.getUsername());
		if(!passwordEncoder.matches(adminLoginRequest.getPassword(), admin.getPassword())) {
			throw new BadCredentialsException("Wrong password");
		}
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(adminLoginRequest.getUsername(), adminLoginRequest.getPassword());
		Authentication auth = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(auth);
		String jwtToken = jwtService.generateToken(admin);
		return new AdminLoginResponse(jwtToken);
	}

	public String logoutAdmin() {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "Logged out.";
	}

}
