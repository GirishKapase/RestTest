package com.rest.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParserTest {

	public static void main(String[] args) {

		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(new FileReader(new File("c:/DataFile.properties")));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println("current dir = " + System.getProperty("user.dir"));
		File currentDirectory = new File(new File(".").getAbsolutePath());
		System.out.println(currentDirectory.getAbsolutePath());
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray jsonNumbers = (JSONArray) jsonObject.get("array");
		int total = 0;
		Iterator i = jsonNumbers.iterator();
		while(i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			
			
			List<String> al= (List<String>)innerObj.get("numbers");
			
			for(String s : al) {
				
				System.out.println(s);
				total = total + Integer.parseInt(s);
			}
			System.out.println("total: "+total);
		}	
	}
}
