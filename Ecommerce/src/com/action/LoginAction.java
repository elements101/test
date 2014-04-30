package com.action;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bean.*;
import com.service.*;
import com.opensymphony.xwork2.ActionContext;
@Controller @Scope("prototype")
public class LoginAction {
	@Resource LoginService loginService;
	private String usertype;
	private String username;
    private String password;
    int cout=0;
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    public String execute() {
		if (username.equals("")||password.equals("")) {
			return "fail";
		} else if (usertype.equals("1")) {
			Consumer consumer = loginService.consumerLogin(username, password);
			Seller seller=loginService.sellerLogin(username);
			System.out.println(seller.getSName());
			if (consumer != null) {
				ActionContext.getContext().getSession().put("consumer", consumer);
				ActionContext.getContext().getSession().put("seller", seller);
				ActionContext.getContext().getSession().put("cout", cout);
				ActionContext.getContext().getSession()
						.put("username", consumer.getUName());
				return "consumersuccess";
			} else
				return "fail";
		}
		if (usertype.equals("2")) {
			Admin admin = loginService.adminLogin(username, password);
			if (admin != null) {
				ActionContext.getContext().getSession().put("admin", admin);
				ActionContext.getContext().getSession()
						.put("username", admin.getAName());
				return "adminsuccess";
			} else
				return "fail";
		}
		return "fail";
    }
}
