package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.sql.SQLException;
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

import db.ConfigDao;
import db.DraftDao;
import db.MailDao;
import db.PointDao;
import domain.Config;
import domain.Draft;
//import db.TemplateDao;
import domain.Point;
import domain.valueo.DepartmentID;
import domain.valueo.DraftID;
import domain.valueo.Goal;
import domain.valueo.Name;
import domain.valueo.Purpose;
import domain.valueo.TemplateID;
import domain.valueo.Text;
import domain.valueo.UserID;
import domain.valueo.WeekDay;
import service.bean.GoalBean;

public class EditService extends Service {
	private MailDao mdao;
	// private TemplateDao tdao;
	private ConfigDao cdao;
	private PointDao pdao;
	private DraftDao ddao;

	@Override
	void prePare() {
		this.mdao = new MailDao(this.con);
		// this.tdao = new TemplateDao(this.con);
		this.cdao = new ConfigDao(this.con);
		this.pdao = new PointDao(this.con);
		this.ddao = new DraftDao(this.con);
	}
	/*
	 * // めーるしゅとく public List<Mail> getMail(String userId) { List<Mail> mailList
	 * = new ArrayList<Mail>(); try { mailList = mdao.getMail(userId); } catch
	 * (SQLException e) { throw new RuntimeException(e); } return mailList; }
	 */

	// 編集サービス テンプレートの読み込み
	/*
	 * public List<Template> getTemplate() { List<Template> template; try {
	 * template = tdao.getTemplate(); } catch (SQLException e) { throw new
	 * RuntimeException(e); } return template; }
	 */

	// 指摘事項の読み込み
	public List<Point> getPoint(UserID userID) {
		List<Point> template;
		try {
			template = pdao.getPoint(userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return template;
	}

	// 設定の読み込み
	public List<Config> getConfig(UserID userID) {
		List<Config> configList;
		try {
			configList = cdao.getConfig(userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return configList;
	}

	// 目標・目的取得
	public GoalBean getGoal(Name userName) {
		URL SPREADSHEET_FEED_URL;
		try {
			SPREADSHEET_FEED_URL = new URL("https://spreadsheets.google.com/feeds/spreadsheets/private/full");
		} catch (MalformedURLException e4) {
			// TODO 自動生成された catch ブロック
			e4.printStackTrace();
		}

		// サービスアカウントメールアドレス
		String ACCOUNT_ID = "tatsuya-nakama@model-osprey-133506.iam.gserviceaccount.com";
		/*
		 * P12キー TomCatの作業フォルダがC:\a\pleiades\eclipse\だから それにあわせて変更する必要がある
		 * 現在はローカルの場合で合わせてる
		 */
		File p12 = new File("../workspace/DailyReportSatisfaction2/WebContent/WEB-INF/My Project-6af2244f80b5.p12");

		HttpTransport httpTransport = new NetHttpTransport();
		JacksonFactory jsonFactory = new JacksonFactory();
		String[] SCOPESArray = { "https://spreadsheets.google.com/feeds",
				"https://spreadsheets.google.com/feeds/spreadsheets/private/full", "https://docs.google.com/feeds" };
		final List SCOPES = Arrays.asList(SCOPESArray);
		// 認証情報
		GoogleCredential credential = null;
		try {
			credential = new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory)
					.setServiceAccountId(ACCOUNT_ID).setServiceAccountScopes(SCOPES)
					.setServiceAccountPrivateKeyFromP12File(p12).build();
		} catch (FileNotFoundException e) {
			GoalBean bean = new GoalBean();
			Goal goal = new Goal("認証キーが見つかりませんでした。");
			bean.setGoal(goal);
			return bean;
		} catch (GeneralSecurityException e3) {
			// TODO 自動生成された catch ブロック
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO 自動生成された catch ブロック
			e3.printStackTrace();
		}
		// リフレッシュトークン 必要ある？
		// credential.refreshToken();
		SpreadsheetService service = new SpreadsheetService("Test");

		// 認証かける
		service.setOAuth2Credentials(credential);

		// 名前を指定してシート取得
		FeedURLFactory urlFactory = FeedURLFactory.getDefault();
		SpreadsheetQuery spreadsheetQuery = new SpreadsheetQuery(urlFactory.getSpreadsheetsFeedUrl());
		// シート名
		spreadsheetQuery.setTitleQuery("test2");
		SpreadsheetFeed spreadsheetFeed = null;
		try {
			spreadsheetFeed = service.query(spreadsheetQuery, SpreadsheetFeed.class);
		} catch (IOException e2) {
			// TODO 自動生成された catch ブロック
			e2.printStackTrace();
		} catch (ServiceException e2) {
			// TODO 自動生成された catch ブロック
			e2.printStackTrace();
		}
		SpreadsheetEntry spreadsheetEntry = spreadsheetFeed.getEntries().get(0);
		// 名前を指定してワークシートを取得
		URL url = spreadsheetEntry.getWorksheetFeedUrl();
		WorksheetQuery query = new WorksheetQuery(url);
		query.setTitleQuery("目標");
		WorksheetFeed feed = null;
		try {
			feed = service.query(query, WorksheetFeed.class);
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} catch (ServiceException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		List<WorksheetEntry> worksheetEntryList = feed.getEntries();
		WorksheetEntry worksheetEntry = worksheetEntryList.get(0);

		// ワークシート内を検索
		// 日付取得
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String day = sdf.format(dt);
		// 作成者
		String name = userName.getName();
		ListQuery listQuery = new ListQuery(worksheetEntry.getListFeedUrl());
		listQuery.setSpreadsheetQuery("日付 = \"" + day + "\" && 作成者 = \"" + name + "\"");

		ListFeed listFeed = null;
		try {
			listFeed = service.query(listQuery, ListFeed.class);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		ListEntry listEntry = listFeed.getEntries().get(0);
		CustomElementCollection elements = listEntry.getCustomElements();
		GoalBean bean = new GoalBean();
		Goal goal = new Goal(elements.getValue("本日の目標"));
		Purpose purpose = new Purpose(elements.getValue("目的"));
		bean.setGoal(goal);
		bean.setPurpose(purpose);
		return bean;
	}


	public void setPoint(UserID userID,domain.valueo.Point pointWrite) {
		// 指摘事項の保存
			try {
				 pdao.setPoint(pointWrite, userID);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}


	}
	//下書き更新
	public void updateDraft(List<Draft> draftList){
		try{
			for(Draft draft : draftList){
				ddao.updateDraft(new DraftID(draft.getDraftID()), new Text(draft.getText()));
			}

		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

		//ルールとテンプレートを特定し、下書きを読み込む
		public List<Draft> getDraft(UserID userID,DepartmentID departmentID, WeekDay weekday){
			List<Draft> drafts = null;
			//ルールを特定し、テンプレートを決定
			//下書きなかったらつくる

			//仮データ
			TemplateID templateID = new TemplateID("0001");
			//下書き読み込み
			try {
				drafts = ddao.getDraft(templateID, userID);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			return drafts;
		}

}
