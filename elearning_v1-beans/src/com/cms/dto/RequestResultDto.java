package com.cms.dto;

public class RequestResultDto {
	private String code;
	private String error;
	private String accessToken;
	
	
	public RequestResultDto() {
		super();
	}


	public RequestResultDto(String code, String error, String accessToken) {
		super();
		this.code = code;
		this.error = error;
		this.accessToken = accessToken;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getAccessToken() {
		return accessToken;
	}


	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
