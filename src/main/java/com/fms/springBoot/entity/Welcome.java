package com.fms.springBoot.entity;

public class Welcome {
	public Welcome(String message) {
		super();
		this.message = message;
	}
	private final String message;
	
	public String getMessage() {
		return message;
	}
}