package com.letzchat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Blog extends BaseDomain{
	@Id
	@Column
	private String id;
	
	@Column
	private String title;
	
	@Column
	private String user_id;
	
	@Column
	@DateTimeFormat(pattern = "dd MM, yyyy HH:mm:ss")
	private Date date_time;
	
	@Column
	private String description;
	
	public Date getDate_time() {
		return date_time;
	}
	
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getUser_id() {
		return user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}