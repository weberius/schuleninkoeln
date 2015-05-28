package de.illilli.opendata.service.schuleninkoeln;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.koeln.arcgis.AskForSchulenInKoeln;
import de.illilli.opendata.koeln.geojson.GeoJsonBo;
import de.illilli.opendata.service.schuleninkoeln.json.SchulenInKoeln;
import de.illilli.opendata.service.schuleninkoeln.json.SchulenInKoelnDao;

public class SchulenInKoelnFacade implements Facade {

	private String json;

	private static final Logger logger = Logger
			.getLogger(SchulenInKoelnFacade.class);

	public SchulenInKoelnFacade() throws JsonParseException,
			JsonMappingException, IOException, URISyntaxException {
		SchulenInKoeln schulenInKoeln = new AskForSchulenInKoeln()
				.getSchulenInKoeln();
		// 2. Use Dao for converting to Bo
		SchulenInKoelnDao dao = new SchulenInKoelnDao(schulenInKoeln);
		// 3. change to feature List
		List<GeoJsonBo> geoJsonBoList = dao.getGeoJsonBoList();
		// 4. Prepare FeatureCollection; other features can be added.
		FeatureCollection featureCollection = new FeatureCollection();
		for (GeoJsonBo geoJsonBo : geoJsonBoList) {
			Feature feature = new Feature();
			feature.setGeometry(geoJsonBo.getGeometry());
			feature.setProperties(geoJsonBo.getProperties());
			feature.setId(geoJsonBo.getId());
			featureCollection.add(feature);
		}

		logger.debug("return " + geoJsonBoList.size() + " of pois");
		// 5. get GeoJson - String
		json = new ObjectMapper().writeValueAsString(featureCollection);
	}

	@Override
	public String getJson() {
		return json;
	}

}
