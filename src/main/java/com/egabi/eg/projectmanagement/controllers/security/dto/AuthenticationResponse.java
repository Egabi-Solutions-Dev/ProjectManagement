package com.egabi.eg.projectmanagement.controllers.security.dto;

import com.egabi.eg.projectmanagement.model.entities.user.UserEntity;

public class AuthenticationResponse {

	private String accessToken;
//	private UserEntity userInfo;
//	private Boolean needsOtp;


	public AuthenticationResponse()
	{
		
	}

	public AuthenticationResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public AuthenticationResponse(String accessToken, UserEntity userInfo) {
		super();
		this.accessToken = accessToken;
//		this.userInfo =  userInfo;

	}
	public AuthenticationResponse(String accessToken, Boolean needsOtp) {
		this.accessToken = accessToken;
//		this.needsOtp = needsOtp;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
//
//	public Boolean getNeedsOtp() {
//		return needsOtp;
//	}
//
//	public void setNeedsOtp(Boolean needsOtp) {
//		this.needsOtp = needsOtp;
//	}
//
//	public UserEntity getUserInfo() {
//		return userInfo;
//	}
//
//	public void setUserInfo(UserEntity userInfo) {
//		this.userInfo = userInfo;
//	}
}
