<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <title>�û���¼</title>
  </head>
  
  <body>
  <center>
  <form action="login.action" method="post" id="form1">
                                                         ��¼<br>
    �û�����: <select name="usertype" id="select" style="height: 33px;width: 158px;">
			<option value="0">�û�����</option>
			<option value="1">ע���û�</option>
			<option value="2">����Ա</option>
	</select> <br>
   �û���:&nbsp <input type="text" name="username" /><br>
   ����: &nbsp &nbsp<input type="password" name="password" /><br>
	   <input type="submit"  name="submit" value="��½"/>
	</form>
	 </center>
  </body>
</html>