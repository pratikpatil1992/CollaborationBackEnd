package com.letzchat.Collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="c_user")
public class User extends BaseDomain{

@Id
@Column
private String	id;

@Column
private String name;

@Column
private String password;

@Column
private String role;

@Column
private String email;

@Column
private String address;

@Column
private String mobile;

@Column
private char isOnline;

@Column
@Transient
private String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

@Column
private Date lastSeenTime;

public Date getLastSeenTime() {
	return lastSeenTime;
}

public void setLastSeenTime(Date lastSeenTime) {
	this.lastSeenTime = lastSeenTime;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public char getIsOnline() {
	return isOnline;
}

public void setIsOnline(char isOnline) {
	this.isOnline = isOnline;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

}