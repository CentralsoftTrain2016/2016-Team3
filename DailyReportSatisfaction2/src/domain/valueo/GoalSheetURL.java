package domain.valueo;

public class GoalSheetURL extends Value{

	private String goalSheetURL;		// シートのURL

	/* コンストラクタ */
	public GoalSheetURL(String goalSheetURL){
		super();
		this.goalSheetURL = goalSheetURL;
	}

	// シートのURLを取得
	public String getGoalSheetURL(){
		return goalSheetURL;
	}

}
