package com.fms.springBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.springBoot.entity.User;
import com.fms.springBoot.UserRepository;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class MainController {
	
	@Autowired
	UserRepository userRepository;
	// Get All Notes
	@GetMapping("/maincontroller/allUser")
	public List<User> getAllNotes() {
	    return (List<User>) userRepository.findAll();
	}
	
/*	// Get a Single Note
	@GetMapping("/maincontroller/userById/{id}")
	public  List<User> getNoteById(@PathVariable(value = "id") String event_id) {
		return (userRepository.findByEvent(event_id));
	}
	*/	
}
