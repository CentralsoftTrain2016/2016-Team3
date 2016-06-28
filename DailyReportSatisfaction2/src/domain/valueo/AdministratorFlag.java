package domain.valueo;

public class AdministratorFlag extends Value{

	private String administratorFlag;	// 管理者フラグ

	/* コンストラクタ */
	public AdministratorFlag(String string){
		super();
		this.administratorFlag = string;
	}

	// 管理者フラグを取得
	public String getAdministratorFlag(){
		return administratorFlag;
	}

}
