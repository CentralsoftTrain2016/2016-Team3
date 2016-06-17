package domain.valueo;

public class DepartmentID extends Value{

	private String departmentID;	// 部署ID

	/* コンストラクタ */
	public DepartmentID(String departmentID){
		super();
		this.departmentID = departmentID;
	}

	// 部署IDを取得
	public String getDepartmentID(){
		return departmentID;
	}

}
