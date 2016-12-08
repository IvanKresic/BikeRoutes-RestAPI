package org.bikeroutes.restapi;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.bikeroutes.restapi.database.DatabaseConnections;
import org.bikeroutes.restapi.util.ApiResponses;

import com.graphhopper.GraphHopper;
import com.graphhopper.util.PointList;
import com.graphhopper.util.shapes.GHPoint;

/**
 * Top level implementation of RESTfull API for most popular routes and myRoutes
 * 
 * @author Ivan
 */
@Path("/bikeroutesapi")
public class BikeRoutesApi extends DatabaseConnections {

	private ApiResponses apiResponses = new ApiResponses();

	@GET
	@Produces("application/json")
	public Response mostPopularRoutes() throws JSONException {

		apiResponses.getMostPopularRoutes();
		JSONObject jsonObject = new JSONObject();
		getMostPopularRoutes();
		PointList pl;
		Double fahrenheit = 98.24;
		Double celsius;
		celsius = (fahrenheit - 32) * 5 / 9;
		jsonObject.put("F Value", fahrenheit);
		jsonObject.put("C Value", celsius);

		JSONObject result = jsonObject;
		return Response.status(200).entity(result).build();
	}

	@Path("{uuid}")
	@GET
	@Produces("application/json")
	public Response myRoutes(@PathParam("uuid") String uuid) throws JSONException {

		GraphHopper hopper = new GraphHopper();

		JSONObject jsonObject = new JSONObject();

		float celsius;
		// celsius = (f - 32)*5/9;
		jsonObject.put("F Value", uuid);
		// jsonObject.put("C Value", celsius);

		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
