package com.innovation.iot.representation;

import java.util.List;

import com.innovation.iot.domain.Device;
import com.innovation.iot.domain.Message;
import com.innovation.iot.domain.User;

public class Notification {

	private User user;
	private Device device;
	private Status status;
	private List<Message> announcements;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Message> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Message> announcements) {
		this.announcements = announcements;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Notification [user=");
		builder.append(user);
		builder.append(", device=");
		builder.append(device);
		builder.append(", status=");
		builder.append(status);
		builder.append(", announcements=");
		builder.append(announcements);
		builder.append("]");
		return builder.toString();
	}

}
