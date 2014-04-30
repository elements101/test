<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>卖家中心</title>

<!-- CSS -->
<link href="/Ecommerce/style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="style/css/ie7.css" /><![endif]-->

<!-- JavaScripts-->
<script type="text/javascript" src="/Ecommerce/style/js/jquery.js"></script>
<script type="text/javascript" src="/Ecommerce/style/js/jNice.js"></script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>Transdmin Light</span></a></h1>
        
        <!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        <ul id="mainNav">
        	<li><a href="index.html" class="active">首页</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="#">帮助</a></li>
        	<li class="logout"><a href="index.html">退出</a></li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="/Ecommerce/seller/addproduct.jsp">上传产品</a></li>
                    	<li><a href='/Ecommerce/showproduct.action'>查看产品</a></li>
                    	<li><a href='/Ecommerce/spproduct.action'>产品上架</a></li>
                    	<li><a href='/Ecommerce/showup.action'>查看上架产品</a></li>
                    	<li><a href='/Ecommerce/showall.action'class="active">查看订单</a></li>
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">注册用户</a> &raquo; <a href="#" class="active">查看订单</a></h2>
                
                <div id="main">
                	<form action="" class="jNice">
	    <table border="1" width="85%" align="center">
    	<tr bgcolor="lightgreen">
    		<td align="center">上架号</td>
    		<td align="center">商品名</td>
    		<td align="center">商品单价</td>
    		<td align="center">购买数量</td>
    		<td align="center">总价</td>
    		<td align="center">快递号</td>
    		<td align="center">买家</td>
    		<td align="center">评价</td>
            <td align="center">发货</td>
    	</tr>
    	<s:iterator value="%{#request.oneorder}" var="oneorder">
    	<tr>
    		<td align="center"><s:property value="#oneorder.SP.SPId" /></td>
    		<td align="center"><s:property value="#oneorder.SP.product.PName" /></td>
    		<td align="center"><s:property value="#oneorder.SP.product.price" /></td>
    		<td align="center"><s:property value="#oneorder.num.intValue()" /></td>
    		<td align="center">&nbsp;<s:property value="#oneorder.tprice" /></td>
    		<td align="center">&nbsp;<s:property value="#oneorder.status" /></td>
    		<td align="center">&nbsp;<s:property value="#oneorder.consumer.UName" /></td>
    		<td align="center">&nbsp;<s:property value="#oneorder.comment" /></td>
    		<td align="center"><a href="selectorder.action?spid=<s:property value='#oneorder.SP.SPId' />&uid=<s:property value='#oneorder.consumer.UId' />&status=<s:property value='#oneorder.status' />">发货</a></td>
    	</tr>
    	</s:iterator>
    </table>
					<h3>&nbsp;</h3>
                    	<fieldset>
                        	&nbsp;</fieldset>
                  </form>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
         <p id="footer"> 版本 V1.0              Made by 吴云鹏</p>
    </div>
    <!-- // #wrapper -->
</body>
</html>