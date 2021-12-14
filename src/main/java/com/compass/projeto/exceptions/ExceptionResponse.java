package com.compass.projeto.exceptions;

public class ExceptionResponse {
	
	private String field;
	private Integer status_code;
	private String message;
	
	public ExceptionResponse(String field, Integer status_code, String message) {
		this.field = field;
		this.status_code = status_code;
		this.message = message;
	}
	
	public ExceptionResponse(Integer status_code, String message) {
		this.field = "";
		this.status_code = status_code;
		this.message = message;
	}
	
	public String getField() {
		return field;
	}
	public Integer getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
