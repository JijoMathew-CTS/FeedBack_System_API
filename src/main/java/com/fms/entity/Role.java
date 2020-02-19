package com.fms.entity;

public enum Role {

	ROLE_ADMIN("A"), ROLE_PMO("PMO"), ROLE_POC("POC");

	String code;

	private Role(String code) {
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
}