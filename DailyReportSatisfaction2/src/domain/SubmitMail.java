package domain;

import java.io.Serializable;


public class SubmitMail implements Serializable{

	private String title;			// 件名
	private String sender;			// 発信者
	private String destination;		// 宛先
	private String text;			// 本文

	/* コンストラクタ */
	public SubmitMail(String title, String sender, String destination, String text){
		this.title = title;
		this.sender = sender;
		this.destination = destination;
		this.text = text;
	}

	// 件名を取得
	public String getTitle(){
		return title;
	}

	// 発信者を取得
	public String getSender(){
		return sender;
	}

	// 宛先を取得
	public String getDestination(){
		return destination;
	}

	// 本文を取得
	public String getText(){
		return text;
	}

}
