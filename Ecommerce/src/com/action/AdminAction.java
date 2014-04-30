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
public class AdminAction {
	@Resource AdminService adminservice;
	private HttpServletRequest request;
	private Consumer consumer;
	private Seller seller;
	private Product product;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getAllConInfo(){
		request=ServletActionContext.getRequest();
		List<Consumer> l=adminservice.getAllConInfo();
		request.setAttribute("allconsumer", l);
		return "success";
	}
	public String deleteCon(){
		String cid=ServletActionContext.getRequest().getParameter("cid");
		if(adminservice.deleteCon(Integer.parseInt(cid))){
			request=ServletActionContext.getRequest();
			List<Consumer> l=adminservice.getAllConInfo();
			request.setAttribute("allconsumer", l);
			return "success";
		}
		else
			return "false";
	}
	public String selectCon(){
		String cid=ServletActionContext.getRequest().getParameter("scid");
		Consumer con=adminservice.selectCon(Integer.parseInt(cid));
		if(con!=null){
			request=ServletActionContext.getRequest();
			request.setAttribute("selectcon", con);
			return "success";
		}
		else
			return "fail";
	}
	public String editCon(){
		if(adminservice.editCon(consumer)){
			request=ServletActionContext.getRequest();
			List<Consumer> l=adminservice.getAllConInfo();
			request.setAttribute("allconsumer", l);
			return "success";
		}		
		else
			return "fail";
	}
	public String getAllProduct(){
		request=ServletActionContext.getRequest();
		List<Product> l=adminservice.getAllProduct();
		request.setAttribute("allproduct", l);
		return "success";
	}
	public String deleteProduct(){
		String sid=ServletActionContext.getRequest().getParameter("sid");
		if(adminservice.deleteProduct(Integer.parseInt(sid))){
			request=ServletActionContext.getRequest();
			List<Product> l=adminservice.getAllProduct();
			request.setAttribute("allproduct", l);
			return "success";
		}
		else
			return "false";
	}
	
	public String selectProduct(){
		String pid=ServletActionContext.getRequest().getParameter("apid");
		Product product=adminservice.selectProduct(Integer.parseInt(pid));
		if(product!=null){
			request=ServletActionContext.getRequest();
			request.setAttribute("selectproduct", product);
			return "success";
		}
		else
			return "fail";
	}
	public String editProduct(){
		if(adminservice.editProduct(product)){
			request=ServletActionContext.getRequest();
			List<Product> l=adminservice.getAllProduct();
			request.setAttribute("allproduct", l);
			return "success";
		}		
		else
			return "fail";
	}
	public String  getAllSP(){
		request=ServletActionContext.getRequest();
		List<SP> l=adminservice.getAllSP();
		request.setAttribute("allsp", l);
		return "success";
	}
	public String deleteSP(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		if(adminservice.deleteSP(Integer.parseInt(spid))){
			request=ServletActionContext.getRequest();
			List<SP> l=adminservice.getAllSP();
			request.setAttribute("allsp", l);
			return "success";
		}
		else
			return "false";
	}
	public String getAllOrder(){
		request=ServletActionContext.getRequest();
		List<Order> l=adminservice.getAllOrder();
		request.setAttribute("allorder", l);
		return "success";
	}
	public String deleteOrder(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String uid=ServletActionContext.getRequest().getParameter("uid");
		if(adminservice.deleteOrder(Integer.parseInt(uid), Integer.parseInt(spid))){
			request=ServletActionContext.getRequest();
			List<Order> l=adminservice.getAllOrder();
			request.setAttribute("allorder", l);
			return "success";
		}
		else
			return "false";
	}
	public String selectComment(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String uid=ServletActionContext.getRequest().getParameter("uid");
		String comment=ServletActionContext.getRequest().getParameter("comment");
		request=ServletActionContext.getRequest();
		request.setAttribute("spid", spid);
		request.setAttribute("uid", uid);
		request.setAttribute("comment", comment);
		return "success";
	}
	public String updateComment(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String uid=ServletActionContext.getRequest().getParameter("uid");
		String comment=ServletActionContext.getRequest().getParameter("comment");
		if(adminservice.updateComment(Integer.parseInt(uid), Integer.parseInt(spid),comment)){
			request=ServletActionContext.getRequest();
			List<Order> l=adminservice.getAllOrder();
			request.setAttribute("allorder", l);
			return "success";
		}
		else
			return "false";
	}
}
