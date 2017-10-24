<%@ page language="java"  pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>用户注册</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="css/styles.css">

	</head>

	<body>
		<center>

			<table>

				<tr>
					<td height="260" valign="top">

						<form action="servlet/DoReg" method="post">
							<table>
					
								<tr>
									<td>
										用户名：
									</td>
									<td>
										<input type="text" name="name">
									</td>
								</tr>
								<tr>
									<td>
										密 码：
									</td>
									<td>
										<input type="password" name="pass">
									</td>
								<tr>
									<td>
										确认密码：
									</td>
									<td>
										<input type="password" name="pass2">
									</td>
								</tr>
								<tr>
									<td>
										Email:
									</td>
									<td>
										<input type="text" name="email">
									</td>
								</tr>
								<tr>
									<td>
										地址：
									</td>
									<td>
										<input type="text" name="address">
									</td>
								</tr>
								<tr>
									<td>
										电话：
									</td>
									<td>
										<input type="text" name="tel">
									</td>
								</tr>
								<tr>
									<td colspan="2" align="center">
										<input type="submit" value="注册">
										&nbsp;
										<input type="reset" value="重置">
									</td>
								</tr>
							</table>
						</form>

					</td>
				</tr>
				
			</table>
		</center>
	</body>
</html>