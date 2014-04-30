package com.bean;

/**
 * OrderId entity. @author MyEclipse Persistence Tools
 */

public class OrderId implements java.io.Serializable {

	// Fields

	private Integer UId;
	private Integer SPId;

	// Constructors

	/** default constructor */
	public OrderId() {
	}

	/** full constructor */
	public OrderId(Integer UId, Integer SPId) {
		this.UId = UId;
		this.SPId = SPId;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public Integer getSPId() {
		return this.SPId;
	}

	public void setSPId(Integer SPId) {
		this.SPId = SPId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OrderId))
			return false;
		OrderId castOther = (OrderId) other;

		return ((this.getUId() == castOther.getUId()) || (this.getUId() != null
				&& castOther.getUId() != null && this.getUId().equals(
				castOther.getUId())))
				&& ((this.getSPId() == castOther.getSPId()) || (this.getSPId() != null
						&& castOther.getSPId() != null && this.getSPId()
						.equals(castOther.getSPId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUId() == null ? 0 : this.getUId().hashCode());
		result = 37 * result
				+ (getSPId() == null ? 0 : this.getSPId().hashCode());
		return result;
	}

}