package service.bean;

import java.io.Serializable;
import java.util.List;

import domain.Draft;
import domain.valueo.Destination;
import domain.valueo.Sender;
import domain.valueo.Title;

public class PreviewBean implements Serializable{

	private Sender sender;					// 送信者
	private Destination destination;		// 宛先
	private Title title;					// 件名
	private List<Draft> draft;						// 本文

	public List<Draft> getDraft() {
		return draft;
	}

	public void setDraft(List<Draft> draft) {
		this.draft = draft;
	}

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

}
