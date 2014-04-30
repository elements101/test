package com.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.*;
import com.opensymphony.xwork2.ActionContext;
import com.service.*;
@Controller @Scope("prototype")
public class ShopCartAction {
	@Resource ShopCartService shopcartservice;
	@Resource AdminService adminservice;
	@Resource ConsumerService consumerservice;
	private SP sp;
	int cout=0;

	public String cartAdd() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		sp=adminservice.selectSP(Integer.parseInt(request.getParameter("spid")));
		if(ShopCartService.addItem(sp)){
			
			int num = Integer.parseInt(request.getParameter("num"));
			ShopCartService.updateNum((int)sp.getSPId(), num);
			if((Integer)ActionContext.getContext().getSession().get("cout")!=null){
				int cout=(Integer)ActionContext.getContext().getSession().get("cout");
			}
			ActionContext.getContext().getSession().put("cout", cout+1);
			
		}else{
		
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('添加失败，该产品已经在购物车里面存在！');</script>");
			return "fail";
		}
		return "success";
	}
	
	public String cartList() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();	
		HttpSession session = request.getSession();
		session.setAttribute("cartItems", shopcartservice.getItems());
		session.setAttribute("price", shopcartservice.getPrice());
		return "success";
	}
	
	public String cartChangeNum() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		sp=adminservice.selectSP(Integer.parseInt(request.getParameter("pid")));
		int num = Integer.parseInt(request.getParameter("num"));
		if(num>(int)sp.getProduct().getNum()){
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('变更失败，购买数量大于商品的库存数量');</script>");
			return "fail";
		}
		ShopCartService.updateNum((int)sp.getSPId(), num);
		return "success";

	}
	public String delProduct() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		int cout=(Integer)ActionContext.getContext().getSession().get("cout");
		ActionContext.getContext().getSession().put("cout", cout-1);
		ShopCartService.drop(Integer.parseInt(request.getParameter("pid")));
		return "success";
		
	}
	public String buyProduct()throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ArrayList<ShopCart> list=(ArrayList<ShopCart>) session.getAttribute("cartItems");
		Consumer user=(Consumer)ActionContext.getContext().getSession().get("consumer");
		HttpServletResponse response = ServletActionContext.getResponse();
		if (user == null) {
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('请先登录');</script>");
			return "fail";
		}
		for(ShopCart cart:list){
			
	         consumerservice.buyProduct(cart.getSp().getSPId(), user, cart.getNum());
			
		}
		return "success";

	}

}
