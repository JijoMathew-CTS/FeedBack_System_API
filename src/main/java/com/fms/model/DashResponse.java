package com.fms.model;

public class DashResponse {

	private String noOfEvents;
	private String noOfVolunteers;
	private String positiveFeedback;
	private String negativeFeedback;

	public DashResponse(String noOfEvents, String noOfVolunteers, String positiveFeedback, String negativeFeedBack) {
		super();
		this.noOfEvents = noOfEvents;
		this.noOfVolunteers = noOfVolunteers;
		this.positiveFeedback = positiveFeedback;
		this.negativeFeedback = negativeFeedBack;
	}

	public DashResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNoOfEvents() {
		return noOfEvents;
	}

	public void setNoOfEvents(String noOfEvents) {
		this.noOfEvents = noOfEvents;
	}

	public String getNoOfVolunteers() {
		return noOfVolunteers;
	}

	public void setNoOfVolunteers(String noOfVolunteers) {
		this.noOfVolunteers = noOfVolunteers;
	}

	public String getPositiveFeedback() {
		return positiveFeedback;
	}

	public void setPositiveFeedback(String positiveFeedback) {
		this.positiveFeedback = positiveFeedback;
	}

	public String getNegativeFeedback() {
		return negativeFeedback;
	}

	public void setNegativeFeedback(String negativeFeedback) {
		this.negativeFeedback = negativeFeedback;
	}

}

