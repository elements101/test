package com.service.impl;
import java.util.List;

import com.bean.*;
import com.dao.*;
import com.service.SellerService;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
@Service @Transactional
public class SellerServiceImpl implements SellerService{
	@Resource ProductDAO productdao;
	@Resource SPDAO spdao;
	@Resource OrderDAO orderdao;
	public boolean addProduct(Product product){
		try{
			System.out.println(product.getPName());
			productdao.save(product);
			return true;
		}catch(Exception e){
			return false;
		}	
	}
	public List<Product> showProduct(Seller seller){
		return productdao.findbySname(seller.getSName());
	}
	public Product selectProduct(Integer PId){
		return productdao.find(PId);
	}
	public void upProduct(SP sp){
		spdao.save(sp);
	}
	public boolean editProduct(Product product){
		try{
			productdao.update(product);
			return true;
		}catch(Exception e){
			return false;
		}	
	}
	public List<SP> showAllSp(Seller seller){
		List<SP> l=spdao.findbySId(seller.getSId());
		return l;
	}
	 public void cancelUp(SP instance){
		 spdao.delete(instance.getSPId());
	 }
	 public List<Order> showOneStu(Integer SPId){
		 List<Order> l=orderdao.findbySPId(SPId);
		 return l;
	 }
	 public void sendProduct(Integer spid,Integer uid,Integer status){
		   OrderId id=new OrderId(uid,spid);
		   Order order=orderdao.find(id);
		   order.setStatus(status);
		   orderdao.update(order);
	 }

}