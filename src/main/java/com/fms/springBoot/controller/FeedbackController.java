package com.fms.springBoot.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.springBoot.Model.FeedbackModel;
import com.fms.springBoot.Model.FeedbackNonPartUnRegModel;
import com.fms.springBoot.Model.ResponseModel;
import com.fms.springBoot.entity.FeedbackNonPartEntity;
import com.fms.springBoot.entity.FeedbackScoreEntity;
import com.fms.springBoot.entity.FeedbackUnRegEntity;
import com.fms.springBoot.service.FeedbackService;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/feedbackSave")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	
	@PostMapping(value = "/feedbackSave")
	public ResponseModel saveFeedback(@RequestBody FeedbackModel fModel) {

		FeedbackScoreEntity savedEntity = feedbackService.save(fModel);
		ResponseModel reModel = new ResponseModel();

		if (Objects.isNull(savedEntity)) {
			reModel.setMessage("Feedback Already Submitted");
			reModel.setHttpStatus(HttpStatus.OK.value());
		} else {
			reModel.setMessage("Feedback Submitted Successfully");
			reModel.setHttpStatus(HttpStatus.OK.value());
		}
		return reModel;
	}

	@PostMapping("/nonPart")
	public ResponseModel saveNonPartFeedback(@RequestBody FeedbackNonPartUnRegModel fModel) {

		FeedbackNonPartEntity savedEntity = feedbackService.saveNp(fModel);
		ResponseModel reModel = new ResponseModel();

		if (Objects.isNull(savedEntity)) {
			reModel.setMessage("Feedback Already Submitted");
			reModel.setHttpStatus(HttpStatus.OK.value());
		} else {
			reModel.setMessage("Feedback Submitted Successfully");
			reModel.setHttpStatus(HttpStatus.OK.value());
		}
		return reModel;
	}

	@PostMapping("/unReg")
	public ResponseModel saveUnRegFeedback(@RequestBody FeedbackNonPartUnRegModel fModel) {

		FeedbackUnRegEntity savedEntity = feedbackService.saveUr(fModel);
		ResponseModel reModel = new ResponseModel();

		if (Objects.isNull(savedEntity)) {
			reModel.setMessage("Feedback Already Submitted");
			reModel.setHttpStatus(HttpStatus.OK.value());
		} else {
			reModel.setMessage("Feedback Submitted Successfully");
			reModel.setHttpStatus(HttpStatus.OK.value());
		}
		return reModel;
	}
}

