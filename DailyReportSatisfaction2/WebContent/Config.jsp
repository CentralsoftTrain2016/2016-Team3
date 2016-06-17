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
</head>
<body>
	<table border="0" width="100%" height="20" bgcolor="#A4A4A4"
		style="table-layout: fixed">
		<tr>
			<td><form  method="GET" action="EditServlet"><button>編集画面へ</button></form></td>
		</tr>
	</table>

	<table border="1" width="100%" height="100%" bgcolor="#F2F2F2"
		style="table-layout: fixed; position: relative;">
		<tbody>
			<tr>
						<tr>
							<td rowspan=1 width="5px" height="5px">
									<div class="tab">
											<div class="tabbox">
													<p class="tabs">
														<a onclick="ChangeTab('tab1'); return false;" class="tab1" href="#tab1">担当トレーナ</a>
														<a onclick="ChangeTab('tab2'); return false;" class="tab2" href="#tab2">研修の目標</a>
														<a onclick="ChangeTab('tab3'); return false;" class="tab3" href="tab3">テンプレート</a>
														<a onclick="ChangeTab('tab4'); return false;" class="tab3" href="tab4">振り分け</a>
														<a onclick="ChangeTab('tab5'); return false;" class="tab3" href="tab5">署名</a>
														<a onclick="ChangeTab('tab6'); return false;" class="tab3" href="tab6">ユーザ削除</a>
														<a onclick="ChangeTab('tab7'); return false;" class="tab3" href="tab7">パスワード変更</a>
													</p>
													<div class="tab" id="tab1">
														<p><center>
															<br>
															担当トレーナ設定
															<br><br>
															<form  method="POST" action="Servlet">
																	<div id="table">
																			<div class="tableRow">
																					<div>
																						トレーナA
																					</div>
																					<div>
																						<input type="text" name="trainerA"style="width: 200px; height: 25px;">
																					</div>
																				</div>
																				<div class="tableRow">
																					<div>
																						トレーナB
																					</div>
																					<div>
																						<input type="text" name="trainerB"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																	</div>
																	<input type="submit" value="保存">
															</form>
														</p></center>
													</div>
													<div class="tab" id="tab2">
														<p><center>
															<br>
															研修の目標設定
															<br><br>
															<form  method="POST" action="Servlet">
																	<div id="table">
																			<div class="tableRow">
																					<div>
																						コミュニケーションについて
																					</div>
																					<div>
																						<input type="text" name="comyu"style="width: 200px; height: 25px;">
																					</div>
																				</div>
																				<div class="tableRow">
																					<div>
																						達成基準
																					</div>
																					<div>
																						<input type="text" name="comyuGoal"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						仕事の進め方について
																					</div>
																					<div>
																						<input type="text" name="work"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						達成基準
																					</div>
																					<div>
																						<input type="text" name="workGoal"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						技術的な事について
																					</div>
																					<div>
																						<input type="text" name="skill"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						達成基準
																					</div>
																					<div>
																						<input type="text" name="skillGoal"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																	</div>
																	<input type="submit" value="保存">
															</form>
														</p></center>
													</div>
													<div class="tab" id="tab3">
														<p><center>
														<br>
															テンプレート設定
															<br><br>
															<form  method="POST" action="Servlet">
																	<div id="table">
																			<div class="tableRow">
																					<div>
																						曜日
																					</div>
																					<div>
																						<select  name="weekDay">
																								<option value="normal">通常</option>
																								<option value="mon">月</option>
																								<option value="fri">金</option>
																						</select>
																					</div>
																				</div>
																				<div class="tableRow">
																					<div>
																						終了日（yyyy/mm/dd）
																					</div>
																					<div>
																						<input type="text" name="period"style="width: 200px; height: 25px;">
																					</div>
																				</div>
																		</div>


																		<div id="table">
																			<div class="tableRow">
																					<div>
																						●大項目
																					</div>
																					<div>
																						<input type="text" name="item1"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem1_1"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem1_2"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem1_3"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem1_4"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem1_5"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																	</div>

																	<div id="table">
																			<div class="tableRow">
																					<div>
																						●大項目
																					</div>
																					<div>
																						<input type="text" name="item2"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem2_1"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem2_2"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem2_3"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem2_4"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem2_5"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																	</div>

																	<div id="table">
																			<div class="tableRow">
																					<div>
																						●大項目
																					</div>
																					<div>
																						<input type="text" name="item3"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem3_1"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem3_2"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem3_3"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem3_4"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem3_5"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																	</div>

																	<div id="table">
																			<div class="tableRow">
																					<div>
																						●大項目
																					</div>
																					<div>
																						<input type="text" name="item4"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem4_1"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem4_2"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem4_3"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem4_4"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						・小項目
																					</div>
																					<div>
																						<input type="text" name="subItem4_5"style="width: 140px; height: 25px;">
																					</div>
																			</div>
																	</div>

																	<input type="submit" value="保存">
															</form>
														</p></center>
													</div>
													<div class="tab" id="tab4">
														<p><center>
														<br>
															振り分け設定
															<br><br>
															<form  method="POST" action="Servlet">
																	<div id="table">
																			<div class="tableRow">
																					<div>
																						名前（苗字）
																					</div>
																					<div>
																						<input type="text" name="name"style="width: 200px; height: 25px;">
																					</div>
																			</div>
																	</div>
																	<input type="submit" value="保存">
															</form>
														</p></center>
													</div>
													<div class="tab" id="tab5">
														<p><center>
														<br>
															署名設定
															<br><br>
															<form  method="POST" action="Servlet">
																	<div id="table">
																			<div class="tableRow" >
																					<div>
																						署名
																					</div>
																					<div>
																						<textarea name="sign" cols=40 rows=4></textarea>
																					</div>
																			</div>
																	</div>
																	<input type="submit" value="保存">
															</form>
														</p></center>
													</div>
													<div class="tab" id="tab6">
														<p><center>
														<br>
															ユーザ削除
															<br><br><br><br>
															ログイン中のユーザIDを削除しますか？
															<br><br>
															<form  method="POST" action="Servlet">
																	<input type="submit" value="OK">
															</form>
														</p></center>
													</div>
													<div class="tab" id="tab7">
														<p><center>
														<br>
															パスワード設定
															<br><br>
															<form  method="POST" action="Servlet">
																	<div id="table">
																			<div class="tableRow">
																					<div>
																						現在のパスワード
																					</div>
																					<div>
																						<input id = "textBox" name = "nowPass" type="password">
																					</div>
																				</div>
																				<div class="tableRow">
																					<div>
																						新しいパスワード
																					</div>
																					<div>
																						<input id = "textBox" name = "newPass1" type="password">
																					</div>
																			</div>
																			<div class="tableRow">
																					<div>
																						もう一度入力
																					</div>
																					<div>
																						<input id = "textBox" name = "newPass2" type="password">
																					</div>
																			</div>
																	</div>
																	<input type="submit" value="変更">
															</form>
														</p></center>
													</div>
											</div>
									</div>
										<script type="text/javascript">
											ChangeTab('tab1');
										</script>
							</td>
						</tr>
			</tr>
		</tbody>
	</table>
</body>
</html>