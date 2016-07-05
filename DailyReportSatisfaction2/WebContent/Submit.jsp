<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	<title>設定ページ</title>
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

	#table {
	                display:table;
	                }
	            .tableRow {
	                display:table-row;
	                }
	            .tableRow>div {
	                display:table-cell;
	                margin:10px;
	                padding:10px;
	            }

	/* 表示領域全体 */
			div.tab div.tabbox { margin: 0px; padding: 0px; width: 1205px; hight: 100px; }
			/* タブ部分 */
			div.tab p.tabs { margin: 0px; padding: 0px; }
			div.tab p.tabs a { display: block; width: 8em; float: left; margin: 0px 5px 0px 0px; padding: 5px; text-align: center; border-radius: 12px 12px 0px 0px; }
			div.tab p.tabs a.tab1 { border: 2px solid #555555; background-color: #bbbbbb;  color: black; }
			div.tab p.tabs a.tab2 { border: 2px solid #555555; background-color: #bbbbbb; color: black; }
			div.tab p.tabs a.tab3 { border: 2px solid #555555; background-color: #bbbbbb;   color: black; }
			div.tab p.tabs a.tab4 { border: 2px solid #555555; background-color: #bbbbbb;   color: black; }
			div.tab p.tabs a.tab5 { border: 2px solid #555555; background-color: #bbbbbb;   color: black; }
			div.tab p.tabs a.tab6 { border: 2px solid #555555; background-color: #bbbbbb;   color: black; }
			div.tab p.tabs a.tab7 { border: 2px solid #555555; background-color: #bbbbbb;   color: black; }
			div.tab p.tabs a:hover { color: yellow; text-decoration: underline; }
			/* 対応表示領域 */
			div.tab div.tab { height: 400px; overflow: auto; clear: left; }
			div.tab div#tab1 { border: 2px solid black;  background-color: #F2F2F2; }
			div.tab div#tab2 { border: 2px solid black; background-color: #F2F2F2; }
			div.tab div#tab3 { border: 2px solid black;   background-color: #F2F2F2; }
			div.tab div#tab4 { border: 2px solid black;   background-color: #F2F2F2; }
			div.tab div#tab5 { border: 2px solid black;   background-color: #F2F2F2; }
			div.tab div#tab6 { border: 2px solid black;   background-color: #F2F2F2; }
			div.tab div#tab7 { border: 2px solid black;   background-color: #F2F2F2; }
			div.tab div.tab p { margin: 0.5em; }
			/* 装飾（今回のテクニックとは無関係） */
			div.tab div.tab ul, div.tab ol { margin-top: 0.5em; margin-bottom: 0.5em; }
			div.tab div.tab li { line-height: 1.35; margin-bottom: 0px; margin-top: 0px; }
			div.tab div.tab p.tabhead { font-weight: bold; border-bottom: 3px double gray; }


	</style>



	<style>
	#sortable-table {
		width: 50%;
		border-collapse: collapse;
	}

	#sortable-table td, #sortable-table th {
		border: solid 1px black;
	}
	</style>
	 <%-- タブの実現 --%>
	<script type="text/javascript">
	function ChangeTab(tabname) {
	   // 全部消す
	   document.getElementById('tab1').style.display = 'none';
	   document.getElementById('tab2').style.display = 'none';
	   document.getElementById('tab3').style.display = 'none';
	   document.getElementById('tab4').style.display = 'none';
	   document.getElementById('tab5').style.display = 'none';
	   document.getElementById('tab6').style.display = 'none';
	   document.getElementById('tab7').style.display = 'none';
	   // 指定箇所のみ表示
	   document.getElementById(tabname).style.display = 'block';
	}
	</script>



	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="CSS.css">
</head>

<body>
	<table border="0" width="100%" height="20" bgcolor="#A4A4A4"
		style="table-layout: fixed">
		<tr>
			<td></td>
		</tr>
	</table>

	<table border="1" width="100%" height="100%" bgcolor="#F2F2F2"
		style="table-layout: fixed; position: relative;">
		<tbody>
			<tr>
				<td rowspan=1 width="5px" height="5px">
					<center>
						<br><br>
						送信が完了しました。<br>
						本日もお疲れ様でした。<br>
						また明日も頑張りましょう。<br>
						<br><br>
						<form  method="POST" action="Login.jsp" target="_parent">
							<input type="submit" value="ログアウト">
							<br><br>
						</form>
					</center>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>