package domain.valueo;

public class DraftID extends Value{

	private String draftID;		// 下書きID

	/* コンストラクタ */
	public DraftID(String draftID){
		super();
		this.draftID = draftID;
	}

	// 下書きIDを取得
	public String getDraftID(){
		return draftID;
	}

}
