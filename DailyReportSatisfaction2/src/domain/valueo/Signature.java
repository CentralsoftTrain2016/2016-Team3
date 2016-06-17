package domain.valueo;

public class Signature extends Value{

	private String signature;	// 署名

	/* コンストラクタ */
	public Signature(String signature){
		super();
		this.signature = signature;
	}

	// 署名を取得
	public String getSignature(){
		return signature;
	}

}
