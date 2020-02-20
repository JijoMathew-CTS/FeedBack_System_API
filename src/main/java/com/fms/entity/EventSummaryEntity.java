package com.fms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_summary")
public class EventSummaryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "event_id")
	private String eventId;	
	
	@Column(name = "month")
	private String month;	
	
	@Column(name = "base_location")
	private String baseLocation;
	
	@Column(name = "beneficiary_name")
	private String beneficiaryName;	
	
	@Column(name = "venue_address")
	private String venueAddress;	
	
	@Column(name = "council_name")
	private String councilName;
	
	@Column(name = "project")
	private String project;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "event_name")
	private String eventName;
	
	@Column(name = "event_description")
	private String eventDescription;
	
	@Column(name = "event_date")
	private Date eventDate;
	
	@Column(name = "total_no_volunteers")
	private Integer totalNoOfVolunteers;
	
	@Column(name = "total_vol_hours")
	private Double totalVolHours;
	
	@Column(name = "total_travel_hours")
	private Double totalTravelHours;
	
	@Column(name = "over_all_vol_hours")
	private Double overAllVolHours;
	
	@Column(name = "lives_impacted")
	private Integer livesImpacted;
	
	@Column(name = "activity_type")
	private String activityType;
	
	@Column(name = "status")
	private String status;	
	
	@Column(name = "poc_id")
	private String pocId;
	
	@Column(name = "poc_name")
	private String pocName;
	
	@Column(name = "poc_contact_number")
	private String pocContactNumber;


	
	public EventSummaryEntity() {
		super();
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
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

	public String getVenueAddress() {
		return venueAddress;
	}

	public void setVenueAddress(String venueAddress) {
		this.venueAddress = venueAddress;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
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

	public Integer getTotalNoOfVolunteers() {
		return totalNoOfVolunteers;
	}

	public void setTotalNoOfVolunteers(Integer totalNoOfVolunteers) {
		this.totalNoOfVolunteers = totalNoOfVolunteers;
	}

	public Double getTotalVolHours() {
		return totalVolHours;
	}

	public void setTotalVolHours(Double totalVolHours) {
		this.totalVolHours = totalVolHours;
	}

	public Double getTotalTravelHours() {
		return totalTravelHours;
	}

	public void setTotalTravelHours(Double totalTravelHours) {
		this.totalTravelHours = totalTravelHours;
	}

	public Double getOverAllVolHours() {
		return overAllVolHours;
	}

	public void setOverAllVolHours(Double overAllVolHours) {
		this.overAllVolHours = overAllVolHours;
	}

	public Integer getLivesImpacted() {
		return livesImpacted;
	}

	public void setLivesImpacted(Integer livesImpacted) {
		this.livesImpacted = livesImpacted;
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

	public String getPocContactNumber() {
		return pocContactNumber;
	}

	public void setPocContactNumber(String pocContactNumber) {
		this.pocContactNumber = pocContactNumber;
	}
	
	

}
