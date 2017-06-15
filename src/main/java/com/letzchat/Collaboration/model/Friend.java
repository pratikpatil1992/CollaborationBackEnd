package com.letzchat.Collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Friend extends BaseDomain
{

	@Id
	@Column
	private String id;
	
	@Column(name="user_id")
	private String user_id;
	
	@Column
	private String friend_id;
	
	//new,accepted,rejected
	@Column
	private Character status;
	
	@Column(name="isonline")
	private char isOnline;
	
	@Column(name="last_seen")
	private Date lastSeenTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFriend_id() {
		return friend_id;
	}
	public void setFriend_id(String friend_id) {
		this.friend_id = friend_id;
	}
	
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public char getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(char isOnline) {
		this.isOnline = isOnline;
	}
	public Date getLastSeenTime() {
		return lastSeenTime;
	}
	public void setLastSeenTime(Date lastSeenTime) {
		this.lastSeenTime = new Date();
	}
	
}