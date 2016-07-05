package domain.valueo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import db.MailDao;
import db.UserDao;
import domain.ReceiveMail;
import domain.User;
import service.MailServiceDeligateInterface;

public enum MailEnvironmentEnum implements MailServiceDeligateInterface
{
	SERVER(new GoogleMailServiceImp(),"localhost"),
	CLIENT(new NormalMailServiceImp(),"52.196.236.143");

	MailServiceDeligateInterface deligate;
	String serverName;

	//--------------
	private MailEnvironmentEnum(MailServiceDeligateInterface deligate, String serverName) {
		this.deligate = deligate;
		this.serverName = serverName;
	}


	//--------------
	public List<ReceiveMail> getReceiveMail(UserID userID, Connection con) {
		return deligate.getReceiveMail(userID, con);
	}

	//--------------
	public List<ReceiveMail> getMailText(UserID userID,String recieveMailId, Connection con) {
		return deligate.getMailText(userID,recieveMailId, con);
	}


	public String getServerName() {
		return serverName;
	}
}

//------------------------------------------------------------
class NormalMailServiceImp implements MailServiceDeligateInterface
{

	@Override
	public List<ReceiveMail> getReceiveMail(UserID userID, Connection con) {
		List<ReceiveMail> receiveMailList = new ArrayList<ReceiveMail>();
		MailDao mdao = new MailDao(con);

		try {
			receiveMailList = mdao.getReceiveMail(userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return receiveMailList;	}

	@Override
	public List<ReceiveMail> getMailText(UserID userID,String recieveMailId, Connection con) {
		MailDao mdao = new MailDao(con);
		List<ReceiveMail> receiveMailList = new ArrayList<ReceiveMail>();
		try {
			receiveMailList = mdao.getMailText(recieveMailId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return receiveMailList;
	}
}
//------------------------------------------------------------
class GoogleMailServiceImp implements MailServiceDeligateInterface
{

	@Override
	public List<ReceiveMail> getReceiveMail(UserID userID, Connection con) {
		List<ReceiveMail> receiveMailList = new ArrayList<ReceiveMail>();
		Store st = null;
		try {
			UserDao udao = new UserDao(con);
			User user1 = udao.getUser(userID);

			//String host = "imap.gmail.com";
			String host =user1.getMailHostUrl().toString();
			int port = 993;
			//String user = "centralsoft.train2016@gmail.com";
			String user = user1.getMailAddress().toString();

			//String password = "train2016";
			user1.getMailPassword().decriptPassword();
			MailPassword mailPassword = user1.getMailPassword();
			mailPassword.decriptPassword();
			String password = mailPassword.toString();

			String target_folder = "INBOX";


			// Properties props = System.getProperties();
			Properties props = new Properties();
			Session sess = Session.getInstance(props, null);
			// sess.setDebug(true);

			st = sess.getStore("imaps");
			st.connect(host, port, user, password);
			Folder fol = st.getFolder(target_folder);

			if (fol.exists()) {
				for (Folder f : fol.list()) {
					System.out.println(f.getName());
				}

				fol.open(Folder.READ_ONLY);
				for (Message m : fol.getMessages()) {
					System.out.printf("%s - %d\n", m.getSubject(), m.getSize());
					ReceiveMail mail = new ReceiveMail();
					mail.setTitle(m.getSubject());
					mail.setText(m.getContent().toString());
					mail.setRecieveMailId(String.valueOf(m.getMessageNumber()));
					mail.setUserId(userID.getUserID());
					receiveMailList.add(mail);
				}
				fol.close(false);
			} else {
				System.out.printf("%s is not exist.", target_folder);
			}

		} catch (MessagingException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException(e1);
		} finally {
			try {
				st.close();
			} catch (MessagingException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

		return receiveMailList;
	}

	@Override
	public List<ReceiveMail> getMailText(UserID userID,String recieveMailId, Connection con) {
		List<ReceiveMail> receiveMailList = new ArrayList<ReceiveMail>();
		Store st = null;
		try {
			UserDao udao = new UserDao(con);
			User user1 = udao.getUser(userID);

			//String host = "imap.gmail.com";
			String host =user1.getMailHostUrl().toString();
			int port = 993;
			//String user = "centralsoft.train2016@gmail.com";
			String user = user1.getMailAddress().toString();

			//String password = "train2016";
			user1.getMailPassword().decriptPassword();
			MailPassword mailPassword = user1.getMailPassword();
			mailPassword.decriptPassword();
			String password = mailPassword.toString();

			String target_folder = "INBOX";

			// Properties props = System.getProperties();
			Properties props = new Properties();
			Session sess = Session.getInstance(props, null);
			// sess.setDebug(true);

			st = sess.getStore("imaps");
			st.connect(host, port, user, password);
			Folder fol = st.getFolder(target_folder);

			if (fol.exists()) {
				for (Folder f : fol.list()) {
					System.out.println(f.getName());
				}

				fol.open(Folder.READ_ONLY);
				for (Message m : fol.getMessages()) {
					System.out.printf("%s - %d\n", m.getSubject(), m.getSize());
					ReceiveMail mail = new ReceiveMail();
					mail.setTitle(m.getSubject());
					mail.setText(m.getContent().toString());
					mail.setRecieveMailId(String.valueOf(m.getMessageNumber()));
					// mail.setUserId( userID.getUserID());
					if (recieveMailId != null && recieveMailId.equals(String.valueOf(m.getMessageNumber())))
						receiveMailList.add(mail);
				}
				fol.close(false);
			} else {
				System.out.printf("%s is not exist.", target_folder);
			}

		} catch (MessagingException | IOException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			try {
				st.close();
			} catch (MessagingException e) {
				e.printStackTrace();
				throw new RuntimeException();
			}
		}

		return receiveMailList;
	}

}