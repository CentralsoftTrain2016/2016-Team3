package domain.valueo;

public class DepartmentName extends Value{

	private String departmentName;		// 部署名

	/* コンストラクタ */
	public DepartmentName(String departmentName){
		super();
		this.departmentName = departmentName;
	}

	// 部署名を取得
	public String getDepartmentName(){
		return departmentName;
	}

}
