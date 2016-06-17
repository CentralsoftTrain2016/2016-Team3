package service.bean;

import java.io.Serializable;
import java.util.List;

import domain.Config;
import domain.Draft;
import domain.Point;
import domain.valueo.Goal;
import domain.valueo.Name;
import domain.valueo.Purpose;

public class EditBean implements Serializable {
	private List<Point> pointList;
	private Goal goal;
	private Purpose purpose;
	private List<Config> configList;
	private Name name;
	private List<Draft> drafts;

	public List<Draft> getDrafts() {
		return drafts;
	}

	public void setDrafts(List<Draft> drafts) {
		this.drafts = drafts;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

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

	public List<Point> getPointList() {
		return pointList;
	}

	public void setPointList(List<Point> pointList) {
		this.pointList = pointList;
	}

	public List<Config> getConfigList() {
		return configList;
	}

	public void setConfigList(List<Config> configList) {
		this.configList = configList;
	}


}
