package com.fms.springBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.springBoot.FeedbackNonPartRepository;
import com.fms.springBoot.FeedbackRepository;
import com.fms.springBoot.FeedbackUnRegRepository;
import com.fms.springBoot.Model.FeedbackModel;
import com.fms.springBoot.Model.FeedbackNonPartUnRegModel;
import com.fms.springBoot.entity.EventPK;
import com.fms.springBoot.entity.FeedbackNonPartEntity;
import com.fms.springBoot.entity.FeedbackScoreEntity;
import com.fms.springBoot.entity.FeedbackUnRegEntity;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository fRepository;

	@Autowired
	private FeedbackNonPartRepository fNonPartRepository;

	@Autowired
	private FeedbackUnRegRepository fUnRegRepository;

	public FeedbackScoreEntity save(FeedbackModel fModel) {

		Optional<FeedbackScoreEntity> feedback = fRepository
				.findById(new EventPK(fModel.getEventId(), fModel.getEmployeeId()));

		boolean exists = feedback.isPresent();

		if (exists) {

			return null;
		}
		FeedbackScoreEntity fEntity = new FeedbackScoreEntity();
		fEntity.setEventPK(new EventPK(fModel.getEventId(), fModel.getEmployeeId()));
		fEntity.setScore(fModel.getScore());
		fEntity.setAnswer1(fModel.getAnswer1());
		fEntity.setAnswer2(fModel.getAnswer2());
		fEntity.setStatus("I");

		return fRepository.save(fEntity);

	}

	public FeedbackNonPartEntity saveNp(FeedbackNonPartUnRegModel fModel) {
		// TODO Auto-generated method stub
		Optional<FeedbackNonPartEntity> feedback = fNonPartRepository
				.findById(new EventPK(fModel.getEventId(), fModel.getEmployeeId()));

		boolean exists = feedback.isPresent();

		if (exists) {

			return null;
		}
		FeedbackNonPartEntity fEntity = new FeedbackNonPartEntity();
		fEntity.setEventPK(new EventPK(fModel.getEventId(), fModel.getEmployeeId()));
		fEntity.setChoice(fModel.getChoice());
		fEntity.setStatus("I");

		return fNonPartRepository.save(fEntity);
	}

	public FeedbackUnRegEntity saveUr(FeedbackNonPartUnRegModel fModel) {
		// TODO Auto-generated method stub
		Optional<FeedbackUnRegEntity> feedback = fUnRegRepository
				.findById(new EventPK(fModel.getEventId(), fModel.getEmployeeId()));

		boolean exists = feedback.isPresent();

		if (exists) {

			return null;
		}
		FeedbackUnRegEntity fEntity = new FeedbackUnRegEntity();
		fEntity.setEventPK(new EventPK(fModel.getEventId(), fModel.getEmployeeId()));
		fEntity.setChoice(fModel.getChoice());
		fEntity.setStatus("I");

		return fUnRegRepository.save(fEntity);
	}

}
