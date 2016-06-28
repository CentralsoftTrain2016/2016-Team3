<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="service.bean.RegistBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新規登録</title>
<link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>
<div align="center">
<h>ユーザーアカウントを新規作成します。新規IDと名前を入力してください。</h>
<br>
<form  method="POST" action="RegistUserServlet"><br>

<style>
.table2 {
  width: 400px;
}
.table2 th {
  background-color: #cccccc;
}
</style>
<table class="table2">
 <tr><th>ID</th><td><input name="userID" type="text" ></td></tr>
  <tr><th>パスワード</th><td><input name="password" type="text" ></td></tr>
  <tr><th>名前</th><td><input name="name" type="text" ></td></tr>
  <tr><th>トレーナー1</th><td><input name="trainerAID" type="text" ></td></tr>
  <tr><th>トレーナー2</th><td><input name="trainerBID" type="text" ></td></tr>
   <tr><th>部署</th><td><input name="departmentID" type="radio" value="1" checked>第一事業本部
   <input name="departmentID" type="radio" value="2">第二事業本部</td></tr>
   <tr><th>メールアドレス</th><td><input name="mailAddress" type="text" ></td></tr>
</table>
  <input type="submit" value="登録" onClick="func('regist')" class="regist1">
  <input type="button" value="戻る" onClick="history.back()" class="regist2">
<br>
	<font color ="#ff0000"><%=bean.getMessage() %></font><br>

</form>
</div>
</body>
</html>