<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.LoginBean" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>ログイン</title>
	<link rel="stylesheet" type="text/css" href="CSS.css">
</head>

<body>
	<br>
	<div align="center">
		<img src="日報満足.png" width="414.5" height="224.5" alt="日報満足">
		<form method="GET" action="LoginCheckServlet">
			<table border="0">
				<tr>
					<td><b>ユーザID:</b></td>
					<td><input name="userID" type="text" class="textLogin"></td>
				</tr>
				<tr>
					<td><b>パスワード:</b></td>
					<td><input name="password" type="text" class="textLogin"></td>
				</tr>
			</table>
			<input type="submit" value="ログイン" class="login">
		</form>
		<form method="get" action="RegistServlet">
			<input type="submit" value="新規登録" class="newRegist">
		</form>

		<%if(bean.getMessage() != null){%>
		<font color="#ff0000"><%=bean.getMessage()%></font> <br> <br>
		<%}%>
	</div>
</body>
</html>
