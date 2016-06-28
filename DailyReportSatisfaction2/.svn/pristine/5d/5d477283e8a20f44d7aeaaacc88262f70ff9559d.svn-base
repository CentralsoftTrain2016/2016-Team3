<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.EditBean" scope="request" />
<%@ page import="domain.Point"%>
<%@ page import="domain.Config"%>
<%@ page import="domain.Draft"%>
<%@ page import="domain.ReceiveMail"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/ui-lightness/jquery-ui.css">
<link rel="stylesheet" href="/css/demo.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/demo.js"></script>


<title>編集jsp</title>
<style type="text/css">
<!--
html, body {
  height: 100%;
}

#box1 {
  height: 100%;
}
body {
	overflow: hidden;
}
.memo{
overflow: hidden;

}
#accordion {
	width: 100%;
	height: 100%;
	border: 0px solid #FFFF99;
	padding: 0%;
}

.Tab {
	float: left;
	background-color: #99FF66;
	height: 100%;
	width: 3.3%;
	color: #FFCCCC;
	cursor: pointer;
	padding: 1% 0px 0px 1px;
	margin-right: 0px;
}

.Tab_child {
	height: 100vh;
	width: 100%;
	float: left;
	display: none;
	overflow: scroll;
	line-height: 1.5;
	text-align: left;
	padding: 1%;
	background-color: #FFFF99;
	font-weight: normal;
	position: absolute;
	top: 1px;
	left: 15px;
}

#sortable-table {
	width: 100%;
	border-collapse: collapse;
}

#sortable-table td, #sortable-table th {
	border: solid 1px black;
}
-->
</style>

<script type="text/javascript">
<!--
var i=1;
var v;
var flag ="Tab00";
var toggle = "cls";
var flag_bgclr;

function Myshow(TabID){
TabH = 250;
if(flag==TabID && toggle == "cls"){sameTab(TabID,TabH);return;}
if(flag =="Tab00"){
picup= TabID.substr(TabID.length-2,2);
TabID1="tab_parent"+picup;
document.getElementById(TabID1).style.backgroundColor = '#99FF66';
opnTab(TabID);
document.getElementById(TabID).style.display='block';
}

else{
picup= TabID.substr(TabID.length-2,2);
TabID1="tab_parent"+picup;
document.getElementById(flag_bgclr).style.backgroundColor = '#99FF66';
document.getElementById(TabID1).style.backgroundColor = '##99FF66';
opnTab(TabID);
document.getElementById(TabID).style.display='block';
if(toggle=="cls"){document.getElementById(flag).style.display='none';}
}
flag=TabID;
picup= flag.substr(flag.length-2,2);
flag_bgclr="tab_parent"+picup;
toggle="cls";
}

function sameTab(TabID){
picup= TabID.substr(TabID.length-2,2);
TabID1="tab_parent"+picup;
document.getElementById(flag_bgclr).style.backgroundColor = '#99FF66';
toggle="opn";
clsTab(TabID);
}

function clsTab(TabID){
if(v==1){
i=1;v=5000;document.getElementById(flag).style.display='none';return
}
i= Math.ceil(i*5);
v=TabH-i;
if(v<0){v=1}
document.getElementById(TabID).style.width= v+"px";
timer=setTimeout("clsTab('"+TabID+"')",1);
}

function opnTab(TabID){
	if(i>=TabH){ i=1;return}
	i= Math.ceil(i*5);
	if(i>TabH){ i=TabH;}
	document.getElementById(TabID).style.width= i*1.5-5+"px";
	timer=setTimeout("opnTab('"+TabID+"')",1);
	}

// -->

</script>

<style>
#sortable-table {
	width: 50%;
	border-collapse: collapse;
}

#sortable-table td, #sortable-table th {
	border: solid 1px black;
}
</style>
<script>
		$(function() {
			$('#sortable-table tbody').sortable({
				helper : helper1,
				cursor : "move",
				opacity : 0.5
			});
		});
		function helper1(e, tr) {
			var $originals = tr.children();
			var $helper = tr.clone();
			$helper.children().each(function(index) {
				$(this).width($originals.eq(index).width());
			});
			return $helper;
		}
	</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>
	<div id="accordion" style="table-layout: fixed; position: relative;">
	<%
		for (ReceiveMail receiveMail : bean.getReceiveMailList()) {
	%>
<%=receiveMail.getText()%>
	<%
		}
	%>
		<div class="Tab" id="tab_parent01" onclick="Myshow('Tab01',100)">
			<tt><img src="▲マーク.png" width="100%" height="width" alt="▲マーク"></tt>
		</div>
		<div class="Tab_child" id="Tab01">
			ここには指摘内容のメモ！

			<form method="POST"  action="EditPointDeleteServlet" >


				<% for (Point point : bean.getPointList()) {
					%><input type="radio" name="pointID" value="<%= point.getPointID()%>"><%= point.getPoint() %><br><%
				}%>

			<input type="submit" value="削除">
			</form>
			<form method="POST"  action="EditPointAddServlet" >
			<input type="submit" value="保存">
			<textarea name="point" class="memo"></textarea><br>
					<br>
			</form>
		</div>
	</div>





</body>
</html>