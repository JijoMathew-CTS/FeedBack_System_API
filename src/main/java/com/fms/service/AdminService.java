package com.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fms.entity.IFeedbackStatus;
import com.fms.entity.UserRole;
import com.fms.model.Roles;
import com.fms.repo.EventRptRepository;
import com.fms.repo.RoleRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AdminService {
	@Autowired
	private RoleRepository userRoleRepository;

	@Autowired
	private EventRptRepository eRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void addAdmin(String associateId) {
		userRoleRepository.save(new UserRole(associateId + "@cognizant.com", // email
				associateId, // username
				passwordEncoder.encode(associateId), // password
				true, true, true, true, Roles.ROLE_ADMIN));
	}

	public void addPmo(String associateId) {
		userRoleRepository.save(new UserRole(associateId + "@cognizant.com", // email
				associateId, // username
				passwordEncoder.encode(associateId), // password
				true, true, true, true, Roles.ROLE_PMO));
	}
	
	public void addPmoMulitple(List<UserRole> associateIds) {

		userRoleRepository.saveAll(associateIds);
	}

	public boolean checkIfAlreadyExisted(String ids) {

		Optional<UserRole> userRole = userRoleRepository.findByAssociateId(ids);
		return userRole.isPresent();
	}

	public List<IFeedbackStatus> getFeedbackStatusReport(String type) {

		List<IFeedbackStatus> feedbackList = new ArrayList<>();

		if (type != null && !"".equals(type)) {
			switch (type) {
			case "va":
				feedbackList = eRepository.findAllByVaStatus();
				break;
			case "vna":
				feedbackList = eRepository.findAllByVnaStatus();
				break;
			case "vun":
				feedbackList = eRepository.findAllByVunStatus();
				break;
			}
		}
		return feedbackList;

	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}
