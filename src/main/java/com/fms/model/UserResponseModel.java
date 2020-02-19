package com.fms.model;


public class UserResponseModel {

	private String id;
	private String name;
	private String emailId;
	private String role;
	private String isUserAuthentic;

	public UserResponseModel() {
	}

	public UserResponseModel(String id, String name, String emailId, String role, String isUserAuthentic) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.role = role;
		this.isUserAuthentic = isUserAuthentic;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getIsUserAuthentic() {
		return isUserAuthentic;
	}

	public void setIsUserAuthentic(String isUserAuthentic) {
		this.isUserAuthentic = isUserAuthentic;
	}

}
