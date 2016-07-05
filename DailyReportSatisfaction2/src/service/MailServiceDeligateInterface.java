package service;

import java.sql.Connection;
import java.util.List;

import domain.ReceiveMail;
import domain.valueo.UserID;


public interface MailServiceDeligateInterface {
	public  List<ReceiveMail> getReceiveMail(UserID userID, Connection con);
	public  List<ReceiveMail> getMailText(	UserID userID, String recieveMailId, Connection con);

}
