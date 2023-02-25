package com.cmv.caseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.cmv.caseproject.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>  {

	UserDetails findByUsername(String username);

}
