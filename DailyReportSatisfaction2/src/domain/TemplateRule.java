package domain;

import java.sql.Date;

public class TemplateRule{
	private	String	TEMPLATEID	;
	private	String	WEEKDAY;
	private	Date	ENDDATE;

	private	Date	STARTDATE;
	private	String	TEMPLATERULEID;
	private	String	DEPARTMENTID;

	public Date getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(Date sTARTDATE) {
		STARTDATE = sTARTDATE;
	}

	public Date getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(Date eNDDATE) {
		ENDDATE = eNDDATE;
	}


	public String getTEMPLATERULEID() {
		return TEMPLATERULEID;
	}
	public void setTEMPLATERULEID(String tEMPLATERULEID) {
		this.TEMPLATERULEID = tEMPLATERULEID;
	}

	public String getWEEKDAY() {
		return WEEKDAY;
	}
	public void setWEEKDAY(String wEEKDAY) {
		TEMPLATEID = wEEKDAY;
	}


	public String getDEPARTMENTID() {
		return DEPARTMENTID;
	}
	public void setDEPARTMENTID(String dEPARTMENTID) {
		TEMPLATEID = dEPARTMENTID;
	}
	public String getTEMPLATEID() {
		return TEMPLATEID;
	}
	public void setTEMPLATEID(String tEMPLATEID) {
		TEMPLATEID = tEMPLATEID;
	}
}
