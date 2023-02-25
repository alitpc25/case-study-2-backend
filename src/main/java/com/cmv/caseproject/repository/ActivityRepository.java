package com.cmv.caseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmv.caseproject.entity.Activity;

public interface ActivityRepository<T extends Activity> extends JpaRepository<T, String>  {

}
