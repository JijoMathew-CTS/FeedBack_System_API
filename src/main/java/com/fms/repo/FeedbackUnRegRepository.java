package com.fms.repo;


import org.springframework.data.repository.CrudRepository;

import com.fms.entity.EventPK;
import com.fms.entity.FeedbackUnRegEntity;

public interface FeedbackUnRegRepository extends CrudRepository<FeedbackUnRegEntity, EventPK> {

}