package com.fms.springBoot;


import org.springframework.data.repository.CrudRepository;

import com.fms.springBoot.entity.EventPK;
import com.fms.springBoot.entity.FeedbackNonPartEntity;

public interface FeedbackNonPartRepository extends CrudRepository<FeedbackNonPartEntity, EventPK> {

}
