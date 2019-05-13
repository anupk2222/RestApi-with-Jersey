package com.webservices.rest.inventory;

import java.util.ArrayList;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

//import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.webservices.dao.Schema308tube;
import com.webservices.exception.ItemNotFoundException;


@Path("/v2/inventory")
public class V2_inventory {

	
	private Object List;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrandParts(@QueryParam("brand") String brand)throws Exception {
		
		String returnString = null;
		JSONArray json = new JSONArray();
		
		
		try {
			
			//return a error is brand is missing from the url string
			if(brand == null) {
				
				return Response.status(400).entity("Error: please specify brand for this search").build();
			}
			
			Schema308tube dao = new Schema308tube();
			
			json = dao.queryReturnBrandParts(brand);
			returnString = json.toString();
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	@Path("/{brand}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnBrand(@PathParam("brand") String brand) throws Exception {
		
		String returnString = null;
		
		JSONArray json = new JSONArray();
		
		try {
			
			Schema308tube dao = new Schema308tube();
			
			json = dao.queryReturnBrandParts(brand);
			returnString = json.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	@Path("/{brand}/{item_number}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnSpecificBrandItem(@PathParam("brand") String brand,@PathParam("item_number") String item_number) throws Exception {
		
		String returnString = null;
		
		JSONArray json = new JSONArray();
		
		try {
			
			if(item_number==null){
				throw new ItemNotFoundException("please specify the Item number for particular brand");
			}
			
			Schema308tube dao = new Schema308tube();
			
			json = dao.queryReturnBrandItemNumber(brand, item_number);
			returnString = json.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	
	@POST
	@Path("/insert")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	/*public Response addPcParts(@FormParam("PC_PARTS_PK") String PC_PARTS_PK,@FormParam("PC_PARTS_TITLE") String PC_PARTS_TITLE,
			                   @FormParam("PC_PARTS_CODE") String PC_PARTS_CODE,@FormParam("PC_PARTS_MAKER") String PC_PARTS_MAKER,
			                   @FormParam("PC_PARTS_AVAIL") String PC_PARTS_AVAIL,@FormParam("PC_PARTS_DESC") String PC_PARTS_DESC) throws Exception {*/
	public Response addPcParts(PcParts parts) throws Exception {
		
		String returnString = null;
		//JSONArray json = new JSONArray(); 
		Schema308tube dao = new Schema308tube();
		
		try {
			System.out.println("incomingData: " );
			
			/*
			 * ObjectMapper is from Jackson Processor framework
			 * http://jackson.codehaus.org/
			 * 
			 * Using the readValue method, you can parse the json from the http request
			 * and data bind it to a Java Class.
			 */
			/*ObjectMapper mapper = new ObjectMapper();  
			ItemEntry itemEntry = mapper.readValue(incomingData, ItemEntry.class);
			
			int http_code = dao.insertIntoPC_PARTS(itemEntry.PC_PARTS_TITLE, 
													itemEntry.PC_PARTS_CODE, 
													itemEntry.PC_PARTS_MAKER, 
													itemEntry.PC_PARTS_AVAIL, 
													itemEntry.PC_PARTS_DESC );*/
			
			//int http_code = dao.insertIntoPC_PARTS(PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL, PC_PARTS_DESC);
			int http_code = dao.insertIntoPC_PARTS(parts);
			
			if( http_code == 200 ) {
				//returnString = jsonArray.toString();
				
				JSONObject jps = new JSONObject(parts);
				returnString = jps.toString();
				//returnString = "Item Insterted";
			} else {
				
				/*com.webservices.rest.inventory.ErrorMessage errorMessage = new com.webservices.rest.inventory.ErrorMessage("Unable to process Item", 500, "httP://google.com");
				Response response =  Response.status(Status.NOT_FOUND)
						.entity(errorMessage)
						.build();
				return response;*/
				return Response.status(500).entity("Unable to process Item").build();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			/*com.webservices.rest.inventory.ErrorMessage errorMessage = new com.webservices.rest.inventory.ErrorMessage("Server was not able to process your request", 500, "httP://google.com");
			Response response =  Response.status(Status.NOT_FOUND)
					.entity(errorMessage)
					.build();
			//return response;*/
			return Response.status(500).entity("Server was not able to process your request").build();
		}
			
		
		return Response.ok(returnString).build();
	}
	
	
	
	
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	
	/*public Response addPcParts(@FormParam("PC_PARTS_PK") String PC_PARTS_PK,@FormParam("PC_PARTS_TITLE") String PC_PARTS_TITLE,
			                   @FormParam("PC_PARTS_CODE") String PC_PARTS_CODE,@FormParam("PC_PARTS_MAKER") String PC_PARTS_MAKER,
			                   @FormParam("PC_PARTS_AVAIL") String PC_PARTS_AVAIL,@FormParam("PC_PARTS_DESC") String PC_PARTS_DESC) throws Exception {*/
	public Response updatePcParts(PcParts parts) throws Exception {
		
		String returnString = null;
		JSONArray json = new JSONArray(); 
		Schema308tube dao = new Schema308tube();
		
		try {
			System.out.println("incomingData: " );
			
			/*
			 * ObjectMapper is from Jackson Processor framework
			 * http://jackson.codehaus.org/
			 * 
			 * Using the readValue method, you can parse the json from the http request
			 * and data bind it to a Java Class.
			 */
			/*ObjectMapper mapper = new ObjectMapper();  
			ItemEntry itemEntry = mapper.readValue(incomingData, ItemEntry.class);
			
			int http_code = dao.insertIntoPC_PARTS(itemEntry.PC_PARTS_TITLE, 
													itemEntry.PC_PARTS_CODE, 
													itemEntry.PC_PARTS_MAKER, 
													itemEntry.PC_PARTS_AVAIL, 
													itemEntry.PC_PARTS_DESC );*/
			
			//int http_code = dao.insertIntoPC_PARTS(PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL, PC_PARTS_DESC);
			int http_code = dao.updatePC_PARTS(parts);
			
			if( http_code == 200 ) {
				//returnString = jsonArray.toString();
				JSONObject jup = new JSONObject(parts);
				returnString = jup.toString();
				//returnString = "Item Updated";
			} else {
				return Response.status(500).entity("Unable to process Item").build();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}
	
	@Path("/{pk}")
	@DELETE
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED,MediaType.APPLICATION_JSON})
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
	public Response deletePcParts(@PathParam("pk") String pk) throws Exception {
		
		String returnString = null;
		
		
		
		//JSONArray json = new JSONArray();
		
		try {
			
			
			Schema308tube dao = new Schema308tube();
			
			int http_code = dao.deletePC_PARTS(pk);
			
		
		if( http_code == 200 ) {
			//returnString = jsonArray.toString();
			returnString = "Item Deleted";
		} else {
			return Response.status(500).entity("Unable to process Item").build();
		}
		    }
		catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("Server was not able to process your request").build();
		}
		
		return Response.ok(returnString).build();
	}
 }

