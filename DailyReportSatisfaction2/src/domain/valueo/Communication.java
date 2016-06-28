package domain.valueo;

public class Communication extends Value{
	private String communication;	// 部署ID

	/* コンストラクタ */
	public Communication(String communication){
		super();
		this.communication = communication;
	}

	// 部署IDを取得
	public String getCommunication(){
		return communication;
	}


	@Override
	public String toString(){
		return communication;
	}
}
