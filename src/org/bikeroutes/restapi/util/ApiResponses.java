package org.bikeroutes.restapi.util;

import java.util.List;

import org.bikeroutes.restapi.database.DatabaseConnections;
import org.json.JSONObject;

public class ApiResponses{
	
	private DatabaseConnections conn = new DatabaseConnections();	
	
	public JSONObject getMostPopularRoutes()
	{		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("mostPopularRoutesData", conn.getMostPopularRoutes());
		return jsonObject;
	}	
	
	public void getMyRoutes(String uuid)
	{
		
	}	
	
}
