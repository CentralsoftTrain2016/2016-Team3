package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Template;
import domain.TemplateItem;
import domain.valueo.DepartmentID;
import domain.valueo.TemplateID;
import domain.valueo.TemplateRuleID;


public class TemplateDao extends Dao{



	public TemplateDao(Connection con) {
		super(con);
	}

//IDを連番で与える
	public int setTemplateID() throws SQLException {
		PreparedStatement stmt = null;
		int rs = 0;
		try{
			 rs = stmt.executeUpdate(
					 " insert "
					 + " templatetable "
					 +" ( "
					 +" templateid "
					 +" ) "
					 + " values "
					 + " ( "
					 + " TEMPLATEID_SEQ.nextval "
					 + " )  "
			);
		}catch(Exception e){
			 System.out.println(e.getMessage());
		}
		return rs;
	}

	//ルールに則ったテンプレートの生成
		public int setTemplate(TemplateRuleID templateRuleID, Template template) throws SQLException {
			PreparedStatement stmt = null;
			int lc = -1;

			try {
				stmt = con.prepareStatement(
					"insert "
					+ "   into"
					+ " TEMPLATETABLE"
					+ "  ("
					+ "  TEMPLATEID "
					+ " , NAME "
					+ " , TEMPLATERULEID "
					+ "    )"
					+ "values "
					+ "  ("
					+ "  ?  "
					+ " ,? "
					+ " , ? "
					+ "  )" );
				stmt.setInt(1, this.setTemplateID());
				stmt.setString(2, template.getNAME());
				stmt.setString(3, templateRuleID.getTemplateRuleID());

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

//テンプレートルールに基づいたテンプレートを取得
	public List<Template> getTemplate(TemplateID templateID) throws  SQLException
	{
		  PreparedStatement stmt = null;
		  ResultSet rset = null;

		  List<Template>  list = new ArrayList<Template> ();

		  try{
			stmt = con.prepareStatement(
						  "select "
						+ " NAME "
						+ " from "
						+ "   TEMPLATETABLE "
						+ " where "
			  			+ " TEMPLATEID = ? "
						);
			TemplateRuleDao trdao = new TemplateRuleDao(con);
			DepartmentID dID = new DepartmentID(null);


			stmt.setString(1, templateID.getTemplateID());

			rset = stmt.executeQuery();

			while (rset.next())
				{
					Template tmp = new Template();
					tmp.setNAME( rset.getString(1) );
					list.add(tmp);
				}
		  }
		catch (SQLException e) {
			throw e;
		}
		catch ( Exception e){
			throw e;
		}
		finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}
		return list;
		}

//Itemを取得するメソッド
	public List<TemplateItem> getTemplateItem(TemplateID templateID) throws  SQLException
	{
		  PreparedStatement stmt = null;
		  ResultSet rset = null;

		  List<TemplateItem>  list = new ArrayList<TemplateItem> ();

		  try{
			stmt = con.prepareStatement(
						  "select "
						+ " ITEMNAME "
						+ " from "
						+ "   TEMPLATEITEMTABLE "
						+ " where "
			  			+ " TEMPLATEID = ? "
						);
			stmt.setString(1, templateID.getTemplateID());

			rset = stmt.executeQuery();

			while (rset.next())
				{
					TemplateItem tmpi = new TemplateItem();
					tmpi.setITEMNAME( rset.getString(1) );
					list.add(tmpi);
				}
		  }
		catch (SQLException e) {
			throw e;
		}
		catch ( Exception e){
			throw e;
		}
		finally{
			if(stmt != null){
			  stmt.close();
			  stmt = null;
			}
			if(rset != null){
			  rset.close();
			  rset = null;
			}
		}
		return list;
		}

//テンプレート一覧を取得する
	private static final String GET_ALL_TEMPLATE_SQL =
			  " select "
			+ "  NAME "
			+ " ,templateID"
			+ " from "
			+ " TEMPLATETABLE ";

	public List<Template> getAllTemplate() throws  SQLException
	{
		 PreparedStatement stmt = null;
		  ResultSet rset = null;
		  List<Template>  list = new ArrayList<Template> ();

		  try{
				stmt = con.prepareStatement(GET_ALL_TEMPLATE_SQL);
				rset = stmt.executeQuery();
				while (rset.next())
					{
					Template tmp = new Template();
						tmp = new Template();
						tmp.setNAME(rset.getString(1));
						tmp.setTEMPLATEID(rset.getString(2));
						list.add(tmp);
					}
			}catch (SQLException e) {
				throw e;
			}
			catch ( Exception e){
				throw e;
			}
			finally{
				if(stmt != null){
				  stmt.close();
				  stmt = null;
				}
				if(rset != null){
				  rset.close();
				  rset = null;
				}
			}
		return list;
	}
}
