package org.bikeroutes.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * 
 * @author Ivan
 */

@Path("/bikeroutesservice")
public class BikeRoutesService {

	@GET
	@Produces("application/xml")
	public String convertCtoF() {
 
		Double fahrenheit;
		Double celsius = 36.8;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "Output: \nC to F Converter Output: \n\n" + fahrenheit;
		return "<bikeroutesservice>" 
				+ "<celsius>" 
				+ celsius + "</celsius>" 
				+ "<bikeroutesoutput>" 
				+ result + "</bikeroutesoutput>" 
				+ "</bikeroutesservice>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c") Double c) {
		Double fahrenheit;
		Double celsius = c;
		fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<bikeroutesservice>" + "<celsius>" + celsius + "</celsius>" + "<bikeroutesoutput>" + result + "</bikeroutesoutput>" + "</bikeroutesservice>";
	}
}
