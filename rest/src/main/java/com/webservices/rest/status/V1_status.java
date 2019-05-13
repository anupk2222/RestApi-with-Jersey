package com.webservices.rest.status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.webservices.dao.*;

@Path("/v1/status")
public class V1_status {
	
	private static final String api_version = "00.02.00"; //version of the api

	 @GET
	 @Produces(MediaType.TEXT_HTML)
	 public String returnTitle(){
		  return "java web services";
	 }
	 
	 
	 
	 @Path("/version")
		@GET
		@Produces(MediaType.TEXT_HTML)
		public String returnVersion() {
			return "<p>Version:</p>" + api_version;
		}
	 
	 
	 @Path("/database")
		@GET
		@Produces(MediaType.TEXT_HTML)
	 public String returnDatabaseStatus() throws Exception {
		 PreparedStatement query = null;
		 String myString = null;
		 String returnString = null;
		
		 Oracle308tube ot = new Oracle308tube();
		 try{
			 
		query=ot.getConnection().prepareStatement("select * from customers");
		ResultSet rs = query.executeQuery();
		while(rs.next()){
			myString = rs.getString(3);
		}
		returnString = "Database Status" +" "+ myString;
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		 finally {
			query.close();
		}
		return returnString;
	 }
}
