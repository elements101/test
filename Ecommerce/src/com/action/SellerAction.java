package com.action;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.bean.*;
import com.service.*;
import com.opensymphony.xwork2.ActionContext;
@Controller @Scope("prototype")
public class SellerAction {
	@Resource SellerService sellerservice;
	Seller seller;
	Product newproduct;
	private HttpServletRequest request;
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public Product getNewproduct() {
		return newproduct;
	}
	public void setNewproduct(Product newproduct) {
		this.newproduct = newproduct;
	}
	public String addProduct(){
		seller=(Seller)ActionContext.getContext().getSession().get("seller");
		if(sellerservice.addProduct(newproduct)){
			List<Product> allproduct=sellerservice.showProduct(seller);
			request=ServletActionContext.getRequest();
			request.setAttribute("sproduct", allproduct);
			return "success";
		}
		else
			return "fail";
	}
	public String showProduct(){
		seller=(Seller)ActionContext.getContext().getSession().get("seller");
		List<Product> allproduct=sellerservice.showProduct(seller);
		request=ServletActionContext.getRequest();
		request.setAttribute("sproduct", allproduct);
		return "success";
	}
	public String selectProduct(){
		String pid=ServletActionContext.getRequest().getParameter("pid");
		Product product=sellerservice.selectProduct(Integer.parseInt(pid));
		if(product!=null){
			request=ServletActionContext.getRequest();
			request.setAttribute("selectproduct", product);
			return "success";
		}
		else
			return "fail";
	}
	public String editProduct(){

		if(sellerservice.editProduct(newproduct)){
			seller=(Seller)ActionContext.getContext().getSession().get("seller");
			List<Product> allproduct=sellerservice.showProduct(seller);
			request=ServletActionContext.getRequest();
			request.setAttribute("sproduct", allproduct);
			return "success";
		}
		else
			return "fail";
	}
	public String upProduct(){
		seller=(Seller)ActionContext.getContext().getSession().get("seller");
		request=ServletActionContext.getRequest();
		String pid=request.getParameter("upid");
		SP sp=new SP();
		sp.setSeller(seller);
		Product product=new Product();
		product.setPId(Integer.parseInt(pid));
		sp.setProduct(product);
		sellerservice.upProduct(sp);
		return "success";
	}
	public String showSp(){
		seller=(Seller)ActionContext.getContext().getSession().get("seller");
		request=ServletActionContext.getRequest();
		List<SP> l=sellerservice.showAllSp(seller);
		request.setAttribute("ssp", l);
		return "success";
		
	}
	public String cancelUp(){
		request=ServletActionContext.getRequest();
		String spid=request.getParameter("spid");
		SP sp=new SP();
		sp.setSPId(Integer.parseInt(spid));
		sellerservice.cancelUp(sp);
		return "success";
	}
	public String showOneOrder(){
		request=ServletActionContext.getRequest();
		String spid=request.getParameter("spid");
		List<Order> l=sellerservice.showOneStu(Integer.parseInt(spid));
		request.setAttribute("oneorder", l);
		return "success";
	}
	public String selectOrder(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String uid=ServletActionContext.getRequest().getParameter("uid");
		String status=ServletActionContext.getRequest().getParameter("status");
		request=ServletActionContext.getRequest();
		request.setAttribute("spid", spid);
		request.setAttribute("uid", uid);
		request.setAttribute("status", status);
		return "success";
	}
	public String sendProduct(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String uid=ServletActionContext.getRequest().getParameter("uid");
		String status=ServletActionContext.getRequest().getParameter("status");
		sellerservice.sendProduct(Integer.parseInt(spid), Integer.parseInt(uid), Integer.parseInt(status));
		return "success";
	}
}

