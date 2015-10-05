package com.innovation.iot.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.innovation.iot.core.NotificationManager;

@Path("/notifications")
public class NotificationService {

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/{deviceId}")
	public String getNotifications(@PathParam("deviceId") String deviceId, @QueryParam("userCode") String userCode){
		return NotificationManager.getInstance().getNotifications(deviceId, userCode);
	}
	
}
