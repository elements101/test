package com.service.impl;
import java.util.List;

import com.bean.*;
import com.dao.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.service.AdminService;
@Service @Transactional
public class AdminServiceImpl implements AdminService {
	@Resource ConsumerDAO consumerdao;
	@Resource ProductDAO productdao;
	@Resource SPDAO spdao;
	@Resource OrderDAO orderdao;
	public List getAllConInfo(){
		List<Consumer> allCon=consumerdao.list();
		return allCon;
		
	}
	public boolean deleteCon(Integer consumerid){
		try{
			consumerdao.delete(consumerid);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public Consumer selectCon(Integer consumerid){
		return consumerdao.find(consumerid);
	}
	public boolean editCon(Consumer consumer){
		try{
			consumerdao.update(consumer);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public List getAllProduct(){
		List<Product> allproduct=productdao.list();
		return allproduct;
	}
	public boolean editProduct(Product product){
		try{
			productdao.update(product);
			return true;
		}catch(Exception e){
			return false;
		}	
	}
	public Product selectProduct(Integer productid){
		return productdao.find(productid);
	}
	public boolean deleteProduct(Integer productid){
		try{
			productdao.delete(productid);
			return true;
		}
		catch(Exception e){
			return false;
		}	
	}
	public List getAllSP(){
		return spdao.list();
	}
	public SP selectSP(Integer spid){
		return spdao.find(spid);
	}
	public boolean deleteSP(Integer spid){
    	try{
    		spdao.delete(spid);
    		return true;
    	}catch (Exception e) {
    		return false;
		}
	}
	 public List getAllOrder(){
		 return orderdao.list();
	 }
	 public boolean deleteOrder(Integer UId,Integer SPId){
		 OrderId orderid= new OrderId();
		 orderid.setSPId(SPId);
		 orderid.setUId(UId);
		 try{
			  orderdao.delete(orderid);
	    	  return true;
	    	}catch (Exception e) {

	    		return false;
			}
	 }
	 public boolean updateComment(Integer UId,Integer SPId,String comment){
		 OrderId orderid= new OrderId();
		 orderid.setSPId(SPId);
		 orderid.setUId(UId);
		 System.out.println(comment);
		 try{
			  Order o=orderdao.find(orderid);
			  o.setComment(comment);
			  orderdao.update(o);
	    	  return true;
	    	}catch (Exception e) {

	    		return false;
			}
	 }
}
