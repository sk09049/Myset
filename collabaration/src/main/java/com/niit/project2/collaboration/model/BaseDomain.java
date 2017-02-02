package com.niit.project2.collaboration.model;

import javax.persistence.Transient;

public class BaseDomain {
	@Transient
	private String errorCode;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Transient
	private String errorMessage;

}
