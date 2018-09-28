package com.mc.demo.app.enrollement;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
	
	@JsonProperty(value = "userid", required = true)
	@NotEmpty(message = " UserId is required")
	private String userId;
	
	@JsonProperty(value = "password", required = true)
	@NotEmpty(message = "Password is required")
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return String.format("Login [userId=%s, password=%s]", userId, password);
	}

	
}
