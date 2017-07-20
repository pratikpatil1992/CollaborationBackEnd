package com.letzchat.model;


public class Message {

	private String message;

	private String id;
	public Message(String id, String message) {
		this.id = id;
		this.message = message;
	}
	public Message() {
	
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	
}