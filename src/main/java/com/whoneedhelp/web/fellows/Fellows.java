package com.whoneedhelp.web.fellows;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Fellows {
	int fellowSeq;
	String nickname;
	String id;
	String password;
	Date regDate;
	int isActive;
	
	public int getFellowSeq() {
		return fellowSeq;
	}
	public void setFellowSeq(int fellowSeq) {
		this.fellowSeq = fellowSeq;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
}
