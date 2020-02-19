package com.fms.model;

public class FeedbackModel {

	protected String eventId;
	protected String employeeId;
	private int score;
	private String answer1;
	private String answer2;
	private String status;

	public FeedbackModel(String eventId, String employeeId, int score, String answer1, String answer2, String status) {
		super();
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.score = score;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.status = status;
	}

	public FeedbackModel() {
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

