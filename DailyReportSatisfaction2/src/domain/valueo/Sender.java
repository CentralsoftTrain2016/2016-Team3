package domain.valueo;

public class Sender extends Value{

	private String sender;	// 送信者

	/* コンストラクタ */
	public Sender(String sender){
		super();
		this.sender = sender;
	}

	// 送信者を取得
	public String getSender(){
		return sender;
	}

}
