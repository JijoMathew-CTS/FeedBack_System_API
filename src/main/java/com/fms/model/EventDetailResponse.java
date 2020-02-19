package com.fms.model;

import java.util.Date;

public class EventDetailResponse {
	private String eventId;
	
	private String baseLocation;
	
	private String beneficiaryName;
	
	private String eventName;
	
	private String councilName;
    private String pocId;

	private String pocName;
	private String month;
	
	private String venueAddress;
	
	private String project;
	private String catagory;
	private String eventDescription;
	private Date eventDate;
	private Integer totalVolNo;
	private Integer totalVolHrs;
	private Integer totalTravelHrs;
	private Integer overallVolHrs;
	private Integer livesImpact;
	private String activityType;
	private String status;
	private Integer pocContact;
	
	
	public EventDetailResponse(String eventId, String baseLocation,
			String beneficiaryName, String eventName, String councilName,
			String venueAddress, String project, String catagory,
			String eventDescription, Date eventDate, Integer totalVolNo,
			Integer totalVolHrs, Integer totalTravelHrs, Integer overallVolHrs,
			Integer livesImpact, String activityType, String status,
			Integer pocContact) {
		super();
		this.eventId = eventId;
		this.baseLocation = baseLocation;
		this.beneficiaryName = beneficiaryName;
		this.eventName = eventName;
		this.councilName = councilName;
		this.pocId = pocId;
		this.pocName = pocName;
		this.month = month;
		this.venueAddress = venueAddress;
		this.project = project;
		this.catagory = catagory;
		this.eventDescription = eventDescription;
		this.eventDate = eventDate;
		this.totalVolNo = totalVolNo;
		this.totalVolHrs = totalVolHrs;
		this.totalTravelHrs = totalTravelHrs;
		this.overallVolHrs = overallVolHrs;
		this.livesImpact = livesImpact;
		this.activityType = activityType;
		this.status = status;
		this.pocContact = pocContact;
		
	}

	

	public String getPocId() {
		return pocId;
	}

	public void setPocId(String pocId) {
		this.pocId = pocId;
	}

	public String getPocName() {
		return pocName;
	}

	public void setPocName(String pocName) {
		this.pocName = pocName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getTotalVolNo() {
		return totalVolNo;
	}

	public void setTotalVolNo(Integer totalVolNo) {
		this.totalVolNo = totalVolNo;
	}

	public Integer getTotalVolHrs() {
		return totalVolHrs;
	}

	public void setTotalVolHrs(Integer totalVolHrs) {
		this.totalVolHrs = totalVolHrs;
	}

	public Integer getTotalTravelHrs() {
		return totalTravelHrs;
	}

	public void setTotalTravelHrs(Integer totalTravelHrs) {
		this.totalTravelHrs = totalTravelHrs;
	}

	public Integer getOverallVolHrs() {
		return overallVolHrs;
	}

	public void setOverallVolHrs(Integer overallVolHrs) {
		this.overallVolHrs = overallVolHrs;
	}

	public Integer getLivesImpact() {
		return livesImpact;
	}

	public void setLivesImpact(Integer livesImpact) {
		this.livesImpact = livesImpact;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPocContact() {
		return pocContact;
	}

	public void setPocContact(Integer pocContact) {
		this.pocContact = pocContact;
	}

	public EventDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getEventId() {
		return eventId;
	}

	@Override
	public String toString() {
		return "EventDetailResponse [eventId=" + eventId + ", baseLocation="
				+ baseLocation + ", beneficiaryName=" + beneficiaryName
				+ ", eventName=" + eventName + ", councilName=" + councilName
				+ ", eventMonth=" + "]";
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	

}
