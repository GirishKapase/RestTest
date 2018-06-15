package com.rest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/dataRead")
public class RestService {

	@GET
	//@Path("/{param}")
	public Response getMsg() {
 
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(
					"c:/DataFile.properties"));
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ParseException e) {		
			e.printStackTrace();
		}

		JSONObject jsonObject = (JSONObject) obj;

		JSONArray jsonNumbers = (JSONArray) jsonObject.get("array");
		int total = 0;
		
		Iterator i = jsonNumbers.iterator();
		while(i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			
			System.out.println(innerObj);
			List<String> al= (List<String>)innerObj.get("numbers");			
			for(String s : al) {				
				System.out.println(s);
				total = total + Integer.parseInt(s);
			}
			System.out.println("total: "+total);
		}
		String output = jsonObject.toJSONString()+ "\n Total summation is: " + total; 
		return Response.status(200).entity(output).build(); 
	} 
}