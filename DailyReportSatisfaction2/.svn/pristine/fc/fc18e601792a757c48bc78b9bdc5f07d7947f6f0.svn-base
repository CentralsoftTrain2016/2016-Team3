package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Draft;
import domain.valueo.DraftID;
import domain.valueo.TemplateID;
import domain.valueo.Text;
import domain.valueo.UserID;

public class DraftDao extends Dao{
	public DraftDao(Connection con) {
		super(con);
	}
	private static final String GET_DRAFT_SQL =
				" select "
			  + " tmp.name "
			  + " , item.itemname "
			  + " , draft.text "
			  + " , draft.draftid "
			  + " , item.parenttemplateitemID "
			  + " , item.sheetTab "
			  + " , item.type "
			  + " ,tmp.templateid  "
			  + " from "
			  + " TEMPLATETABLE  tmp "
			  + " ,TEMPLATEITEMTABLE  item "
			  + " ,DRAFTTABLE  draft"
			  + " where "
			  + " draft.userid = ? "
			  + " and "
			  + " tmp.templateid = ?"
			  + " and "
			  + " tmp.templateid = item.templateid"
			  + " and "
			  + " draft.templateitemid = item.templateitemid ";

	//userIDとtemplateIDを参照してtemplate-item-draftを取得
	public List<Draft> getDraft(TemplateID templateID,UserID userID) throws  SQLException
	{
		  PreparedStatement stmt = null;
		  ResultSet rset = null;

		  List<Draft>  list = new ArrayList<Draft> ();



		  try{
			stmt = con.prepareStatement(GET_DRAFT_SQL);
			stmt.setString(1, userID.getUserID());
			stmt.setString(2, templateID.getTemplateID());

			rset = stmt.executeQuery();

			while (rset.next())
				{
					Draft draft = new Draft(userID.getUserID(), rset.getString(4));

					draft.setTemplateName( rset.getString(1) );
					draft.setItemName(rset.getString(2));
					draft.setText(rset.getString(3));
					draft.setDraftID(rset.getString(4));
					draft.setParentTemplateItemID(rset.getString(5));
					draft.setSheetTab(rset.getString(6));
					draft.setType(rset.getString(7));
					draft.setTemplateID(rset.getString(8));

					list.add(draft);
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

	private static final String INSERT_DRAFT_SQL =
			"insert into drafttable draft( "
			+"draft.userid"
			+ ",draft.TEXT,"
			+ "draft.TEMPLATEITEMID,"
			+ "draft.DRAFTID"
			+ ")"
			+ "select "
			+ " ? "
			+ " , '' "
			+ ",item.TEMPLATEITEMID "
			+ ",TO_CHAR(draftid_seq.nextval,'0000') "
			+ " from "
			+ " templatetable tmp "
			+ " ,templateitemtable item "
			+ " where "
			+ " tmp.templateid = ? "
			+ " and tmp.templateid = item.templateid ";

	public void setDraft(TemplateID templateID,UserID userID)throws  SQLException{
		 PreparedStatement stmt = null;
		  ResultSet rset = null;
		  int insd = 0;

		  List<Draft>  list = new ArrayList<Draft> ();

		  try{
			stmt = con.prepareStatement(INSERT_DRAFT_SQL);
			stmt.setString(1, userID.getUserID());
			stmt.setString(2, templateID.getTemplateID());

			insd = stmt.executeUpdate();
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
		  }



	public List<Draft> getAndInsertDraft(TemplateID templateID,UserID userID) throws  SQLException
	{
		List<Draft> draftList = this.getDraft(templateID, userID);
		if(draftList.isEmpty()){
			this.setDraft(templateID, userID);
			draftList = this.getDraft(templateID, userID);
		}
		return draftList;
	}
	private static final String UPDATE_DRAFT_SQL =
			"update drafttable "
			+ "set "
			+ "text = ? "
			+ "where "
			+ "draftid = ? ";

	public void updateDraft(DraftID draftID,Text text) throws SQLException {
		PreparedStatement stmt = null;
		  ResultSet rset = null;
		  int insd = 0;


		  try{
			stmt = con.prepareStatement(UPDATE_DRAFT_SQL);
			stmt.setString(1, text.getText());
			stmt.setString(2, draftID.getDraftID());

			insd = stmt.executeUpdate();
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
		  }
}
