package com.cmv.caseproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cmv.caseproject.entity.Admin;
import com.cmv.caseproject.repository.AdminRepository;

@SpringBootApplication
public class CaseProjectApplication implements ApplicationRunner {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(CaseProjectApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(adminRepository.findAll().isEmpty()) {
			adminRepository.save(new Admin("admin", passwordEncoder.encode("admin")));
		}
	}

}
