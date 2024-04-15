package csFertig;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 1L;

	public enum Action {
		LOGIN, JOIN, LEAVE, SAY, JOIN_ERROR
	}

	private Action action;
	private String user;
	private String text;

	public Message(Action action, String user, String text) {
		this.action = action;
		this.user = user;
		this.text = text;
	}

	public Action getAction() {
		return action;
	}

	public String getUser() {
		return user;
	}

	public String getText() {
		return text;
	}

}
