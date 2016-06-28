package domain;

import java.io.Serializable;

import domain.valueo.Communication;
import domain.valueo.DepartmentID;
import domain.valueo.Mailaddress;
import domain.valueo.Name;
import domain.valueo.Password;
import domain.valueo.Technology;
import domain.valueo.TrainerAID;
import domain.valueo.TrainerBID;
import domain.valueo.UserID;
import domain.valueo.Work;


public class User implements Serializable{

    private UserID userID;						// ユーザID
	private Password password;					// パスワード
    private Name name;							// 名前

    private DepartmentID departmentID;			// 部署ID
    private TrainerAID trainerAID;				// トレーナAID
	private TrainerBID trainerBID;				// トレーナBID
	private Mailaddress mailAddress;			// メールアドレス
	private Communication communication;		// コミュニケーションについて
	private Work work;							// 仕事の進め方
	private Technology technology;				// 技術的なこと


	/* コンストラクタ */
    public User(UserID userID, Password password,  Name name, TrainerAID trainerAID	,TrainerBID trainerBID,DepartmentID departmentID,Mailaddress mailAddress
    		,Communication communication,Work work,Technology technology){
    	this.userID = userID;
    	this.password = password;
    	this.name = name;
    	this.trainerAID = trainerAID;
    	this.trainerBID = trainerBID;
    	this.departmentID = departmentID;

    	this.mailAddress = mailAddress;
    	this.communication = communication;
    	this.work = work;
    	this.technology = technology;

    }

    public Communication getCommunication() {
		return communication;
	}

	public void setCommunication(Communication communication) {
		this.communication = communication;
	}

	public Work getWork() {
		return work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Mailaddress getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(Mailaddress mailAddress) {
		this.mailAddress = mailAddress;
	}

    public TrainerAID getTrainerAID() {
		return trainerAID;
	}

	public void setTrainerAID(TrainerAID trainerAID) {
		this.trainerAID = trainerAID;
	}

	public TrainerBID getTrainerBID() {
		return trainerBID;
	}

	public void setTrainerBID(TrainerBID trainerBID) {
		this.trainerBID = trainerBID;
	}

	public Password getPassword() {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public DepartmentID getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(DepartmentID departmentID) {
		this.departmentID = departmentID;
	}

	// ユーザIDを取得
    public UserID getUserID(){
		return userID;
    }
    public void setUserID(UserID userID) {
		this.userID = userID;
	}

}
