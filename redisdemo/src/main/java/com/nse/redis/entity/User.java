package com.nse.redis.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userName;
	private String phoneNo;
	private String emailId;
	private Date creationDate;
	private String password;
	private String fullName;
	public  User()
	{
		
	}
	public User(long userId, String userName, String phoneNo, String emailId, Date creationDate, String password,
			String fullName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.creationDate = creationDate;
		this.password = password;
		this.fullName = fullName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", phoneNo=" + phoneNo + ", emailId=" + emailId
				+ ", creationDate=" + creationDate + ", password=" + password + ", fullName=" + fullName + "]";
	}
	
	
	

}