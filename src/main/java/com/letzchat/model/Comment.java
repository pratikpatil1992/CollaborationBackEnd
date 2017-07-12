package com.letzchat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Comments")
public class Comment extends BaseDomain{
	
	@Id
	@Column
	private String id;

	@Column
	private String content;

	@Column
	private String user_id;

	@Column
	private String blog_id;
	
	@Column
	private Date commentDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}

	public Date getcommentDate() {
		return commentDate;
	}

	public void setcommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

}
