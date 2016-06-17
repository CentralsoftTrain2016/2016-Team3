package domain.valueo;

public class RecieveMailID extends Value{

	private String recieveMailID;		// 受信メールID

	/* コンストラクタ */
	public RecieveMailID(String recieveMailID){
		super();
		this.recieveMailID = recieveMailID;
	}

	// 受信メールIDを取得
	public String getRecieveMailID(){
		return recieveMailID;
	}

}
