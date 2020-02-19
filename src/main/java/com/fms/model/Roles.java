package com.fms.model;

public enum Roles {
	ROLE_ADMIN("A"),ROLE_PMO("PMO"),ROLE_POC("POC");
	
	String code;
	
	private Roles(String code) {
		this.code=code;
	}
	
	public String getCode() {
		return this.code;
	}
}
