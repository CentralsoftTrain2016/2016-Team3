<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="message" class="java.lang.String" scope="request" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
	<h>ログイン</h>
	<br>
	<div align="center">
	<img src="日報満足.png" width="414.5" height="224.5" alt="日報満足">
		<form method="GET" action="LoginServlet">
			<p> ユーザーID： <input name="userID" type="text"> </p>
			<p>パスワード： <input name="password" type="text"> </p>
			<input	type="submit" value="ログイン">
		</form>
		<font color ="#ff0000"><%=message %> </font>
		<br> <br>
	</div>
</body>
</html>
