package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {



	private Integer PId;
	private String PName;
	private String description;
	private double price;
	private Integer num;
	private String type;
	private String image;
	private String SName;
	private Set SPs = new HashSet(0);


	public Product() {
	}


	public Product(Integer PId, String PName, double price) {
		this.PId = PId;
		this.PName = PName;
		this.price = price;
	}


	public Product(Integer PId, String PName, String description, double price,
			Integer num, String type, String image, String SName, Set SPs) {
		this.PId = PId;
		this.PName = PName;
		this.description = description;
		this.price = price;
		this.num = num;
		this.type = type;
		this.image = image;
		this.SName = SName;
		this.SPs = SPs;
	}



	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	public Set getSPs() {
		return this.SPs;
	}

	public void setSPs(Set SPs) {
		this.SPs = SPs;
	}

}