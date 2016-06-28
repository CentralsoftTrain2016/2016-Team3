package service;
import java.sql.SQLException;

import db.UserDao;
import domain.User;
import domain.valueo.DepartmentID;
import domain.valueo.Mailaddress;
import domain.valueo.Name;
import domain.valueo.Password;
import domain.valueo.TrainerAID;
import domain.valueo.TrainerBID;
import domain.valueo.UserID;
public class LoginService extends Service{

	private UserDao udao;


	@Override
	void prePare() {
		this.udao = new UserDao( this.con);
	}
//ユーザーの取得
	public User getUser( String id,String password)
	{
	User user = null;

	try {
		user = udao.getUser(id, password);
	} catch (SQLException e)
	{
		throw new RuntimeException(e);
	}
	return user;
}

//ユーザーの新規作成
	public void createUser(UserID userID,Password password, Name name, DepartmentID departmentID

			,TrainerAID trainerAID,TrainerBID trainerBID,Mailaddress mailAddress){


		User user = new User(userID, password, name, trainerAID, trainerBID ,departmentID ,mailAddress
				,null,null,null);


		try {
			udao.createUser(user);
		}

		catch (SQLException e) {
			int code = e.getErrorCode();
			if(code == 1)
			{
				throw new RuntimeException(e);

//				try {
//					throw new Exception(e);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//				return;
			}
			throw new RuntimeException(e);
		}
	}

}
