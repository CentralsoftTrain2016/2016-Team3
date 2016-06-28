package service.bean;

import java.io.Serializable;
import java.util.List;

import domain.Config;
import domain.Draft;
import domain.Point;
import domain.ReceiveMail;
import domain.Template;
import domain.valueo.Goal;
import domain.valueo.Name;
import domain.valueo.Purpose;
import domain.valueo.Title;

public class EditBean implements Serializable {
	private List<Point> pointList;
	private Goal goal;
	private Purpose purpose;
	private List<Config> configList;
	private Name name;
	private List<Draft> drafts;
	private List<ReceiveMail> receiveMailList;
	private Title title;
	private List<Template> templates;

	public List<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
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

	public List<ReceiveMail> getReceiveMailList() {
		return receiveMailList;
	}

	public void setReceiveMailList(List<ReceiveMail> receiveMailList) {
		this.receiveMailList = receiveMailList;
	}



}
