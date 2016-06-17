package db;

import java.sql.Connection;
import java.util.List;

import domain.Preview;
import domain.valueo.TemplateID;
import domain.valueo.UserID;


public class PreviewDao extends Dao{

	public PreviewDao(Connection con) {
		super(con);
	}
	public List<Preview> getPreview(TemplateID templateID,UserID userID) {
		return null;
	}

	public String getName(String userID) {
		return null;
	}
}
