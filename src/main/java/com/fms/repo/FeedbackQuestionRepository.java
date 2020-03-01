package com.fms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fms.entity.FeedbackQuestionEntity;

public interface FeedbackQuestionRepository extends JpaRepository<FeedbackQuestionEntity, Long> {

	@Query(value = "SELECT * FROM feedback_question where feedback_type= ?1", nativeQuery = true)
	List<FeedbackQuestionEntity> findAllByFeedbackType(String feedbackType);

}
