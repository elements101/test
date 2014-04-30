package com.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SP entity. @author MyEclipse Persistence Tools
 */

public class SP implements java.io.Serializable {

	// Fields

	private Integer SPId;
	private Seller seller;
	private Product product;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public SP() {
	}

	/** minimal constructor */
	public SP(Integer SPId, Seller seller, Product product) {
		this.SPId = SPId;
		this.seller = seller;
		this.product = product;
	}

	/** full constructor */
	public SP(Integer SPId, Seller seller, Product product, Set orders) {
		this.SPId = SPId;
		this.seller = seller;
		this.product = product;
		this.orders = orders;
	}

	// Property accessors

	public Integer getSPId() {
		return this.SPId;
	}

	public void setSPId(Integer SPId) {
		this.SPId = SPId;
	}

	public Seller getSeller() {
		return this.seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}