package service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		//下書き持ってくる
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
				//draft.setText("　　" + draft.getText());
				draft.setIndent(1);
			}else{
				//draft.setItemName("　　" + draft.getItemName());
				//draft.setText("　　　　" + draft.getText());
				draft.setIndent(2);
			}

		}


		return drafts;
	}

	//テキスト結合
	public StringBuffer createText(List<Draft> drafts){
		StringBuffer strBuff = new StringBuffer();
		for(  Draft draft: drafts ){
			String item = convertSanitize(draft.getItemName());
			String text = convertSanitize(draft.getIndetedText());
			strBuff.append(item).append("<BR>");
			strBuff.append(text).append("<BR>").append("<BR>");
		}
		return strBuff;
	}

	//送信テキスト結合
	public StringBuffer createSendText(List<Draft> drafts){
		StringBuffer strBuff = new StringBuffer();
		for(  Draft draft: drafts ){
			String item = convertSanitize(draft.getItemName());
			String text = convertSanitize(draft.getIndetedText());
			strBuff.append(item).append("\n");
			strBuff.append(text).append("\n").append("\n");
		}
		return strBuff;
	}

	//サニタイジング
	public  String convertSanitize( String str ) {
        if(str==null) {
            return str;
        }
        str = str.replaceAll("&" , "&amp;" );
        str = str.replaceAll("<" , "&lt;"  );
        str = str.replaceAll(">" , "&gt;"  );
        str = str.replaceAll("\"", "&quot;");
        str = str.replaceAll("'" , "&#39;" );
        return str;
     }


	public void SubmitMail(String sender_p, String senderAddress_p, String destination_p, String title_p, String text_p) throws UnsupportedEncodingException{
		/*
		 * まだテストデータ、値を入れること：迷惑メール判定されるかも
		 */

		String sender = sender_p;
		sender =new String(sender.getBytes("ISO8859-1"),"UTF-8");
		String senderAddress = senderAddress_p;
		senderAddress =new String(senderAddress.getBytes("ISO8859-1"),"UTF-8");
		String destination = destination_p;
		destination =new String(destination.getBytes("ISO8859-1"),"UTF-8");
		String title = title_p;
		title =new String(title.getBytes("ISO8859-1"),"UTF-8");
		String sendText = text_p;
		sendText =new String(sendText.getBytes("ISO8859-1"),"UTF-8");
		System.out.print(sendText);

		try {
			 // SMTPサーバー設定
			Properties props = System.getProperties();
			//送信ポート：SMTP=25 サブミッション=587
			 props.setProperty( "mail.smtp.port", "25");
			 //送信サーバ
			 //開発サーバ
			 //props.put( "mail.smtp.host", "52.196.236.143" );
			 //ローカルホスト
			 //props.put( "mail.smtp.host", "localhost" );
			 //ヤフー
			 props.put( "mail.smtp.host", "smtp.mail.yahoo.co.jp" );
			//認証するか
			 props.setProperty("mail.smtp.auth", "true");

			 //エンベロープここで本当の送信元アドレスを指定
			 props.setProperty("mail.smtp.from", "central_team3@yahoo.co.jp");
			 //認証部分

			 Session session = Session.getInstance(props, new Authenticator(){
				 protected PasswordAuthentication getPasswordAuthentication() {
					 return new PasswordAuthentication( "central_team3", "central1987" );
				}
			 });

			 //Session session = Session.getInstance(props,null);
			MimeMessage mimeMessage=new MimeMessage( session );

			 // 送信元メールアドレスと送信者名を指定
			//上でエンベロープFromを設定しているため、ここでヘッダFromを指定できる（偽装送信元アドレス）
			mimeMessage.setFrom( new InternetAddress( senderAddress, sender, "ISO-2022-JP" ) );
			 /* 送信先メールアドレスを指定
			  * 一応固定値を入れている
			  */
			//mimeMessage.setRecipients( Message.RecipientType.TO, "tatsuya.nakama@central-soft.co.jp" );
			mimeMessage.setRecipients( Message.RecipientType.TO, "central_team3@yahoo.co.jp" );
			 // メールのタイトルを指定
			mimeMessage.setSubject( title, "UTF-8" );
			 // メールの内容を指定
			mimeMessage.setText( sendText, "UTF-8" );
			 // メールの形式を指定
			mimeMessage.setHeader( "Content-Type", "text/plain" );
			 // 送信日付を指定
			mimeMessage.setSentDate( new Date() );
			 // 送信します
			Transport.send( mimeMessage );
			System.out.println("送信完了");
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException(e);
		 }
/*
		try {
			 // SMTPサーバー設定
			Properties props = System.getProperties();
			//送信ポート：SMTP=25 サブミッション=587
			 props.setProperty( "mail.smtp.port", "587");
			 //送信サーバ
			 //開発サーバ
			 //props.put( "mail.smtp.host", "52.196.236.143" );
			 //ローカルホスト
			 //props.put( "mail.smtp.host", "localhost" );
			 //ヤフー
			 props.put( "mail.smtp.host", "smtp.mail.yahoo.co.jp" );
			 //SSLのやつらしい
			 props.setProperty("mail.smtp.socketFactory.port", "587");
			 //認証するか
			 props.setProperty("mail.smtp.auth", "true");
			 //エンベロープここで本当の送信元アドレスを指定
			 props.setProperty("mail.smtp.from", senderAddress);
			 //認証部分
			 Session session = Session.getInstance(props, new Authenticator(){
				 protected PasswordAuthentication getPasswordAuthentication() {
					 return new PasswordAuthentication( "central_team3", "central1987" );
				}
			 });
			 //Session session = Session.getInstance(props, null);

			MimeMessage mimeMessage=new MimeMessage( session );

			 // 送信元メールアドレスと送信者名を指定
			//上でエンベロープFromを設定しているため、ここでヘッダFromを指定できる（偽装送信元アドレス）
			mimeMessage.setFrom( new InternetAddress( senderAddress, sender, "ISO-2022-JP" ) );
			 // 送信先メールアドレスを指定
			//mimeMessage.setRecipients( Message.RecipientType.TO, "tatsuya.nakama@central-soft.co.jp" );
			mimeMessage.setRecipients( Message.RecipientType.TO, destination );
			 // メールのタイトルを指定
			mimeMessage.setSubject( title, "ISO-2022-JP" );
			 // メールの内容を指定
			mimeMessage.setText( text, "ISO-2022-JP" );
			 // メールの形式を指定
			mimeMessage.setHeader( "Content-Type", "text/html" );
			 // 送信日付を指定
			mimeMessage.setSentDate( new Date() );
			 // 送信します
			Transport.send( mimeMessage );
			System.out.println("送信完了");
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new RuntimeException(e);
		 }
*/
	}

}
