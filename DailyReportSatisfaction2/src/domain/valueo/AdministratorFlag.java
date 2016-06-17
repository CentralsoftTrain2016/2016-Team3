package domain.valueo;

public class AdministratorFlag extends Value{

	private boolean administratorFlag;	// 管理者フラグ

	/* コンストラクタ */
	public AdministratorFlag(boolean administratorFlag){
		super();
		this.administratorFlag = administratorFlag;
	}

	// 管理者フラグを取得
	public boolean getAdministratorFlag(){
		return administratorFlag;
	}

}
