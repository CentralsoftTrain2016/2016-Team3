package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Config;
import domain.User;
import domain.valueo.Communication;
import domain.valueo.Signature;
import domain.valueo.Technology;
import domain.valueo.UserID;
import domain.valueo.Work;

public class ConfigDao extends Dao{

	public ConfigDao(Connection con) {
		super(con);
	}


	// --------------------------------------------------------
		// 設定の取得
			public List<Config> getConfig(UserID userID) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet rset = null;
				Config config = null;

				List<Config> configList = new ArrayList<Config>();
				try {

					/* Statementの作成 */
					stmt = con.prepareStatement(
							"SELECT " + " SIGN " +
							" FROM " + " CONFIGTABLE " +
							" WHERE " + " USERID = ? ");
					stmt.setString(1, userID.getUserID());
					/* SQL実行 */
					rset = stmt.executeQuery();
					/* セット */
					while (rset.next()) {
						config = new Config(null, null, null);
						config.setSignature(new Signature(rset.getString(1)));
						configList.add(config);
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
				return configList;
			}

			// --------------------------------------------------------
			// 設定変更す
					public void setConfig(UserID userID,String signature) throws SQLException {
							PreparedStatement stmt = null;
							//ResultSet rset = null;

							try {
								stmt = con.prepareStatement(
										   "UPDATE "
										+ " CONFIG "
									    + " SET"
										+ " SIGNATURE = ? "
									    + "WHERE USERID = ? "
										+ "");
								stmt.setString(1, userID.getUserID());

								/* ｓｑｌ実行 */
								stmt.executeUpdate();
								//con.commit();
							} catch (SQLException e) {
								throw e;
							} catch (Exception e) {
								throw e;
							} finally {

								if (stmt != null) {
									stmt.close();
									stmt = null;
								}
							}

						}

//---------------------------------------------------------------------------------------------------------------------

	// 研修の目標1を取得
	public Communication getTrain1Goal(User user) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;

		Communication communication = null;

		try{
			stmt = con.prepareStatement(
						  " select"
						+ "  TRAINGOAL1 "
						+ " from "
						+ "  USERTABLE "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, user.getUserID().getUserID());

			// SQL実行
			rset = stmt.executeQuery();

			// SQLの結果を文字列化
			while (rset.next()){
				communication = new Communication( rset.getString(1));
			}

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return communication;
	}

//---------------------------------------------------------------------------------------------------------------------

	// 研修の目標2を取得
	public Work getTrain2Goal(User user) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rset = null;

		Work work = null;

		try{
			stmt = con.prepareStatement(
						  "select"
						+ "  TRAINGOAL2 "
						+ " from "
						+ "  USERTABLE "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, user.getUserID().getUserID());

			// SQL実行
			rset = stmt.executeQuery();

			// SQLの結果を文字列化
			while (rset.next()){
				work = new Work( rset.getString(1));
			}

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return work;
	}

//---------------------------------------------------------------------------------------------------------------------

	// 研修の目標3を取得
	public Technology getTrain3Goal(User user) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rset = null;

		Technology technology = null;

		try{
			stmt = con.prepareStatement(
						  "select "
						+ "  TRAINGOAL3 "
						+ " from"
						+ "  USERTABLE "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, user.getUserID().getUserID());

			// SQL実行
			rset = stmt.executeQuery();

			// SQLの結果を文字列化
			while (rset.next()){
				technology = new Technology( rset.getString(1));
			}

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return technology;
	}

//---------------------------------------------------------------------------------------------------------------------

	// 研修の目標1を更新
	public int updateTrainGoal1(UserID userID, Communication commu) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rset = null;
		int a = 0;

		try{
			stmt = con.prepareStatement(
						  "update "
						+ "  USERTABLE "
						+ " set "
						+ "  TRAINGOAL1 = ? "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, commu.getCommunication());
			stmt.setString(2, userID.getUserID());

			// SQL実行
			a = stmt.executeUpdate();

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return a;
	}

//---------------------------------------------------------------------------------------------------------------------

	// 研修の目標2を更新
	public int updateTrainGoal2(UserID userID, Work work_p) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rset = null;
		Work work = null;
		int a = 0;

		try{
			stmt = con.prepareStatement(
						  "update"
						+ "  USERTABLE "
						+ " set "
						+ "  TRAINGOAL2 = ? "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, work_p.getWork());
			stmt.setString(2, userID.getUserID());

			// SQL実行
			a = stmt.executeUpdate();

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return a;
	}

//---------------------------------------------------------------------------------------------------------------------

	// 研修の目標3を更新
	public int updateTrainGoal3(UserID userID, Technology technology_p) throws SQLException{
		PreparedStatement stmt = null;
		ResultSet rset = null;
		int a = 0;

		try{
			stmt = con.prepareStatement(
						  "update "
						+ "  USERTABLE "
						+ " set "
						+ "  TRAINGOAL3 = ? "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, technology_p.getTechnology());
			stmt.setString(2, userID.getUserID());

			// SQL実行
			a = stmt.executeUpdate();

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return a;
	}

//---------------------------------------------------------------------------------------------------------------------
	public List<User> getTrainGoal(UserID userID) throws SQLException{

		PreparedStatement stmt = null;
		ResultSet rset = null;

		List<User> userList = new ArrayList<User>();

		try{
			stmt = con.prepareStatement(
						  " select"
						+ "  TRAINGOAL1 "
						+ " , TRAINGOAL2 "
						+ " , TRAINGOAL3 "
						+ " from "
						+ "  USERTABLE "
						+ " where "
						+ "  USERID = ? "
						);

			// ?にユーザIDをセット
			stmt.setString(1, userID.getUserID());

			// SQL実行
			rset = stmt.executeQuery();

			/* セット */
			while (rset.next()) {
				User user = new User(null, null, null, null, null, null, null, null, null, null);
				user.setCommunication(new Communication( rset.getString(1) ));
				user.setWork(new Work( rset.getString(2) ));
				user.setTechnology(new Technology( rset.getString(3) ));

				userList.add(user);
			}

			// SQLの結果を文字列化
			//while (rset.next()){
			//	communication.Communication("");
			//}

		}catch (SQLException e){
			throw e;
		}catch ( Exception e){
			throw e;
		}finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}

		return userList;
	}
}
