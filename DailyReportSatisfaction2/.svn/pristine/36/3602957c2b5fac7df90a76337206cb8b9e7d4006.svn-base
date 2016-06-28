<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.EditBean" scope="request" />
<%@ page import="domain.ReceiveMail"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ここはメール一覧表示するところ</title>
<link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>

	<%
		for (ReceiveMail receiveMail : bean.getReceiveMailList()) {
	%>
	<div class="mt"><a href="MailTextServlet?recieveMailId=<%=receiveMail.getRecieveMailId()%>" target= "C" >
	<%=receiveMail.getTitle()%></a></div>
	<%
		}
	%>

</body>
</html>