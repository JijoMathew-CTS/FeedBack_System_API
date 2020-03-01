package com.fms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.fms.model.EventDetailResponse;
import com.fms.service.EventSummaryService;
@RestController
@CrossOrigin(origins = "*")
public class EventController {
	@Autowired
	private EventSummaryService eventSummaryService;
	@GetMapping("/getEventDetails/{role}")
	public List<EventDetailResponse> getAllEvents(@PathVariable String role,@RequestHeader String id,HttpServletRequest request){
	
		return eventSummaryService.getEventDetails(role,id);
		
	}
	
	@GetMapping("/getEventBeneficiary/{eid}")
	public List<EventDetailResponse> getEventBeneficairyDetails(@PathVariable String eid ,HttpServletRequest request){
	
			
		return eventSummaryService.getEventBeneficairyDetails(eid);
		
	}

}
