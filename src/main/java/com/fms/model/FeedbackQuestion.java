package com.fms.model;

public class FeedbackQuestion {

	private Long questionId;
	private String questionType;
	private String feedbackType;
	private String question;
	private String answer;
	private Integer totalAnswers;

	public FeedbackQuestion() {

	}

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

	/**
	 * @return the totalAnswers
	 */
	public Integer getTotalAnswers() {
		return totalAnswers;
	}

	/**
	 * @param totalAnswers the totalAnswers to set
	 */
	public void setTotalAnswers(Integer totalAnswers) {
		this.totalAnswers = totalAnswers;
	}

}
