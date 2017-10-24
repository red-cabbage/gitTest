<%@ page language="java" import="java.util.*,beans.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show_product.jsp' starting page</title>
    
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
  <jsp:useBean id="products" class="beans.ProductDao"></jsp:useBean>
   <table border="1">
  <tr><th>图片</th><th>商品名称</th><th>商品类型</th><th>商品价格</th><th>商品数量</th></tr>
<%request.setCharacterEncoding("utf-8");
String name=request.getParameter("name");
ArrayList<Product> list=null;
if("".equals(name)||name==null)
    list=products.getProducts();
    else
    list=products.searchProducts(name);
    for(int i=0;i<list.size();i++){
    Product p=list.get(i);
 %>
<tr>
<td><img src="img/<%=p.getImg() %>" width="100" height="100"/></td>
<td><%=p.getName() %></td>
<td><%=p.getType() %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getQuantity() %></td>
</tr>
<%} %>
</table>
  </body>
</html>
