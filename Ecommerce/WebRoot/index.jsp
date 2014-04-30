<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <title>用户登录</title>
  </head>
  
  <body>
  <center>
  <form action="login.action" method="post" id="form1">
                                                         登录<br>
    用户类型: <select name="usertype" id="select" style="height: 33px;width: 158px;">
			<option value="0">用户类型</option>
			<option value="1">注册用户</option>
			<option value="2">管理员</option>
	</select> <br>
   用户名:&nbsp <input type="text" name="username" /><br>
   密码: &nbsp &nbsp<input type="password" name="password" /><br>
	   <input type="submit"  name="submit" value="登陆"/>
	</form>
	 </center>
  </body>
</html>