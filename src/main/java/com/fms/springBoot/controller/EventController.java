package com.fms.springBoot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.springBoot.Model.EventDetailResponse;
import com.fms.springBoot.entity.EventDetailEntity;
import com.fms.springBoot.service.EventSummaryService;
@RestController
@CrossOrigin(origins = "*")
public class EventController {
	@Autowired
	private EventSummaryService eventSummaryService;
	@GetMapping("/getEventDetails")
	public List<EventDetailResponse> getAllEvents(HttpServletRequest request){
	
		
		return eventSummaryService.getEventDetails();
		
	}
}
