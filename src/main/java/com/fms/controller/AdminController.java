package com.fms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.IFeedbackStatus;
import com.fms.service.AdminService;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(value = "/addAdmin")
	public String createAdmin(@RequestBody String id) {
		boolean alreadyExist = adminService.checkIfAlreadyExisted(id);
		if (!alreadyExist) {
			adminService.addAdmin(id);
			return id;
		}
		return "0";
	}

	@PostMapping(value = "/addPMO")
	public String createPmo(@RequestBody String id) {
		boolean alreadyExist = adminService.checkIfAlreadyExisted(id);
		if (!alreadyExist) {
			adminService.addPmo(id);
			return id;
		}
		return "0";
	}

	@GetMapping("/reportStatus/{type}")
	public List<IFeedbackStatus> getReport(@PathVariable String type, HttpServletRequest request) {
		
		List<IFeedbackStatus> report = new ArrayList<>();
		report = adminService.getFeedbackStatusReport(type);
		return report;

	}
}
