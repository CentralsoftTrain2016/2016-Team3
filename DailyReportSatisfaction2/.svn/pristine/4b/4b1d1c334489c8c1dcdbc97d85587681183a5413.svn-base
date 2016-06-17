<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="bean" class="service.bean.PreviewBean" scope="request" />
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/ui-lightness/jquery-ui.css">
<link rel="stylesheet" href="/css/demo.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
<script src="/js/demo.js"></script>


<title>プレビューjsp</title>
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
	<table border="1" width="50%" height="100%" bgcolor="#F2F2F2"
		style="table-layout: fixed; position: relative;">
		<tr>
			<td>
				<table>
					<tr>
						<td>
							<h1>&nbsp;&nbsp;&nbsp;プレビュー&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h1>
						</td>
						<td>
						<%request.setAttribute("drafts",bean.getDraft()); %>
							<form method = "POST" action = "PreviewEditServlet">
								<input type = submit value = 編集 style="width:100px">
								<input type = hidden name = "sender" value = <%= bean.getSender()%> >
								<input type = hidden name = "destination" value = <%= bean.getDestination() %> >
								<input type = hidden name = "title" value = <%= bean.getTitle().getTitle() %> >
								<input type = hidden name = "text" value = <% %> >

							</form>
						</td>
						<td>
							<form method = "POST" action = "Submit.jsp">
								<input type = submit value = 送信 style="width:100px">
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tbody>
			<tr>
				<td rowspan=2>

					<table border="1" width="100%" height="100%">
						<tr>
							<td rowspan=1 width="5px" height="5px">送信者：
								<%= bean.getSender().getSender() %>
							</td>
						</tr>
						<tr>
							<td rowspan=1 width="5px" height="5px">宛先：
								<%= bean.getDestination().getDestination() %>
							</td>
						</tr>
						<tr>
							<td rowspan=1 height="5px">件名：
								<%= bean.getTitle().getTitle() %>
							</td>
						</tr>
						<tr>
							<td>
								<%for(domain.Draft draft:bean.getDraft()){ %>
									<%=draft.getItemName()%><br>
									<%=draft.getText()%><br>
									<br>
								<%} %>
							</td>
						</tr>
					</table>

					<table>
						<tr>
							<td>
								<form method = "POST" action = "Edit.jsp"><br>
									<input type = submit value = 作成に戻る style="width:100px">
								</form>
							</td>
						</tr>
					</table>

				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>