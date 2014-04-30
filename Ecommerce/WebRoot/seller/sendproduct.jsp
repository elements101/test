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
                    	<li><a href='/Ecommerce/showproduct.action'class="active">查看产品</a></li>
                    	<li><a href='/Ecommerce/spproduct.action'>产品上架</a></li>
                    	<li><a href='/Ecommerce/showup.action'>查看上架产品</a></li>
                    	<li><a href='/Ecommerce/showall.action'>查看订单</a></li>
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">注册用户</a> &raquo; <a href="#" class="active">查看产品</a></h2>
                
                <div id="main">

					<h3>请选择</h3>
		<form action="sendproduct.action" method="post">
			<table width="400px" border="1px" align="center" class="style"
				style="margin-top: 80px;">

				<tr>
					<td>
						上架号：
					</td>
					<td>
					<input type="text" value="${requestScope.spid}" readonly="readonly" name="spid"/>
						
					</td>
				</tr>
				<tr>
					<td>
						 用户号：
					</td>
					<td>
					<input type="text" value="${requestScope.uid}" readonly="readonly" name="uid"/>
						
					</td>
				</tr>
				<tr>
					<td>
						快递号：
					</td>
					<td>
					<input type="text" value="${requestScope.status}" name="status"/>
						
					</td>
				</tr>

				<tr>
					<td colspan="2">
					<input type="submit" value="提交"/>
					<input type="button" value="取消" onclick="window.history.go(-1)"/>
					</td>
				</tr>

			</table>
			</form>
               
					<h3>&nbsp;</h3>
                    	<fieldset>
                        	&nbsp;</fieldset>

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
