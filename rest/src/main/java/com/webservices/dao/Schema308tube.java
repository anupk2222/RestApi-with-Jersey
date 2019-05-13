package com.webservices.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.webservices.rest.inventory.Address;
import com.webservices.rest.inventory.PcParts;
//import com.webservices.util.ToJSON;

public class Schema308tube {
	
	Oracle308tube ot = new Oracle308tube();
	int count=0;

public JSONArray queryAllPcParts() throws Exception {
		
		PreparedStatement query = null;
		//ToJSON converter = new ToJSON();
		JSONArray json = new JSONArray();
		int pk=0 , avail=0;
		String title = null, code=null,maker=null,desc=null,city=null,street=null,zip=null;
		
		try {
			
			query = ot.getConnection().prepareStatement("select PC_PARTS_PK, PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL, PC_PARTS_DESC,"
					+ "PC_PARTS_CITY,PC_PARTS_STREET,PC_PARTS_ZIP from PC_PARTS");
			
			ResultSet rs = query.executeQuery();
			 JSONArray jsonarr = new JSONArray();
			 while(rs.next()) {
			 pk = rs.getInt(1);
			 title = rs.getString(2);
			 code = rs.getString(3);
			 maker = rs.getString(4);
			 avail = rs.getInt(5);
			 desc = rs.getString(6);
			 city=rs.getString(7);
			 street=rs.getString(8);
			 zip=rs.getString(9);
	          	
	            JSONObject jsonobj = new JSONObject();
	            jsonobj.put("PC_PARTS_PK", pk);
	            jsonobj.put("PC_PARTS_TITLE", title);
	            jsonobj.put("PC_PARTS_CODE", code);
	            jsonobj.put("PC_PARTS_MAKER", maker);
	            jsonobj.put("PC_PARTS_AVAIL", avail);
	            jsonobj.put("PC_PARTS_DESC", desc);
	            
	           JSONObject address = new JSONObject(); 
	           
	           address.put("PC_PARTS_CITY", city);
	           address.put("PC_PARTS_STREET", street);
	           address.put("PC_PARTS_ZIP", zip);
	            
	            
	            jsonobj.put("PC_PARTS_ADDRESS", address);
	            
	            jsonarr.put(jsonobj);
			 
			 }
	            json=jsonarr;
			//json = converter.toJSONArray(rs);
			 //close connection 
		}
		catch(SQLException sqlError) {
			sqlError.printStackTrace();
			return json;
		}
		catch(Exception e) {
			e.printStackTrace();
			return json;
		}
		finally {
			query.close();
		}
		
		return json;
	}


  public JSONArray queryReturnBrandParts(String brand) throws Exception {
	
	PreparedStatement query = null;
	
	//ToJSON converter = new ToJSON();
	JSONArray json = new JSONArray();
	int pk=0 , avail=0;
	String title = null, code=null,maker=null,desc=null,city=null,street=null,zip=null;
	try {
		
		query = ot.getConnection().prepareStatement("select PC_PARTS_PK, PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL,"
				                                  + " PC_PARTS_DESC,PC_PARTS_CITY,PC_PARTS_STREET,PC_PARTS_ZIP "
				                                  + "from PC_PARTS where UPPER(PC_PARTS_MAKER) = ? ");
		
		query.setString(1, brand.toUpperCase()); //protect against sql injection
		ResultSet rs = query.executeQuery();
		JSONArray jsonarr = new JSONArray();
		while(rs.next()) {
			 pk = rs.getInt(1);
			 title = rs.getString(2);
			 code = rs.getString(3);
			 maker = rs.getString(4);
			 avail = rs.getInt(5);
			 desc = rs.getString(6);
			 city=rs.getString(7);
			 street=rs.getString(8);
			 zip=rs.getString(9);
	        
	            	
	            JSONObject jsonobj = new JSONObject();
	            jsonobj.put("PC_PARTS_PK", pk);
	            jsonobj.put("PC_PARTS_TITLE", title);
	            jsonobj.put("PC_PARTS_CODE", code);
	            jsonobj.put("PC_PARTS_MAKER", maker);
	            jsonobj.put("PC_PARTS_AVAIL", avail);
	            jsonobj.put("PC_PARTS_DESC", desc);
	            
	           JSONObject address = new JSONObject(); 
	           
	           address.put("PC_PARTS_CITY", city);
	           address.put("PC_PARTS_STREET", street);
	           address.put("PC_PARTS_ZIP", zip);
	            
	            
	            jsonobj.put("PC_PARTS_ADDRESS", address);
	            
	            jsonarr.put(jsonobj);
	            }
	            json=jsonarr;
		
		//json = converter.toJSONArray(rs);
		 //close connection
	}
	catch(SQLException sqlError) {
		sqlError.printStackTrace();
		return json;
	}
	catch(Exception e) {
		e.printStackTrace();
		return json;
	}
	finally {
		query.close();
	}
	
	return json;
  }
  
