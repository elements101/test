package com.service.impl;

import java.util.List;

import com.bean.*;
import com.dao.*;
import com.service.ConsumerService;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
@Service @Transactional
public class ConsumerServiceImpl implements ConsumerService{
	@Resource ConsumerDAO consumerdao;
	@Resource OrderDAO  orderdao;
	@Resource SPDAO spdao;
	   public void updateConInfo(Consumer consumer){
		     consumerdao.update(consumer);
	   }
	   public List<Order> getAllOrder(Consumer consumer){
		   List<Order> order=orderdao.findbyUId(consumer.getUId());
		   return order;
	   }
	   public void setComment(Integer spid,Consumer consumer,String comment){
		   OrderId orderid=new OrderId();
		   orderid.setSPId(spid);
		   orderid.setUId(consumer.getUId());
			  Order o=orderdao.find(orderid);
			  o.setComment(comment);
			  orderdao.update(o);  
	   }
	   public boolean buyProduct(Integer spid,Consumer consumer,Integer num){
		   SP sp=spdao.find(spid);
		   OrderId id=new OrderId(consumer.getUId(),sp.getSPId());
		   Order order=new Order(id,consumer,sp);
		   order.setNum(num);
		   order.setTprice((int)num*(sp.getProduct().getPrice()));
			try{
				orderdao.save(order);
				return true;
			}
			catch(Exception e){
				return false;
			}
	   }

}