package com.fms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.EventDetailResponse;
import com.fms.service.EventSummaryService;
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
