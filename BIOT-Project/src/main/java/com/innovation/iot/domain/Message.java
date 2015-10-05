package com.innovation.iot.domain;

import java.util.Date;
import java.util.List;

public class Message {

	private int id;
	private List<MessageContent> messages;
	private String intervel;
	private String createdBy;
	private String profileImage;
	private Date start;
	private Date end;

	public Message(int id, List<MessageContent> messages, String intervel, String createdBy, String profileImage,
			Date start, Date end) {
		this.id = id;
		this.messages = messages;
		this.intervel = intervel;
		this.createdBy = createdBy;
		this.profileImage = profileImage;
		this.start = start;
		this.end = end;
	}

	public Message(int id, List<MessageContent> messages, String createdBy, String profileImage, Date start) {
		this(id, messages, null, createdBy, profileImage, start, null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntervel() {
		return intervel;
	}

	public void setIntervel(String intervel) {
		this.intervel = intervel;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<MessageContent> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageContent> messages) {
		this.messages = messages;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [id=");
		builder.append(id);
		builder.append(", messages=");
		builder.append(messages);
		builder.append(", intervel=");
		builder.append(intervel);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", profileImage=");
		builder.append(profileImage);
		builder.append(", start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append("]");
		return builder.toString();
	}

}
