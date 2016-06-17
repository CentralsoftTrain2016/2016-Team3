package domain.valueo;

public class TrainerTraingSystemID extends Value{

	private String trainerTraingSystemID;		// トレーニングシステムID

	/* コンストラクタ */
	public TrainerTraingSystemID(String trainerTraingSystemID){
		super();
		this.trainerTraingSystemID = trainerTraingSystemID;
	}

	// トレーニングシステムIDを取得
	public String getTrainerTraingSystemID(){
		return trainerTraingSystemID;
	}

}
