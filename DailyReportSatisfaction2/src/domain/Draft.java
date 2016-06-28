package domain;

import java.io.Serializable;

import domain.valueo.TemplateItemType;
import domain.valueo.Text;


public class Draft implements Serializable{

	private String draftID;		// 下書きID
	private Text text;		// 下書き本文
	private String userID;
	private String templateName;
	private String itemName;
	private String parentTemplateItemID;
	private String templateItemID;
	private String sheetTab;
	private String type;
	private String templateID;
	private TemplateItemType templateItemType;

	public TemplateItemType getTemplateItemType() {
		return templateItemType;
	}
	public void setTemplateItemType(TemplateItemType templateItemType) {
		this.templateItemType = templateItemType;
	}
	public void setTemplateItemType(String templateItemTypeStr) {
		this.templateItemType = TemplateItemType.valueOf(templateItemTypeStr);
	}


	public String getTemplateID() {
		return templateID;
	}
	public void setTemplateID(String templateID) {
		this.templateID = templateID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/* コンストラクタ*/
	public Draft(){

	}

	public Draft(String draftID, Text text){
		this.draftID = draftID;
		this.text = text;
	}

	public String getSheetTab() {
		return sheetTab;
	}
	public void setSheetTab(String sheetTab) {
		this.sheetTab = sheetTab;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	// 下書きIDを取得
	public String getDraftID(){
		return draftID;
	}
	public void setDraftID(String draftID) {
		this.draftID = draftID;
	}


	// 下書き本文を取得
	public String getText(){
		return text.getText();
	}
	public Text getTextText(){
		return text;
	}
	public String getIndetedText(){
		return text.getIndetedText();
	}

	public void setText(Text text) {
		this.text = text;
	}
	public void setText(String text) {
		this.text = new Text( text );
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getParentTemplateItemID() {
		return parentTemplateItemID;
	}
	public void setParentTemplateItemID(String parentTemplateItemID) {
		this.parentTemplateItemID = parentTemplateItemID;
	}

	public String getTemplateItemID() {
		return templateItemID;
	}
	public void setTemplateItemID(String templateItemID) {
		this.templateItemID = templateItemID;
	}
	public void setIndent(int intdentCnt) {
		if( intdentCnt == 2 )
		{
			itemName = "  " + itemName;
		}
		text.setIndent(templateItemType, intdentCnt);

	}

}
