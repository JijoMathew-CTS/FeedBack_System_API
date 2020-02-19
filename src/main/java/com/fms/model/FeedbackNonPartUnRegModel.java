package com.fms.model;

public class FeedbackNonPartUnRegModel {

	protected String eventId;
	protected String employeeId;
	private String choice;
	private String status;

	public FeedbackNonPartUnRegModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackNonPartUnRegModel(String eventId, String employeeId, String choice, String status) {
		super();
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.choice = choice;
		this.status = status;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
