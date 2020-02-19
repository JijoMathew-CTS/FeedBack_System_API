package com.fms.model;

public class MailList {
	protected String eventId;
	protected String employeeId;
	private	  String volType;
	
	public MailList(String eventId, String employeeId, String volType) {
		super();
		this.eventId 	= eventId;
		this.employeeId = employeeId;
		this.volType 	= volType;
	}
	public MailList() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getVolType() {
		return volType;
	}
	public void setVolType(String volType) {
		this.volType = volType;
	}
}
