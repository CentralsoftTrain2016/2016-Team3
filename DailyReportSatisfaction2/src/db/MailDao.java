package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ReceiveMail;

public class MailDao extends Dao {

	public MailDao(Connection con) {
		super(con);
	}

	// --------------------------------------------------------
	// DBにあるメールを受け取る
	public List<ReceiveMail> getMail(String userIdt) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rset = null;
		ReceiveMail mail = null;
		List<ReceiveMail> mailList = new ArrayList<ReceiveMail>();
		try {

			/* Statementの作成 */
			stmt = con.prepareStatement(
					"SELECT " + " title " + " , text " + " , userId " + " ,recieveMailID " +
					" FROM " + " ReceiveMail " +
					" UserID = ? ");

			/* SQL実行 */
			rset = stmt.executeQuery();

			/* セット */
			while (rset.next()) {
				mail = new ReceiveMail();
				mail.setTitle(rset.getString(1));
				mail.setText(rset.getString(2));
				mail.setUserId(rset.getString(3));
				mail.setRecieveMailId(rset.getString(4));

				mailList.add(mail);
			}
		}

		catch (SQLException e) {
			throw e;

		} finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
				stmt = null;
			}
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw e;
				}
				rset = null;
			}
		}
		return mailList;
	}
}