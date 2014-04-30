package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Consumer entity. @author MyEclipse Persistence Tools
 */

public class Consumer implements java.io.Serializable {


	private Integer UId;
	private String UName;
	private String password;
	private String phone;
	private String address;
	private String email;
	private Integer vip;
	private Set orders = new HashSet(0);

	public Consumer() {
	}


	public Consumer(Integer UId, String UName) {
		this.UId = UId;
		this.UName = UName;
	}


	public Consumer(Integer UId, String UName, String password, String phone,
			String address, String email, Integer vip, Set orders) {
		this.UId = UId;
		this.UName = UName;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.vip = vip;
		this.orders = orders;
	}



	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getVip() {
		return this.vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}