package domain;

public class ReceiveMail {
	private String title;
	private String text;
	private String userId;
	private String recieveMailId;


	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserId() {
		return userId;
	}

	public void setRecieveMailId(String recieveMailId) {
		this.recieveMailId = recieveMailId;
	}
	public String getRecieveMailId() {
		return recieveMailId;
	}

}
