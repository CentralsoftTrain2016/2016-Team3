package domain.valueo;

public class Purpose extends Value{

	private String purpose;	// 目標

	/* コンストラクタ */
	public Purpose(String purpose){
		super();
		this.purpose = purpose;
	}

	// 目標を取得
	public String getPurpose(){
		return purpose;
	}
}
