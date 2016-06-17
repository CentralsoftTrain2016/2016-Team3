package domain.valueo;

public class Password extends Value{

	private String password;	// パスワード

	/* コンストラクタ */
	public Password(String password){
		super();
		this.password = password;
	}

	// パスワードを取得
	public String getPassword(){
		return password;
	}

}
