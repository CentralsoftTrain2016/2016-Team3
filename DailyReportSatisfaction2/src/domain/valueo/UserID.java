package domain.valueo;

public class UserID extends Value{

	private String userID;	// ユーザID

	/* コンストラクタ */
	public UserID(String userID){
		super();
		this.userID = userID;
	}

	// ユーザIDを取得
	public String getUserID(){
		return userID;
	}

}
