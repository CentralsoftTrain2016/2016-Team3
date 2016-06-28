package service.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private String userID;
	private String password;
	private String departmentID;
	private String name;
	private String trainerAID;
	private String trainerBID;
	private String message;


	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String string) {
		this.departmentID = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainerAID() {
		return trainerAID;
	}

	public void setTrainerAID(String trainerAID) {
		this.trainerAID = trainerAID;
	}

	public String getTrainerBID() {
		return trainerBID;
	}

	public void setTrainerBID(String trainerBID) {
		this.trainerBID = trainerBID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

