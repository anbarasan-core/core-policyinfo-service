package com.alturion.core.policyinfo.common;

import java.time.LocalDateTime;

public class ApiResponse<T> {
	
	private LocalDateTime timeStamp;
	private int status;
	private String message;
	private T data;
	
	public ApiResponse() {
		super();
	}
	public ApiResponse(LocalDateTime timeStamp, int status, String message, T data) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	

}
