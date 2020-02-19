package com.fms.springBoot;


import org.springframework.data.repository.CrudRepository;

import com.fms.springBoot.entity.EventPK;
import com.fms.springBoot.entity.FeedbackUnRegEntity;

public interface FeedbackUnRegRepository extends CrudRepository<FeedbackUnRegEntity, EventPK> {

}