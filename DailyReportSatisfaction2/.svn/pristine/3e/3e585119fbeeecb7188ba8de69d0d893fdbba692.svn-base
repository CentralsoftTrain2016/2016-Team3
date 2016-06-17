package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import db.Dao;
import db.DraftDao;
import db.PreviewDao;
import domain.Draft;
import domain.valueo.TemplateID;
import domain.valueo.UserID;

public class PreviewService extends Service{
	private PreviewDao pdao;

	@Override
	void prePare() {
		this.pdao = new PreviewDao(this.con);
	}

	/* 件名自動生成メソッド */

	public String createMailTitle(UserID userid){


		String autoTitle = "【日報】";			// 自動生成する件名
		String userName = "";					// ユーザ名
		String trainer = "";					// トレーナ名
		String date = "";						// 日付

		// ユーザ名を取得
		// 【仮】たぶん設定の振り分け設定の名前登録したやつから持ってくる(あっこの苗字だけor苗字(名前)って表記するから)
		/*try {
			userName = pdao.getName(userID); //振り分け設定の名前を
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		*/userName = "今井";

		// トレーナ名を取得
		// 仮
		/*try {
			trainer = pdao.getName(userID); //振り分け設定の名前を
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		*/trainer = "古里";

		// 日付を取得してdateに格納
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		date = sdf.format(d);

		// 件名を生成する
		autoTitle = autoTitle + userName + " → " + trainer + " " + date;


		return autoTitle;
	}

	/* 本文テキストのインデント調整 */
	public List<Draft> getIndentDraft (TemplateID templateID, UserID userID){

		Connection con = null;
		List<Draft> drafts = new ArrayList<Draft> ();
		try {
			con = Dao.getConnection();
			DraftDao dao = new DraftDao(con);
			//DAOのメソッド
			drafts = dao.getDraft(templateID, userID);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			drafts = null;
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		for(Draft draft: drafts){
			//nullを空白に
			if(draft.getText() == null){
				draft.setText("");
			}
			//親子判定
			if(draft.getParentTemplateItemID() == null){
				draft.setText("　　" + draft.getText());
			}else{
				draft.setItemName("　　" + draft.getItemName());
				draft.setText("　　　　" + draft.getText());
			}

		}


		return drafts;
	}
}
