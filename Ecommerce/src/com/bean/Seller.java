package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Seller entity. @author MyEclipse Persistence Tools
 */

public class Seller implements java.io.Serializable {

	// Fields

	private Integer SId;
	private String SName;
	private String SPhone;
	private Set SPs = new HashSet(0);


	public Seller() {
	}


	public Seller(Integer SId) {
		this.SId = SId;
	}


	public Seller(Integer SId, String SName, String SPhone, Set SPs) {
		this.SId = SId;
		this.SName = SName;
		this.SPhone = SPhone;
		this.SPs = SPs;
	}



	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public String getSPhone() {
		return this.SPhone;
	}

	public void setSPhone(String SPhone) {
		this.SPhone = SPhone;
	}

	public Set getSPs() {
		return this.SPs;
	}

	public void setSPs(Set SPs) {
		this.SPs = SPs;
	}

}