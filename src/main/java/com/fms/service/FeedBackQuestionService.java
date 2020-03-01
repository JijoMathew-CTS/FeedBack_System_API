package com.fms.service;

import java.util.List;

import com.fms.model.FeedbackQuestion;

public interface FeedBackQuestionService {
	
	List<FeedbackQuestion> getQuestions();
	
	void saveQuestion(FeedbackQuestion feedbackQuestion);
	
	void deleteQuestion (Long id);
	
	List<FeedbackQuestion> getQuestionsByFeedbackType(String feedbackType);
}
