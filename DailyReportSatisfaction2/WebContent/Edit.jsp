<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="service.bean.EditBean" scope="request" />
<%@ page import="domain.Point"%>
<%@ page import="domain.Config"%>
<%@ page import="domain.Draft"%>
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
#accordion {
	width: 100%;
	height: 250px;
	border: 0px solid #98fb98;
	padding: 0px;
}

.Tab {
	float: left;
	background-color: #00b51e;
	display: block;
	height: 80%;
	width: 15px;
	color: #000000;
	cursor: pointer;
	padding: 150px 0px 0px 0px;
	margin-right: 1px;
	font-weight: bold;
}

.Tab_child {
	height: 88%;
	width: 50%;
	float: left;
	overflow: hidden;
	color: black;
	display: none;
	overflow: hidden;
	line-height: 1.5;
	text-align: left;
	padding: 1%;
	background-color: #ff00AA;
	font-weight: normal;
	position: absolute;
	top: 4.5px;
	left: 20px;
}

#sortable-table {
	width: 50%;
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
document.getElementById(TabID1).style.backgroundColor = '#cc0099';
opnTab(TabID);
document.getElementById(TabID).style.display='block';
}

else{
picup= TabID.substr(TabID.length-2,2);
TabID1="tab_parent"+picup;
document.getElementById(flag_bgclr).style.backgroundColor = '#00b51e';
document.getElementById(TabID1).style.backgroundColor = '#cc0099';
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
document.getElementById(flag_bgclr).style.backgroundColor = '#00b51e';
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
i= Math.ceil(i*2);
if(i>TabH){ i=TabH;}
document.getElementById(TabID).style.width= i+"px";
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
</head>
<body>
	<h></h>

	<table border="0" width="100%" height="20" bgcolor="#A4A4A4"
		style="table-layout: fixed">
		<tr>
			<td>ここにはメール画像ボタンとか更新マークのボタンとか</td>
		</tr>
	</table>

	<table border="1" width="100%" height="100%" bgcolor="#F2F2F2"
		style="table-layout: fixed; position: relative;">
		<tbody>
			<tr>

				<td><div id="accordion">
						ここにメールの受信したやつ一覧

						<div class="Tab" id="tab_parent01" onclick="Myshow('Tab01')">
							<tt>▲</tt>
						</div>
						<div class="Tab_child" id="Tab01">
							ここには指摘内容のメモ！ <br>
							<% for (Point point : bean.getPointList()) { %>
								<%= point.getPoint() %><br>
							<%}%>



			<form method="POST" action="EditPointAddServlet">
				メモ入力エリア：<input type="text" name="point"
					style="width: 200px; height: 50px;"><br> <input
					type="submit" value="保存">
			</form>
			</div>
			</div>
			</td>
			<td rowspan=2>
				<table border="1" width="100%" height="100%">
					<tr>
						<td rowspan=1 width="5px" height="5px">
							<form method="GET" action="EditPreviewServlet">
								<input type="submit" value="ぷれびゅ">＋－....<a
									href="Config.jsp"><img
									src="https://dl.dropboxusercontent.com/u/65199078/config.png"
									alt="サンプル"></a>

						</td>
					</tr>
					<tr>
						<td rowspan=1 width="5px" height="5px">送信者：<%=bean.getName().getName() %></td>
					</tr>
					<tr>
						<td rowspan=1 width="5px" height="5px">あて先：
							CSS_2016trainer@central-soft.co.jp</td>
					</tr>
					<tr>
						<td rowspan=1 height="5px">件名： //自動生成するところ</td>
					</tr>
					<tr>
						<td rowspan=1 width="100px" height="5px"><br>
							<table id="sortable-table" border="0" width="100%" height="100%">
								<tbody id = "list">
									<%int i = 0;%>
									<%String input1 = "<input type=\"";%>
									<%String input2 = "\" name=\"";%>
									<%String input3 = "\" value=\"";%>
									<%String input4 = "\" style=\"width: 100px; height: 50px;\">";%>
									<%String input5 = "\" >";%>
									<%List<Draft> drafts = bean.getDrafts();%>
									<%String temp = drafts.get(0).getTemplateID();%>

									<% for(Draft draft: drafts) {%>
									<% i++;%>
									<tr class="sortable-tr" height="10%">
									<td>
									<%-- アイテムテキスト --%>
									<%=draft.getItemName() %><br>
									<%=input1 %>text<%=input2 %>text<%=i %><%=input3 %><%=draft.getText() %><%=input4 %>
									</td>

									</tr>
									<%-- ドラフトID --%>
									<%=input1 %>hidden<%=input2 %>draftID<%=i %><%=input3 %><%=draft.getDraftID() %><%=input5 %>
									<% } %>
									<%--アイテム個数 --%>
									<%=input1 %>hidden<%=input2 %>cnt<%=input3 %><%=i %><%=input5 %>
									<%--テンプレID --%>
									<%=input1 %>hidden<%=input2 %>templateID<%=input3 %><%=temp %><%=input5 %>
								</form>
								<% for (Config configs : bean.getConfigList()) { %>
								<%= configs.getSignature().getSignature() %><br>
							<%}%>
							</tbody>
							</table>
						</td>
					</tr>
				</table>
			</td>
			</tr>
		</tbody>
	</table>
</body>
</html>