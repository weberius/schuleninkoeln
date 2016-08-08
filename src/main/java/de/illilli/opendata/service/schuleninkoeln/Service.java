package de.illilli.opendata.service.schuleninkoeln;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Path("/service")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * Dieser Service wandelt den argis-Service von Offene Daten K&ouln;ln in
	 * ein GeoJson - Struktur. Es werden alle Schulen ausgeliefert.
	 * <p>
	 * Beispiel:
	 * <a href="http://localhost:8080/schuleninkoeln/service/straight">
	 * /schuleninkoeln/service/straight</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/straight")
	public String getKoeln() throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		// setze das Character-Encoding fuer die Antwort auf UTF-8
		response.setCharacterEncoding("UTF-8");
		logger.debug("requesting schulen in koeln");
		return new SchulenInKoelnFacade().getJson();
	}

}
