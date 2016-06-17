package domain.valueo;

public class ItemName extends Value{

	private String itemName;		// メールアドレス

	/* コンストラクタ */
	public ItemName(String itemName){
		super();
		this.itemName = itemName;
	}

	// メールアドレスを取得
	public String getItemName(){
		return itemName;
	}

}
