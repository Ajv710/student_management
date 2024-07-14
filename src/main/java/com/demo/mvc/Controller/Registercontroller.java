package com.demo.mvc.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.mvc.DAO.RegisterDAO;
import com.demo.mvc.model.UserDTO;

@RestController
public class Registercontroller {
	
	@Autowired
	private RegisterDAO dao;
	
	@RequestMapping("/")
	public ModelAndView register() {
		return new ModelAndView("welcome.jsp");
	}
	
	@RequestMapping("/adduser")
	public String registerUser(UserDTO dto) {
		
		dao.save(dto);
		return "login.jsp";
	}
	
	@RequestMapping("/getusername/")
	public ModelAndView getUsername(@RequestParam int id) {
		UserDTO fromdb=dao.findById(id).orElse(null);
		System.out.println(fromdb);
		return new ModelAndView("display.jsp","fromdb",fromdb);
	}

	@GetMapping(path="/allusers")
	@ResponseBody
	public List<UserDTO> users() {
		return dao.findAll();
	}
	

	@GetMapping("/allusers/{id}")
	@ResponseBody
	public Optional<UserDTO> getusers(@PathVariable("id") int id) {
		return dao.findById(id);
	}
	
	
	@PostMapping("/adduser")
	@ResponseBody
	public UserDTO adduser(UserDTO dto) {
		dao.save(dto);
		return dto;
	}
	
	@PutMapping(path="/updateuser")
	public UserDTO updateuser(@RequestBody UserDTO dto) {
		dao.save(dto);
		return dto;
		
	}
	
	@DeleteMapping("/deleteusers/{id}")
	@ResponseBody
	public String deleteusers(@PathVariable("id") int id) {
		 dao.deleteById(id);
		 return "user with ID = "+id+" is deleted";
	}
	

}
