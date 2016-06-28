package domain;

import java.io.Serializable;

import domain.valueo.Communication;
import domain.valueo.Signature;
import domain.valueo.Technology;
import domain.valueo.Work;


public class Config implements Serializable{

	private Signature signature;			// 署名
	private Communication communication;	// コミュニケーションについて
	private Work work;						// 仕事の進め方
	private Technology technology;			// 技術的なこと

	/* コンストラクタ */
	public Config(Communication communication, Work work, Technology technology){
		this.communication = communication;
		this.work = work;
		this.technology = technology;
	}

	// コミュニケーションについて
	public Communication getCommunication() {
		return communication;
	}
	public void setCommunication(Communication communication) {
		this.communication = communication;
	}

	// 仕事の進め方
	public Work getWork() {
		return work;
	}
	public void setWork(Work work) {
		this.work = work;
	}

	// 技術的なこと
	public Technology getTechnology() {
		return technology;
	}
	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	//	public Config(Signature signature){
//		this.signature = signature;
//	}
	// 署名ゲット
	public Signature getSignature(){
		return signature;
	}
	// 署名セット
	public void setSignature(Signature signature){
		this.signature = signature;
	}

}
