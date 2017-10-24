<%@ page language="java" import="java.util.*,beans.LoginBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginAction.jsp' starting page</title>
    
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
    <%request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<jsp:useBean id="ud" class="beans.UserDao" scope="session" />
<%
  boolean flag=ud.check_login(user);
  if(flag){
    session.setAttribute("name", user.getName());
    response.sendRedirect("index.jsp");
    return;
    }else{
        response.sendRedirect("faile.jsp");
       }
   %> 
  </body>
</html>
