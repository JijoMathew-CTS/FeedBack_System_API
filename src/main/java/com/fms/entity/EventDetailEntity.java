package com.fms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_detail")
public class EventDetailEntity {
	@Id
	@Column(name="event_id")
	private String event_Id;
	
	public String getEvent_Id() {
		return event_Id;
	}
	public void setEvent_Id(String eventId) {
		this.event_Id = eventId;
	}
	
	
}
