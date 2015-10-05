package com.innovation.iot.domain;

import java.util.Date;

public class User {
	
	public User(String code, String name, String image, Date dob) {
		super();
		this.code = code;
		this.name = name;
		this.image = image;
		this.dob = dob;
	}
	private String code;
	private String name;
	private String image;
	private Date dob;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", image=");
		builder.append(image);
		builder.append(", dob=");
		builder.append(dob);
		builder.append("]");
		return builder.toString();
	}
	

}
