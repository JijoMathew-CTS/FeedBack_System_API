package com.fms.springBoot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.springBoot.EventRptRepository;
import com.fms.springBoot.Model.EventDetailResponse;
import com.fms.springBoot.entity.EventDetails;
import com.fms.springBoot.entity.IEventReport;

@Service
public class EventSummaryService {
	@Autowired
	private EventRptRepository eRepository;

	public List<IEventReport> getEventRatingByEvent(String pocId) {

		if (pocId == null || "".equals(pocId)) {
			return eRepository.findAllByEvents();
		}
		return eRepository.findAllByPocEvents(pocId);
	}
	public List<IEventReport> getEventDetails(String pocId) {

		if (pocId == null || "".equals(pocId)) {
			return eRepository.findAllByEvents();
		}
		return eRepository.findAllByPocEvents(pocId);
	}
	

	public List<IEventReport> getEventRatingByBaseLocation(String pocId) {

		if (pocId == null || "".equals(pocId)) {
			return eRepository.findAllByBaseLocation();
		}
		return eRepository.findAllByPocBaseLocation(pocId);
	}

	public List<IEventReport> getEventRatingByBeneficiary(String pocId) {

		if (pocId == null || "".equals(pocId)) {
			return eRepository.findAllByBenificiary();
		}
		return eRepository.findAllByPocBenificiary(pocId);
	}
	public List<EventDetailResponse> getEventDetails() {
       
		List<EventDetails> eventsData= eRepository.findEventDetails();
		List<EventDetailResponse> eventResponse=new ArrayList<EventDetailResponse>();
		for(EventDetails data:eventsData){
			EventDetailResponse response=new EventDetailResponse();
			response.setEventId(data.getEvent_Id());
			response.setBaseLocation(data.getBase_location());
			response.setBeneficiaryName(data.getBeneficiary_name());
			response.setCouncilName(data.getCouncil_name());
			response.setEventName(data.getEvent_name());
		    response.setActivityType(data.getActivity_type());
		    response.setMonth(data.getMonth());
		    response.setCatagory(data.getCatagory());
		    response.setPocId(data.getPoc_Id());
		    response.setProject(data.getProject());
		    response.setEventName(data.getEvent_name());
		    response.setEventDescription(data.getEvent_description());
		    response.setEventDate(data.getEvent_date());
		    response.setTotalVolNo(data.getTotal_vol_no());
		    response.setTotalVolHrs(data.getTotal_vol_hrs());
		    response.setOverallVolHrs(data.getOverall_vol_hrs());
		    response.setLivesImpact(data.getLives_impact());
		    response.setStatus(data.getStatus());
		    response.setPocContact(data.getPoc_contact());
		    response.setPocName(data.getPoc_Name());
		    response.setTotalTravelHrs(data.getTotal_travel_hrs());
		    response.setVenueAddress(data.getVenue_address());
			eventResponse.add(response);
			
		}
		return eventResponse;
	}
}
