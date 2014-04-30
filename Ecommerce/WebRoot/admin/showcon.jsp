<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员中心</title>

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
                      	<li><a href='/Ecommerce/showcon.action' class="active">管理用户</a></li>
                        <li><a href="/Ecommerce/showaproduct.action">管理仓库的产品信息</a></li>
                    	<li><a href='/Ecommerce/showsp.action'>管理发布的产品信息</a></li>
                        <li><a href="/Ecommerce/showaorder.action">查看订单</a></li>
                    	<li><a href='/Ecommerce/updatecomment.action'>管理留言</a></li>
                    </ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2 class="action"><a href="#">Admin用户</a> &raquo; <a href="#" class="active">管理用户</a></h2>
                
                <div id="main">
                	<form action="" class="jNice">
					<h3>请选择</h3>

<table border="0.5px" width="787" class="style"
				style="margin-top: 50px;">


				<tr bgcolor="lightgreen">
					<td>
						用户号
					</td>
					<td>
						用户名
					</td>
					<td>
						密码
					</td>
					<td>电话</td>
					<td> 地址</td>
					<td>邮箱</td>
					<td>积分</td>

					<td align="center">
					          操作 
					</td>
				</tr>

				<s:iterator value="%{#request.allconsumer}" var="allconsumer">
					<tr>
						<td align="center">
							<s:property value="#allconsumer.UId" />
						</td>
						<td align="center">
							<s:property value="#allconsumer.UName" />
						</td>
						<td align="center">
							<s:property value="#allconsumer.password" />
						</td>
						<td align="center">
							<s:property value="#allconsumer.phone" />
						</td>
						<td align="center">
							<s:property value="#allconsumer.address" />
						</td>
						<td align="center">
							<s:property value="#allconsumer.email" />
						</td>
						<td align="center">
							<s:property value="#allconsumer.vip" />
						</td>
		
						<td align="center"><a href="selectcon.action?scid=<s:property value='#allconsumer.UId' />">修改</a>
				                           <a href="deletecon.action?cid=<s:property value='#allconsumer.UId' />">删除</a>
						</td>
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

