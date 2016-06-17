package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Config;
import domain.valueo.Signature;
import domain.valueo.UserID;

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
						config = new Config();
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


}
