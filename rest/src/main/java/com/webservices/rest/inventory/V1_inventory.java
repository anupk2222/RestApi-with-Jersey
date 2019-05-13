package com.webservices.rest.inventory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;

import com.webservices.dao.Schema308tube;


@Path("/v1/inventory")
public class V1_inventory {

	 
	 	@GET
	 	@Produces(MediaType.APPLICATION_JSON)
	 	public Response returnAllPcParts() throws Exception {
	 		
	 		String returnString = null;
	 		Response rb = null;	
	 		JSONArray json = new JSONArray();
	 		
	 		try {
	 			
	 			Schema308tube dao = new Schema308tube();
	 			
	 			json = dao.queryAllPcParts();
	 			returnString = json.toString();
	 			
	 			rb = Response.ok(returnString).build();
	 			
	 		}
	 		catch (Exception e) {
	 			e.printStackTrace();
	 		}
	 		
	 		return rb;
	 }
	
}
