package com.bean;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {



	private Integer AId;
	private String AName;
	private String password;


	public Admin() {
	}


	public Admin(Integer AId) {
		this.AId = AId;
	}


	public Admin(Integer AId, String AName, String password) {
		this.AId = AId;
		this.AName = AName;
		this.password = password;
	}



	public Integer getAId() {
		return this.AId;
	}

	public void setAId(Integer AId) {
		this.AId = AId;
	}

	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}