package service.bean;

import java.io.Serializable;

import domain.valueo.Goal;
import domain.valueo.Purpose;

public class GoalBean implements Serializable{
	private Goal goal;
	private Purpose purpose;


	public Goal getGoal() {
		return goal;
	}
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	public Purpose getPurpose() {
		return purpose;
	}
	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

}
