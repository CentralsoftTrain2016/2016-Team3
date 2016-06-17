package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao
{
	 protected Connection con;

	 public Dao(Connection con) {
		super();
		this.con = con;
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException
	 {
		String user = "train2016";

		String pass = "train2016";

		String servername = "52.196.236.143";

		String sid = "xe";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection c = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + servername + ":1521:"
							+ sid,user,pass);
		return c;
	 }

}
