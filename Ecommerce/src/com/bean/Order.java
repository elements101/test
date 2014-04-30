package com.bean;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private OrderId id;
	private Consumer consumer;
	private SP SP;
	private Integer num;
	private double tprice;
	private Integer status;
	private String comment;


	public Order() {
	}


	public Order(OrderId id, Consumer consumer, SP SP) {
		this.id = id;
		this.consumer = consumer;
		this.SP = SP;
	}


	public Order(OrderId id, Consumer consumer, SP SP, Integer num,
			double tprice, Integer status, String comment) {
		this.id = id;
		this.consumer = consumer;
		this.SP = SP;
		this.num = num;
		this.tprice = tprice;
		this.status = status;
		this.comment = comment;
	}



	public OrderId getId() {
		return this.id;
	}

	public void setId(OrderId id) {
		this.id = id;
	}

	public Consumer getConsumer() {
		return this.consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public SP getSP() {
		return this.SP;
	}

	public void setSP(SP SP) {
		this.SP = SP;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public double getTprice() {
		return this.tprice;
	}

	public void setTprice(double tprice) {
		this.tprice = tprice;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}