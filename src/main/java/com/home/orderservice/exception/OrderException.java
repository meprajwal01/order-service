package com.home.orderservice.exception;

import java.util.Date;

public class OrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date timeStamp;
	private String message;
	private String detail;

	public OrderException(Date timeStamp, String message, String detail) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.detail = detail;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
