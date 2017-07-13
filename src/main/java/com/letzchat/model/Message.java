package com.letzchat.model;

public class Message {

	private String message;
	
	private long id;
	
	private String user_id;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public Message(String message, long id, String user_id) {
		super();
		this.message = message;
		this.id = id;
		this.user_id = user_id;
	}
	
	
}
