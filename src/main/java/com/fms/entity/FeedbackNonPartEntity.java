package com.fms.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "volunteer_feedback_nonpart")
public class FeedbackNonPartEntity {

	@EmbeddedId
	private EventPK eventPK;

	@Column(name="choice")
	private String choice;

	@Column(name="status")
	private String status;

	public EventPK getEventPK() {
		return eventPK;
	}

	public void setEventPK(EventPK eventPK) {
		this.eventPK = eventPK;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
