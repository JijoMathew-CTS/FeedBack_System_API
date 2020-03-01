package com.fms.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.entity.FeedbackQuestionEntity;
import com.fms.model.FeedbackQuestion;
import com.fms.repo.FeedbackQuestionRepository;
import com.fms.service.FeedBackQuestionService;

@Service
public class FeedBackQuestionServiceImpl implements FeedBackQuestionService {

	@Autowired
	FeedbackQuestionRepository feedbackQuestionRepository;

	@Override
	public List<FeedbackQuestion> getQuestions() {
		List<FeedbackQuestionEntity> feedbackQuestionEntityList = feedbackQuestionRepository.findAll();
		List<FeedbackQuestion> feedbackQuestionList = getFeedbackQuestionList(feedbackQuestionEntityList);
		return feedbackQuestionList;
	}

	@Override
	public void saveQuestion(FeedbackQuestion feedbackQuestion) {
		FeedbackQuestionEntity feedbackQuestionEntity = new FeedbackQuestionEntity();
		if (feedbackQuestion != null) {
			if (feedbackQuestion.getQuestionId() != null) {
				feedbackQuestionEntity.setQuestionId(feedbackQuestion.getQuestionId());
			}
			feedbackQuestionEntity.setQuestionType(feedbackQuestion.getQuestionType());
			feedbackQuestionEntity.setFeedbackType(feedbackQuestion.getFeedbackType());
			feedbackQuestionEntity.setQuestion(feedbackQuestion.getQuestion());
			feedbackQuestionEntity.setAnswer(feedbackQuestion.getAnswer());
			feedbackQuestionRepository.save(feedbackQuestionEntity);
		}
	}

	@Override
	public void deleteQuestion(Long id) {
		feedbackQuestionRepository.deleteById(id);
	}

	@Override
	public List<FeedbackQuestion> getQuestionsByFeedbackType(String feedbackType) {
		List<FeedbackQuestionEntity> feedbackQuestionEntityList = feedbackQuestionRepository
				.findAllByFeedbackType(feedbackType);
		List<FeedbackQuestion> feedbackQuestionList = getFeedbackQuestionList(feedbackQuestionEntityList);
		return feedbackQuestionList;
	}

	private List<FeedbackQuestion> getFeedbackQuestionList(List<FeedbackQuestionEntity> feedbackQuestionEntityList) {
		List<FeedbackQuestion> feedbackQuestionList = new ArrayList<FeedbackQuestion>();
		FeedbackQuestion feedbackQuestion = null;
		if (feedbackQuestionEntityList != null && !feedbackQuestionEntityList.isEmpty()) {
			Iterator<FeedbackQuestionEntity> it = feedbackQuestionEntityList.iterator();
			while (it.hasNext()) {
				FeedbackQuestionEntity feedbackQuestionEntity = it.next();
				if (feedbackQuestionEntity != null) {
					feedbackQuestion = new FeedbackQuestion();
					feedbackQuestion.setQuestionId(feedbackQuestionEntity.getQuestionId());
					feedbackQuestion.setQuestionType(feedbackQuestionEntity.getQuestionType());
					feedbackQuestion.setFeedbackType(feedbackQuestionEntity.getFeedbackType());
					feedbackQuestion.setQuestion(feedbackQuestionEntity.getQuestion());
					feedbackQuestion.setAnswer(feedbackQuestionEntity.getAnswer());
					if ("AMA".equalsIgnoreCase(feedbackQuestionEntity.getQuestionType())
							&& feedbackQuestionEntity.getAnswer() != null) {
						String[] ansObj = feedbackQuestionEntity.getAnswer().split(":");
						if (ansObj != null) {
							feedbackQuestion.setTotalAnswers(ansObj.length);
						} else {
							feedbackQuestion.setTotalAnswers(0);
						}
					} else {
						feedbackQuestion.setTotalAnswers(0);
					}
					feedbackQuestionList.add(feedbackQuestion);
				}
			}
		}
		return feedbackQuestionList;
	}

}
