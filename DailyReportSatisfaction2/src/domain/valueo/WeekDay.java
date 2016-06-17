package domain.valueo;

public class WeekDay extends Value{

	private String weekDay;		// 曜日

	/* コンストラクタ */
	public WeekDay(String weekDay){
		super();
		this.weekDay = weekDay;
	}

	// 曜日を取得
	public String getWeekDay(){
		return weekDay;
	}

}
