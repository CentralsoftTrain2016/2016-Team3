package domain.valueo;

public class Destination extends Value{

	private String destination;		// 宛先

	/* コンストラクタ */
	public Destination(String destination){
		super();
		this.destination = destination;
	}

	// 宛先を取得
	public String getDestination(){
		return destination;
	}

}
