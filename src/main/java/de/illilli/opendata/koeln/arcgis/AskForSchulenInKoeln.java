package de.illilli.opendata.koeln.arcgis;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.schuleninkoeln.json.SchulenInKoelnArcgis;

/**
 * Diese Klasse holt sich die Informationen zu den Schulen in Koeln. Dies kann
 * entweder direkt gegen von den offenen Daten Köln kommen oder von einer Datei.
 * Am besten wäre es, wenn zunächst der Offene Daten-Server konsultiert würde
 * und dann die Antwort ins File-System gelegt würde. Danach kann sie dann
 * eingelesen werden.
 * 
 * @author wolfram
 *
 */
public class AskForSchulenInKoeln implements AskFor<SchulenInKoelnArcgis> {

	public static final String SCHULEN_IN_KOELN_URL = Config.getProperty("odk.schuleninkoeln.url");

	private static final Logger logger = Logger.getLogger(AskForSchulenInKoeln.class);
	private SchulenInKoelnArcgis schulenInKoeln;

	public AskForSchulenInKoeln() throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		this(new URL(SCHULEN_IN_KOELN_URL).openStream());
	}

	public AskForSchulenInKoeln(InputStream inputStream)
			throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		ObjectMapper mapper = new ObjectMapper();
		schulenInKoeln = mapper.readValue(inputStream, SchulenInKoelnArcgis.class);
		logger.debug(schulenInKoeln.toString());
	}

	@Override
	public SchulenInKoelnArcgis getData() {
		return schulenInKoeln;
	}

}