  public JSONArray queryReturnBrandItemNumber(String brand, String item_number) throws Exception {
		
		PreparedStatement query = null;
	
		//ToJSON converter = new ToJSON();
		JSONArray json = new JSONArray();
		int pk=0 , avail=0;
		String title = null, code=null,maker=null,desc=null,city=null,street=null,zip=null;
		try {
			
			query = ot.getConnection().prepareStatement("select PC_PARTS_PK, PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL, "
					                        + "PC_PARTS_DESC, PC_PARTS_CITY, PC_PARTS_STREET, PC_PARTS_ZIP " +
											"from PC_PARTS " +
											"where UPPER(PC_PARTS_MAKER) = ? " +
											"and PC_PARTS_CODE = ?");
			
			/*
			 * protect against sql injection
			 * when you have more than one ?, it will go in chronological
			 * order.
			 */
			query.setString(1, brand.toUpperCase()); //first ?
			query.setString(2, item_number); //second ?
			ResultSet rs = query.executeQuery();
			JSONArray jsonarr = new JSONArray();
			while(rs.next()) {
				 pk = rs.getInt(1);
				 title = rs.getString(2);
				 code = rs.getString(3);
				 maker = rs.getString(4);
				 avail = rs.getInt(5);
				 desc = rs.getString(6);
				 city=rs.getString(7);
				 street=rs.getString(8);
				 zip=rs.getString(9);
		        
		            	
		            JSONObject jsonobj = new JSONObject();
		            jsonobj.put("PC_PARTS_PK", pk);
		            jsonobj.put("PC_PARTS_TITLE", title);
		            jsonobj.put("PC_PARTS_CODE", code);
		            jsonobj.put("PC_PARTS_MAKER", maker);
		            jsonobj.put("PC_PARTS_AVAIL", avail);
		            jsonobj.put("PC_PARTS_DESC", desc);
		            
		           JSONObject address = new JSONObject(); 
		           
		           address.put("PC_PARTS_CITY", city);
		           address.put("PC_PARTS_STREET", street);
		           address.put("PC_PARTS_ZIP", zip);
		            
		            
		            jsonobj.put("PC_PARTS_ADDRESS", address);
		            
		            jsonarr.put(jsonobj);
		            }
		            json=jsonarr;
			
			//json = converter.toJSONArray(rs);
			query.close(); //close connection
		}
		catch(SQLException sqlError) {
			sqlError.printStackTrace();
			return json;
		}
		catch(Exception e) {
			e.printStackTrace();
			return json;
		}
		finally {
			query.close();
		}
		
		return json;
	}

  
     public int insertIntoPC_PARTS(PcParts parts) throws Exception {
    
	  /*public int insertIntoPC_PARTS(String PC_PARTS_TITLE, String PC_PARTS_CODE, String PC_PARTS_MAKER, String PC_PARTS_AVAIL,
    		String PC_PARTS_DESC) throws Exception {*/
    	
     Connection con = null;
     
       PreparedStatement query = null;
       String sql ="insert into PC_PARTS (PC_PARTS_PK,PC_PARTS_TITLE, PC_PARTS_CODE, PC_PARTS_MAKER, PC_PARTS_AVAIL, PC_PARTS_DESC, PC_PARTS_CITY, PC_PARTS_STREET, PC_PARTS_ZIP) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";
    //JSONArray json = new JSONArray();
      
         try {
            con = ot.getConnection();
           // Address address = parts.getAddress();
            query = con.prepareStatement(sql);
            
                        
            			 int pkInt = Integer.parseInt(parts.getPC_PARTS_PK());
                         query.setInt(1, pkInt);
                         query.setString(2, parts.getPC_PARTS_TITLE());
                         query.setString(3, parts.getPC_PARTS_CODE());

                         query.setString(4, parts.getPC_PARTS_MAKER());
                         int avilInt = Integer.parseInt(parts.getPC_PARTS_AVAIL());
                         query.setInt(5, avilInt);

                         query.setString(6, parts.getPC_PARTS_DESC());
                         query.setString(7, parts.address.getCity());
                         query.setString(8, parts.address.getStreet());
                         query.setString(9, parts.address.getZip());
                         query.executeUpdate(); //note the new command for insert statement

         		} catch(Exception e) {
         			e.printStackTrace();
         			 //if a error occurs, return a 500
         		}
         finally {
        	 query.close();
         }

         return 200;
    }
     
     
     public int updatePC_PARTS(PcParts parts) throws Exception {
    	    
   	  /*public int insertIntoPC_PARTS(String PC_PARTS_TITLE, String PC_PARTS_CODE, String PC_PARTS_MAKER, String PC_PARTS_AVAIL,
       		String PC_PARTS_DESC) throws Exception {*/
        
          PreparedStatement query = null;
       //JSONArray json = new JSONArray();
         
            try {
        
               query = ot.getConnection().prepareStatement("UPDATE PC_PARTS SET PC_PARTS_TITLE = ?,"
               		                                        + " PC_PARTS_CODE = ?, PC_PARTS_MAKER = ?,"
               		                                        + " PC_PARTS_AVAIL = ?,PC_PARTS_DESC = ? "
               		                                        + " WHERE PC_PARTS_PK = ?");
               
                          
                          query.setString(1, parts.getPC_PARTS_TITLE());
                          query.setString(2, parts.getPC_PARTS_CODE());

                          query.setString(3, parts.getPC_PARTS_MAKER());
                          int avilInt = Integer.parseInt(parts.getPC_PARTS_AVAIL());
                          query.setInt(4, avilInt);

                          query.setString(5, parts.getPC_PARTS_DESC());
                          
                          int pkInt = Integer.parseInt(parts.getPC_PARTS_PK());
                          query.setInt(6,pkInt);
                            
                          query.executeUpdate(); //note the new command for insert statement

            		} catch(Exception e) {
            			e.printStackTrace();
            			 //if a error occurs, return a 500
            		}
            finally {
           	 query.close();
            }

            return 200;
       }
     
     public int deletePC_PARTS(String pk) throws Exception {
 	    
      	  /*public int insertIntoPC_PARTS(String PC_PARTS_TITLE, String PC_PARTS_CODE, String PC_PARTS_MAKER, String PC_PARTS_AVAIL,
          		String PC_PARTS_DESC) throws Exception {*/
           
             PreparedStatement query = null;
          //JSONArray json = new JSONArray();
            
               try {
           
                  query = ot.getConnection().prepareStatement("delete from PC_PARTS where PC_PARTS_PK = ?");
                  
                                        
                             int pkInt = Integer.parseInt(pk);
                             query.setInt(1,pkInt);
                               
                             query.executeUpdate(); //note the new command for insert statement

               		} catch(Exception e) {
               			e.printStackTrace();
               			 //if a error occurs, return a 500
               		}
               finally {
              	 query.close();
               }

               return 200;
          }
     

}
