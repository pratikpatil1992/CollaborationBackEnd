package com.letzchat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Job extends BaseDomain{

	@Id
	@Column
	private String id;
	
	@Column
	private String title;
	
	@Column
	private Date date_time;
	
	@Column
	private String description;
	
	@Column
	private String qualification;
	
	@Column
	private char status;     //Admin S->Select; R->Reject; C->Call For Interview; V=vacant; C=closed
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_Time(Date date_Time) {
		this.date_time = new Date();
	}
	
	
}
