package domain.valueo;

public class TemplateRuleID extends Value{

	private String templateRuleID;		// テンプレートルールID

	/* コンストラクタ */
	public TemplateRuleID(String templateRuleID){
		super();
		this.templateRuleID = templateRuleID;
	}

	// テンプレートルールIDを取得
	public String getTemplateRuleID(){
		return templateRuleID;
	}
}
