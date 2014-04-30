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
public class ConsumerAction {
	@Resource ConsumerService consumerservice;
	private HttpServletRequest request = null;
	private javax.servlet.http.HttpServletResponse response;
	Consumer consumer;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public javax.servlet.http.HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(javax.servlet.http.HttpServletResponse response) {
		this.response = response;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public String execute() throws Exception {
		ActionContext.getContext().getSession().put("consumer", consumer);
		consumerservice.updateConInfo(consumer);
		return "success";
	}
	public String getOrder(){
		Consumer consumer=(Consumer)ActionContext.getContext().getSession().get("consumer");
		List<Order> l=consumerservice.getAllOrder(consumer);

		if(l!=null){
			request=ServletActionContext.getRequest();
			request.setAttribute("ors", l);
			return "success";
		}else 
			return "fail";
	}
	public String selectCon(){
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String comment=ServletActionContext.getRequest().getParameter("comment");
		request=ServletActionContext.getRequest();
		request.setAttribute("spid", spid);
		request.setAttribute("comment", comment);
		return "success";
	}
	public String setComment(){
		Consumer consumer=(Consumer)ActionContext.getContext().getSession().get("consumer");
		String spid=ServletActionContext.getRequest().getParameter("spid");
		String comment=ServletActionContext.getRequest().getParameter("comment");
		consumerservice.setComment(Integer.parseInt(spid), consumer, comment);
		return "success";
	}
}
