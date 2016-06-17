package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Point;
import domain.valueo.PointID;
import domain.valueo.UserID;

public class PointDao extends Dao{

	public PointDao(Connection con) {
		super(con);
	}

	// --------------------------------------------------------
	// 指摘事項リスト取得
		public List<Point> getPoint(UserID userID) throws SQLException {
			PreparedStatement stmt = null;
			ResultSet rset = null;
			Point point = null;

			List<Point> pointList = new ArrayList<Point>();
			try {

				/* Statementの作成 */
				stmt = con.prepareStatement(
						"SELECT "
						+ " POINTID "
						+ " ,POINT "
						+" FROM "
						+ " POINTTABLE "
						+" WHERE "
						+ " USERID = ? "
						);
				stmt.setString(1, userID.getUserID());

				/* SQL実行 */
				rset = stmt.executeQuery();
				/* セット */
				while (rset.next()) {
					point = new Point();
					point.setPointID(rset.getString(1));
					point.setPoint(rset.getString(2));
					pointList.add(point);
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
			return pointList;
		}

		// --------------------------------------------------------
		// 指摘事項セット
				public int setPoint(domain.valueo.Point pointWrite, UserID userID) throws SQLException {

						PreparedStatement stmt = null;
						int lc = -1;

						try {
							stmt = con.prepareStatement(
									   "insert "
									+ "   into"
									+ "  POINTTABLE"
									+ "  ("
									+ "  POINTID"
									+ " ,POINT"
									+ " , USERID"
									+ "    )"
									+ "values"
									+ "  ("
									+ "  TO_CHAR(POINTID_seq.nextval,'0000')  "
									+ " ,? "
									+ " , ? "
									+ "  )" );

							stmt.setString(1, pointWrite.getPoint());
							stmt.setString(2, userID.getUserID());

							/* ｓｑｌ実行 */
							lc = stmt.executeUpdate();
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
						return lc;
					}

		// --------------------------------------------------------
		// 指摘事項デリート
				public int deletePoint(UserID userID, PointID pointID) throws SQLException {
					PreparedStatement stmt = null;
					int lc = -1;

					try {
						stmt = con.prepareStatement(
								   "delete "
								+ "   from"
								+ "  POINTTABLE"
								+ "  where"
								+ "  USERID = ?"
								+ " AND"
								+ "  POINTID = ?" );

						stmt.setString(1, userID.getUserID());
						stmt.setString(2, pointID.getPointID());

						/* ｓｑｌ実行 */
						lc = stmt.executeUpdate();
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
					return lc;
				}
}
