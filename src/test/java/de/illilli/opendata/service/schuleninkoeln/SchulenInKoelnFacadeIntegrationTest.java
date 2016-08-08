package de.illilli.opendata.service.schuleninkoeln;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.Facade;

/**
 * Dieser Test liest die Daten von
 * http://www.offenedaten-koeln.de/dataset/schulen-k%C3%B6ln aus und vergleicht
 * sie mit bereits vorhandenen Daten. Dadurch wird geprüft, ob es zu
 * Veränderungen gekommen ist. Es handelt sich hierbei um einen Integrationstest.
 */
public class SchulenInKoelnFacadeIntegrationTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException, URISyntaxException {
		InputStream inputStream = this.getClass().getResourceAsStream("/schuleninkoeln.json");
		Facade facade = new SchulenInKoelnFacade();
		String expected = IOUtils.toString(inputStream);
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);
	}

}
