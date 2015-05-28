package de.illilli.opendata.service.schuleninkoeln;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class SchulenInKoelnFacadeTest {

	@Test
	public void test() throws JsonParseException, JsonMappingException,
			IOException, URISyntaxException {
		Facade facade = new SchulenInKoelnFacade();
		String json = facade.getJson();
		System.out.println(json);
	}

}
