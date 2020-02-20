package com.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vol_event_attended")
public class VolunteerAttendedEntity extends EventInformationEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "vol_hours")
	private Double volHours;
	
	@Column(name = "travel_hours")
	private Double travelHours;
	
	@Column(name = "lives_impacted")
	private Integer livesImpacted;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "iiep_category")
	private String iiepCategory;

	public Double getVolHours() {
		return volHours;
	}

	public void setVolHours(Double volHours) {
		this.volHours = volHours;
	}

	public Double getTravelHours() {
		return travelHours;
	}

	public void setTravelHours(Double travelHours) {
		this.travelHours = travelHours;
	}

	public Integer getLivesImpacted() {
		return livesImpacted;
	}

	public void setLivesImpacted(Integer livesImpacted) {
		this.livesImpacted = livesImpacted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIiepCategory() {
		return iiepCategory;
	}

	public void setIiepCategory(String iiepCategory) {
		this.iiepCategory = iiepCategory;
	}	
	
	
}