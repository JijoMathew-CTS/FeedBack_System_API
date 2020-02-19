package com.fms.springBoot.service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.springBoot.EventRptRepository;
import com.fms.springBoot.FeedbackRepository;
import com.fms.springBoot.VolunteerAttendedRepo;
import com.fms.springBoot.VolunteerNotAttendedRepo;
import com.fms.springBoot.VolunteerUnregisteredRepo;
import com.fms.springBoot.Model.DashResponse;

@Service
public class DashboardService {

	@Autowired
	private EventRptRepository eRepository;

	@Autowired
	private VolunteerAttendedRepo attended;

	@Autowired
	private VolunteerNotAttendedRepo notAttended;

	@Autowired
	private VolunteerUnregisteredRepo unregistered;

	@Autowired
	private FeedbackRepository feedbackRepository;

	public DashResponse calculateDashboardMetrics() {

		DashResponse response = new DashResponse();

		int totalEvents = eRepository.findDistinctEvents().size();

		int totalVol = calculateTotalVol();

		int totalFeedback = ((List) feedbackRepository.findAll()).size();
		
		double negativeFeedback = 0;
		double positiveFeedback = 0;
		if (feedbackRepository.findAllNegativeCount() != null)
			negativeFeedback = (double) feedbackRepository.findAllNegativeCount().getRating() / totalFeedback;
		if (feedbackRepository.findAllPositiveCount() != null)
			positiveFeedback = (double) feedbackRepository.findAllPositiveCount().getRating() / totalFeedback;
		
		response.setNoOfEvents(String.valueOf(totalEvents));
		response.setNoOfVolunteers(String.valueOf(totalVol));
		//response.setPositiveFeedback(String.valueOf(Math.round(positiveFeedback)));
		//response.setNegativeFeedBack(String.valueOf(Math.round(negativeFeedback)));
		
		response.setPositiveFeedback(String.valueOf(positiveFeedback));
		response.setNegativeFeedback(String.valueOf(negativeFeedback));
		
		//System.out.println(String.valueOf(negativeFeedback));
		//System.out.println(String.valueOf(positiveFeedback));
		return response;
	}

	private int calculateTotalVol() {
		List<String> attendees = attended.findDistinctAttended();
		List<String> nonAttendees = notAttended.findDistinctNotAttended();
		List<String> unAttendees = unregistered.findDistinctUnRegistered();

		Set<String> volSet = new TreeSet<>();
		volSet.addAll(attendees);
		volSet.addAll(nonAttendees);
		volSet.addAll(unAttendees);

		int totalVol = volSet.size();
		return totalVol;
	}
}
