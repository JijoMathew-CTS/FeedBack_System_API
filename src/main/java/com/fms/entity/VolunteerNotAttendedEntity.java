package com.fms.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vol_event_not_attended")
public class VolunteerNotAttendedEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Event ID	Event Name	Beneficiary Name	Base Location	Event Date (DD-MM-YY)	EmployeeID
	
	@EmbeddedId
	private EventPK eventPK;
	
	private String beneficiaryName;

	private String eventName;
	
	private Date eventDate;
	
	private String baseLocation;

	public EventPK getEventPK() {
		return eventPK;
	}

	public void setEventPK(EventPK eventPK) {
		this.eventPK = eventPK;
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

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	
	


}
