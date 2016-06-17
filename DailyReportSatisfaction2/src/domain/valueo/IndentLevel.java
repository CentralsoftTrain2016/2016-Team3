package domain.valueo;

public class IndentLevel extends Value{

	private String indentLevel;		// メールアドレス

	/* コンストラクタ */
	public IndentLevel(String indentLevel){
		super();
		this.indentLevel = indentLevel;
	}

	// メールアドレスを取得
	public String getIndentLevel(){
		return indentLevel;
	}

}
