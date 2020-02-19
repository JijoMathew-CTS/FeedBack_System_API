package com.fms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.IEventReport;
import com.fms.model.DashResponse;
import com.fms.service.DashboardService;
import com.fms.service.EventSummaryService;

@CrossOrigin(origins = "*")
@RestController
public class ReportController {

	@Autowired
	private EventSummaryService eventSummaryService;
	@Autowired
	private DashboardService dashboardService;
	
	@RequestMapping("/report/{type}")
	public List<IEventReport> getReport(@PathVariable String type, HttpServletRequest request) {
				
		List<IEventReport> eventReport = new ArrayList<>();
		String ascid = request.getHeader("ascid");
		switch (type) {
		case "event":
			eventReport = eventSummaryService.getEventRatingByEvent(ascid);
			break;
		case "benificiary":
			eventReport = eventSummaryService.getEventRatingByBeneficiary(ascid);
			break;
		case "city":
			eventReport = eventSummaryService.getEventRatingByBaseLocation(ascid);
			break;
		}
		return eventReport;
	}
	@RequestMapping("/report/dashboard")
	public DashResponse getAllMetrics(HttpServletRequest request) {
		DashResponse dResponse = dashboardService.calculateDashboardMetrics();
		return dResponse;
	}

}
