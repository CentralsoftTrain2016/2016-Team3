package service;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.ListQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.client.spreadsheet.WorksheetQuery;
import com.google.gdata.data.spreadsheet.CustomElementCollection;
import com.google.gdata.data.spreadsheet.ListEntry;
import com.google.gdata.data.spreadsheet.ListFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;

import domain.Draft;
import domain.valueo.Goal;
import domain.valueo.Purpose;
import domain.valueo.UserID;
import service.bean.GoalBean;

public class GoogleSheetService extends Service {

	@Override
	void prePare() {
		// TODO 自動生成されたメソッド・スタブ

	}
	// 目標・目的取得
	public GoalBean getGoal(String sheetName, UserID userID) {
		GoalBean bean = new GoalBean();
		bean.setGoal(new Goal("NULL"));
		bean.setPurpose(new Purpose("NULL"));
		URL SPREADSHEET_FEED_URL;
		try {
			SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
			// サービスアカウントメールアドレス
			String ACCOUNT_ID = "tatsuya-nakama@model-osprey-133506.iam.gserviceaccount.com";
			/*
			 * P12キー TomCatの作業フォルダがC:\a\pleiades\eclipse\だから それにあわせて変更する必要がある
			 * 現在はローカルの場合で合わせてる
			 */
			File p12 = new File("../workspace/DailyReportSatisfaction2/WebContent/WEB-INF/My Project-6af2244f80b5.p12");
			// サーバ上の場合
			// File p12 = new
			// File("./webapps/DailyReportSatisfaction2/WEB-INF/My
			// Project-6af2244f80b5.p12");

			HttpTransport httpTransport = new NetHttpTransport();
			JacksonFactory jsonFactory = new JacksonFactory();
			String[] SCOPESArray = { "https://spreadsheets.google.com/feeds",
					"https://spreadsheets.google.com/feeds/spreadsheets/private/full",
					"https://docs.google.com/feeds" };
			final List SCOPES = Arrays.asList(SCOPESArray);
			// 認証情報
			GoogleCredential credential = null;

			credential = new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory)
					.setServiceAccountId(ACCOUNT_ID).setServiceAccountScopes(SCOPES)
					.setServiceAccountPrivateKeyFromP12File(p12).build();

			// リフレッシュトークン 必要ある？
			// credential.refreshToken();
			SpreadsheetService service = new SpreadsheetService("Mokuhyo");

			// 認証かける
			service.setOAuth2Credentials(credential);

			// 名前を指定してシート取得
			FeedURLFactory urlFactory = FeedURLFactory.getDefault();
			SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(urlFactory.getSpreadsheetsFeedUrl());

			// シート名
			String sheet = sheetName;
			spreadsheetQuery.setTitleQuery("日報満足目標管理シート");
			SpreadsheetFeed spreadsheetFeed = null;
			spreadsheetFeed = service.query(spreadsheetQuery, SpreadsheetFeed.class);
			SpreadsheetEntry spreadsheetEntry = spreadsheetFeed.getEntries().get(0);

			// 名前を指定してワークシートを取得
			URL url = spreadsheetEntry.getWorksheetFeedUrl();
			WorksheetQuery query = new WorksheetQuery(url);
			query.setTitleQuery("目標");
			WorksheetFeed feed = null;
			feed = service.query(query, WorksheetFeed.class);
			List<WorksheetEntry> worksheetEntryList = feed.getEntries();
			WorksheetEntry worksheetEntry = worksheetEntryList.get(0);

			// ワークシート内を検索
			// 日付取得
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String day = sdf.format(dt);
			// ユーザＩＤ
			String id = userID.getUserID();
			id = "CS-362";
			ListQuery listQuery = new ListQuery(worksheetEntry.getListFeedUrl());
			listQuery.setSpreadsheetQuery("日付 = \"" + day + "\" && ユーザid = \"" + id + "\"");

			ListFeed listFeed = null;

			listFeed = service.query(listQuery, ListFeed.class);

			ListEntry listEntry = listFeed.getEntries().get(0);
			CustomElementCollection elements = listEntry.getCustomElements();

			Goal goal = new Goal(elements.getValue("本日の目標"));
			Purpose purpose = new Purpose(elements.getValue("目的"));
			bean.setGoal(goal);
			bean.setPurpose(purpose);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ServiceException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return bean;
	}

	// 下書きに目標・目的を適用する
	public List<Draft> setGoal(List<Draft> drafts, UserID userID) {
		GoalBean bean = new GoalBean();
		boolean goalFlag = true;
		for (Draft draft : drafts) {
			// 目標目的が含まれていたらスプレッドシートから取得してくる（初回のみ）
			if (draft.getSheetTab() != null && goalFlag) {
				try {
					bean = this.getGoal(draft.getSheetTab(), userID);
				} catch (RuntimeException e) {
					bean.setGoal(new Goal("スプレッドシートを取得できませんでした。"));
					bean.setPurpose(new Purpose("スプレッドシートを取得できませんでした。"));
				}
				goalFlag = false;
			}

			// 目標目的のセット
			if (draft.getType() != null && draft.getType().equals("目標")) {
				draft.setText(bean.getGoal().getGoal());
			} else if (draft.getType() != null && draft.getType().equals("目的")) {
				draft.setText(bean.getPurpose().getPurpose());
			}
		}
		return drafts;
	}


}
