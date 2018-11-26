package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.service.business.UserService;

@Path("/Users")
public class UserEndpoint {

	@Inject 
	private UserService service; 
	
	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	@Path("/addUser")
	@POST
	@Produces({ "application/json" })
	public String addUser(String User) {
		return service.addUser(User);
	}
	
	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long userID, String user) {
		return service.updateUser(userID, user);
	}
	
	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") Long userID) {
		return service.deleteUser(userID);
	}	
}
