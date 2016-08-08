package de.illilli.opendata.koeln.arcgis;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.schuleninkoeln.json.SchulenInKoelnArcgis;

/**
 * Dieser Test prüft, ob die Daten über die AskFor Klasse eingelesen werden
 * kann. Die notwendigen Information liegen als Testdaten vor. kann.
 */
public class AskForSchulenInKoelnTest {

	@Test
	public void testGetSchulenInKoeln()
			throws JsonParseException, JsonMappingException, IOException, URISyntaxException {

		InputStream inputStream = this.getClass().getResourceAsStream("/schuleninkoeln.datensatz.json");

		AskFor<SchulenInKoelnArcgis> askFor = new AskForSchulenInKoeln(inputStream);
		SchulenInKoelnArcgis schulenInKoeln = askFor.getData();
		Assert.assertTrue(schulenInKoeln != null);
	}

}
