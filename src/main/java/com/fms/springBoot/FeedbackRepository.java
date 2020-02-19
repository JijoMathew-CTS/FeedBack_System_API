package com.fms.springBoot;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fms.springBoot.entity.EventPK;
import com.fms.springBoot.entity.FeedbackScoreEntity;
import com.fms.springBoot.entity.IScore;

public interface FeedbackRepository extends CrudRepository<FeedbackScoreEntity, EventPK> {

	@Query(value="SELECT sum(score) as rating FROM fmsdb.volunteer_feedback where score < 3", nativeQuery=true)
	public IScore findAllNegativeCount();
	
	@Query(value="SELECT sum(score) as rating FROM fmsdb.volunteer_feedback where score >= 3", nativeQuery=true)
	public IScore findAllPositiveCount();
}
