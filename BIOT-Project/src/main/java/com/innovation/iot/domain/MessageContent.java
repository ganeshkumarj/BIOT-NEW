package com.innovation.iot.domain;

public class MessageContent {

	public MessageContent(String content, String image) {
		this.content = content;
		this.image = image;
	}


	private String content;
	private String image;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageContent [content=");
		builder.append(content);
		builder.append(", image=");
		builder.append(image);
		builder.append("]");
		return builder.toString();
	}

}
