package de.illilli.opendata.koeln.arcgis;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.koeln.arcgis.AskForSchulenInKoeln;
import de.illilli.opendata.service.schuleninkoeln.json.SchulenInKoeln;

public class AskForSchulenInKoelnSystemTest {

	private static final Logger logger = Logger
			.getLogger(AskForSchulenInKoelnSystemTest.class);

	@Test
	public void testGetSchulenInKoeln() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		AskForSchulenInKoeln askFor = new AskForSchulenInKoeln();
		SchulenInKoeln schulenInKoeln = askFor.getSchulenInKoeln();

		logger.debug(schulenInKoeln);
	}

}
