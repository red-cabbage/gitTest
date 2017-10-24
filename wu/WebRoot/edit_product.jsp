<%@ page language="java" import="java.util.*,beans.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit_product.jsp' starting page</title>
    
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
  <%request.setCharacterEncoding("utf-8");
  response.setCharacterEncoding("utf-8"); %>
    <jsp:useBean id="pd" class="beans.ProductDao" scope="session"></jsp:useBean>
<%String id=request.getParameter("id");
 Product product=null;
 product=pd.getProduct(id);
 %>
<form action="servlet/EditProduct" method="post">
<input type="hidden" name="id" value="<%=id %>"/>
名称：&nbsp;&nbsp;<input type="text" name="name" value="<%=product.getName() %>"/><br>
类型：&nbsp;&nbsp;<input type="text" name="type" value="<%=product.getType() %>"/><br>
价格：&nbsp;&nbsp;<input type="text" name="price" value="<%=product.getPrice() %>"/><br>
数量：&nbsp;&nbsp;<input type="text" name="quantity" value="<%=product.getQuantity() %>"/><br>
图片：&nbsp;&nbsp;<input type="text" name="img" value="<%=product.getImg() %>"/><br>
<img src="img/<%=product.getImg() %>" width="320" height="280"/><br>
描述：&nbsp;&nbsp;<textarea name="desc" cols="50" rows="5" <%=product.getDesc() %>/></textarea><br>
&nbsp;&nbsp;<input type="submit" value="添加"/>
&nbsp;&nbsp;<input type="reset" value="取消"/>
</form>
  </body>
</html>
