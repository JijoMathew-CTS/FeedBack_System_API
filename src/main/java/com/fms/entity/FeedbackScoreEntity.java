package com.fms.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "volunteer_feedback")
public class FeedbackScoreEntity {

	@EmbeddedId
	private EventPK eventPK;

	private int score;

	private String answer1;

	private String answer2;

	private String status;

	public EventPK getEventPK() {
		return eventPK;
	}

	public void setEventPK(EventPK eventPK) {
		this.eventPK = eventPK;
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
