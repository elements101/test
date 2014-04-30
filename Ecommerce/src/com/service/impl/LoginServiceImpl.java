package com.service.impl;
import java.util.List;

import com.bean.*;
import com.dao.*;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionContext;
import com.service.LoginService;
@Service @Transactional
public class LoginServiceImpl implements LoginService {
	@Resource ConsumerDAO consumerdao;
	@Resource AdminDAO admindao;
	@Resource SellerDAO sellerdao;
	public Consumer consumerLogin(String name,String password){
		Consumer con = consumerdao.findbyUName(name);
		System.out.println(password);
		if (con!=null&&con.getPassword().trim().equals(password)) {
			
			return con;
	        
		} else {
			return null;
		}

	}
	public Seller sellerLogin(String name){
		 Seller seller = sellerdao.findbyUName(name);
		if (seller!=null) {
			return seller;
		} else {
			return null;
		}

	}
	public Admin adminLogin(String name,String password){
		Admin admin =admindao.findbyAname(name);
		if(admin!=null&&admin.getPassword().trim().equals(password)){
			return admin;
		}else{
			return null;
		}
	}
	
}
