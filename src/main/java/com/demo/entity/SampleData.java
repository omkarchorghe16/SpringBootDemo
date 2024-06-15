package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class SampleData {

	private String success;
	private String error;
	
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "SampleData [success=" + success + ", error=" + error + "]";
	}
	
	
	
	
}
