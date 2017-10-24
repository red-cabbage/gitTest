<%@ page language="java" import="java.util.*,beans.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product.jsp' starting page</title>
    
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
  <img alt="" src="tian.png"><br><br>
    <%=(String)session.getAttribute("name")%>,welcome!<br>
<jsp:useBean id="products" class="beans.CartBean"/>
<table border="1">
<tr><th>商品名称</th><th>商品类型</th><th>商品价格</th><th>商品数量</th><th>操作</th></tr>
<%
ArrayList<Product> list=products.getProducts();
for(int i=0;i<list.size();i++){
Product p=list.get(i);
%>
	<tr>
		<td><%=p.getName()%></td>
		<td><%=p.getType()%></td>
		<td><%=p.getPrice()%></td>
		<td><%=p.getQuantity()%></td>
		<td>
		<a href="servlet/AddCart?id=<%=p.getId()%>">加入购物车</a>
		</td>
	</tr>
<% }%>

</table>
  </body>
</html>
