package domain;

import java.io.Serializable;

import domain.valueo.AdministratorFlag;
import domain.valueo.DepartmentID;
import domain.valueo.Name;
import domain.valueo.Password;
import domain.valueo.TrainerAID;
import domain.valueo.TrainerBID;
import domain.valueo.UserID;


public class User implements Serializable{

    private UserID userID;							// ユーザID
	private Password password;						// パスワード
    private AdministratorFlag administratorFlag;		// 管理者フラグ
    private Name name;							// 名前
    private DepartmentID departmentID;					// 部署ID
    private TrainerAID trainerAID;             //トレーナーID
	private TrainerBID trainerBID;


    /* コンストラクタ */
    public User(UserID userID, Password password, AdministratorFlag administratorFlag, Name name, DepartmentID departmentID
    		,TrainerAID trainerAID,TrainerBID trainerBID){
    	this.userID = userID;
    	this.password = password;
    	this.administratorFlag = administratorFlag;
    	this.name = name;
    	this.departmentID = departmentID;
    	this.trainerAID = trainerAID;
    	this.trainerBID = trainerBID;

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

	public AdministratorFlag getAdministratorFlag() {
		return administratorFlag;
	}

	public void setAdministratorFlag(AdministratorFlag administratorFlag) {
		this.administratorFlag = administratorFlag;
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
