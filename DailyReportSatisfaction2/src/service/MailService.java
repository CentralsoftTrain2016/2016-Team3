package service;

import java.util.List;

import domain.Draft;
import domain.ReceiveMail;
import domain.valueo.TemplateItemType;
import domain.valueo.UserID;
import util.PropertiesUtil;


public class MailService extends Service {

	//private MailDao mdao;

	@Override
	void prePare() {
		//this.mdao = new MailDao(this.con);
	}

	//---------------------------------------------
	// めーるリストしゅとく
	public List<ReceiveMail> getReceiveMail(UserID userID) {

		return PropertiesUtil.isServer().getReceiveMail(userID, this.con);
	}

	//---------------------------------------------
	// めーる本文しゅとく
	public List<ReceiveMail> getMailText(UserID userID,String recieveMailId) {
		return PropertiesUtil.isServer().getMailText(userID, recieveMailId, this.con);
	}


	//---------------------------------------------
	public List<Draft> setLastMail(
						List<Draft> drafts,
						UserID userID,
						String lastMail)
	{
		//GoalBean bean = null;
		//boolean goalFlag = true;

		for (Draft draft : drafts) {
			if (draft.getTemplateItemType() == TemplateItemType.MAIL_QUOTATION) {
				draft.setText(lastMail);
			}
		}
		return drafts;
	}
}
