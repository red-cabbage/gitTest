<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add_product.jsp' starting page</title>
    
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
   <form action="servlet/AddProduct" method="post">
名称：&nbsp;&nbsp;<input type="text" name="name"/><br>
类型：&nbsp;&nbsp;<input type="text" name="type"/><br>
价格：&nbsp;&nbsp;<input type="text" name="price"/><br>
数量：&nbsp;&nbsp;<input type="text" name="quantity"/><br>
图片：&nbsp;&nbsp;<input type="text" name="img"/><br>
描述：&nbsp;&nbsp;<textarea name="desc" cols="50" rows="5"/></textarea><br>
&nbsp;&nbsp;<input type="submit" value="添加"/>
&nbsp;&nbsp;<input type="reset" value="取消"/>
</form>
  </body>
</html>
