package com.cmv.caseproject.responses;

public class AdminLoginResponse {
	private String jwtToken;

	public AdminLoginResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
}
