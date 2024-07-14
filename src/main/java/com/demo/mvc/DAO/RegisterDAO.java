package com.demo.mvc.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.mvc.model.UserDTO;

public interface RegisterDAO extends JpaRepository<UserDTO, Integer> {
	
}
