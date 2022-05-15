package com.telusko.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.telusko.crud.model.crudmodel;
import com.telusko.crud.service.crudservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {

	
	crudservice service = new crudservice();
	
	
	/*INSERT*/
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public crudmodel addUser(crudmodel user) {
		return service.insertUser(user);
     }
	
	
	
	/*READ*/
	
	@Path("/retrieve")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	
	public ArrayList<crudmodel> getUser() throws SQLException {
		    return service.getUser();
     }
	
	
	/*READ BY ID*/
	@Path("/retrieveById/{id}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	
	public ArrayList<crudmodel> getUser(@PathParam("id")int id) throws SQLException {
		    return service.getUserById(id);
     }
	 
	
	/*UPDATE*/
	@Path("/updateUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	public crudmodel updateUser(crudmodel user) {
		return service.updateUser(user);
     }
	
	

	/*DELETE*/
	@Path("/deleteUserById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	
	public int deleteUser(@PathParam("id")int id) {
		return service.deleteUser(id);
    }
}