<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  <h2>管理员登录</h2>
  <img  src="tian3.jpg">
 
   <h3>
   <form action="servlet/LoginServlet2" method="post">
      姓名：<input type="text" name="name" value="" /><br>
      密码：<input type="password" name="pass" value="" /><br>
   验证码：<input type="text" name="checkNumber" value="" />
       <img src="servlet/NumberServlet"  border=1/> <br>  
      <input type="submit" name="" value="登陆"/>
      <input type="submit" name="" value="取消"/>
      </form>
   </center>
   </h3>
  </body>
</html>
