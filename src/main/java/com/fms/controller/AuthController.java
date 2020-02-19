package com.fms.controller;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entity.User;
import com.fms.model.UserResponseModel;
import com.fms.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
	private LoginService loginService;

	@RequestMapping("/logout")
	public void logout(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	@RequestMapping("/login")
	public UserResponseModel authenticate(HttpServletRequest request) {
	
		String[] credentials = filterCredentials(request);
		System.out.println(credentials[0]);
		User user = loginService.getUserByCredentials(credentials);
		UserResponseModel userResponseModel = new UserResponseModel(user.getUsername(), user.getUsername(),
				user.getEmail(), user.getRole().name(), String.valueOf(loginService.authenticate(credentials)));
		return userResponseModel;
		
	}

	private String[] filterCredentials(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
		return new String(Base64.getDecoder().decode(authToken)).split(":");
	}
}
