package com.innovation.iot.domain;

public class Device {

	public Device(String id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
	}

	private String id;
	private String name;
	private String location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Device [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}

}
