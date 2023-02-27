package com.cmv.caseproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmv.caseproject.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>  {

	Optional<Admin> findByUsername(String username);

}
