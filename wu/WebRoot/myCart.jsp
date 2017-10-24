<%@ page language="java" import="java.util.*,beans.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myCart.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
<% float total=0;  
    Vector<CartProduct> cart=(Vector<CartProduct>)session.getAttribute("cart");
    if(cart==null||cart.size()==0){
    %>
         <h2>你的购物车为空，<a href="product.jsp">单击此处选购商品</a></h2>
   <% }else{  
   for(int i=0;i<cart.size();i++){
         CartProduct cp=cart.get(i);
   %>
         <form action="servlet/EdiCart?id=<%=cp.getId() %>" method="post">
     <table border="1">
     <tr>
     <td width="100"><%=cp.getName() %></td> <td width="100"><%=cp.getPrice() %></td>
     <td width="100"><input type="text" name="number" value="<%=cp.getNumber() %>"></td>
     <td width="150"><form action="servlet/EdiCart?id=<%=cp.getId() %>" method="post">
<input type="submit" value="编辑">
</form>

     <a href="servlet/DelCart?id=<%=cp.getId() %>">删除商品</a> </td> </tr> </table>
      </form>
   <%
        total+=cp.getPrice()*cp.getNumber();
      }
     }  %>     <br>总价值：<%=total %>元    <br> <a href="product.jsp">继续购物</a>

  
  <body>



  </body>
</html>
