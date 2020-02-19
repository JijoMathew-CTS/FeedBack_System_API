package com.fms.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.FeedbackNonPartEntity;
import com.fms.entity.FeedbackScoreEntity;
import com.fms.entity.FeedbackUnRegEntity;
import com.fms.model.FeedbackModel;
import com.fms.model.FeedbackNonPartUnRegModel;
import com.fms.model.ResponseModel;
import com.fms.service.FeedBackService;

@RestController
@CrossOrigin(origins = "*")
public class FeedBackController {

	@Autowired
	private FeedBackService feedbackService;

	
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

