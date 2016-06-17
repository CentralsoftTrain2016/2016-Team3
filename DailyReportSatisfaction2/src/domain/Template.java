package domain;



public class Template{
	private	String	TEMPLATEID	;
	private	String	NAME;



	private String TEMPLATERULEID;



	public String getTENPLATERULEID() {
		return TEMPLATERULEID;
	}
	public void setTENPLATERULEID(String tENPLATERULEID) {
		TEMPLATERULEID = tENPLATERULEID;
	}

	public String getTEMPLATEID() {
		return TEMPLATEID;
	}
	public void setTEMPLATEID(String tEMPLATEID) {
		TEMPLATEID = tEMPLATEID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}

	@Override
	public String toString() {
		return this.NAME;
	}
}
