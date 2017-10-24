<%@ page language="java" import="java.util.*,beans.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete.jsp' starting page</title>
    
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
   <jsp:useBean id="pd" class="beans.ProductDao" scope="session" />
  <%
  String id=request.getParameter("id");
Product product=null;
product=pd.getProduct(id);
   %>
    <form action="servlet/DeleteServlet" method="post">
<table border="1">
<tr><th>商品删除</th></tr>
<tr><td>商品名称</td><td><input type="text" name="name" value="<%=product.getName() %>"/></td></tr>
<tr><td><input type="submit" value="删除">&nbsp;
			<input type="reset" value="重置"><a href="product_list.jsp">返回上一层</a></td></tr>
			
</table>
</form>
  </body>
</html>
