package com.fms.repo;


import org.springframework.data.repository.CrudRepository;

import com.fms.entity.EventPK;
import com.fms.entity.FeedbackNonPartEntity;

public interface FeedbackNonPartRepository extends CrudRepository<FeedbackNonPartEntity, EventPK> {

}
