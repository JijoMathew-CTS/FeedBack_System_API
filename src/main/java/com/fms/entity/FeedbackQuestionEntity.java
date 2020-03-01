package com.fms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "feedback_question")
public class FeedbackQuestionEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8347037267796719218L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "question_id")	
	private Long questionId;
	
	@Column(name = "question_type")
	private String questionType;
	
	@Column(name = "feedback_type")
	private String feedbackType;
	
	
	private String question;
	private String answer;
	/**
	 * @return the questionId
	 */
	public Long getQuestionId() {
		return questionId;
	}
	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	/**
	 * @return the questionType
	 */
	public String getQuestionType() {
		return questionType;
	}
	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	/**
	 * @return the feedbackType
	 */
	public String getFeedbackType() {
		return feedbackType;
	}
	/**
	 * @param feedbackType the feedbackType to set
	 */
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}
	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
