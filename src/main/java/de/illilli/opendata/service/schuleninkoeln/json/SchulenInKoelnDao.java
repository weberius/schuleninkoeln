package de.illilli.opendata.service.schuleninkoeln.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opendata.koeln.arcgis.Feature;
import de.illilli.opendata.koeln.arcgis.FieldAliases;
import de.illilli.opendata.koeln.geojson.GeoJsonBo;

public class SchulenInKoelnDao {

	private final static Logger logger = Logger
			.getLogger(SchulenInKoelnDao.class);
	private List<GeoJsonBo> geoJsonBoList;

	/**
	 * Verwandelt alle Schulen in eine GeoJson Liste.
	 * 
	 * @param schulenInKoeln
	 */
	public SchulenInKoelnDao(SchulenInKoeln schulenInKoeln) {
		geoJsonBoList = new ArrayList<GeoJsonBo>();
		List<Feature> features = schulenInKoeln.getFeatures();
		FieldAliases fieldAliases = schulenInKoeln.getFieldAliases();
		for (Feature feature : features) {
			logger.debug(feature.getAttributes().getSchulart());
			geoJsonBoList.add(new SchulenInKoelnBo(feature, fieldAliases));
		}
	}

	/**
	 * Verwandelt die Schulen in Koeln unterschieden nach Schulart in eine
	 * GeoJson Liste.
	 * 
	 * @param schulenInKoeln
	 * @param schulart
	 */
	public SchulenInKoelnDao(SchulenInKoeln schulenInKoeln, String schulart) {
		geoJsonBoList = new ArrayList<GeoJsonBo>();
		List<Feature> features = schulenInKoeln.getFeatures();
		FieldAliases fieldAliases = schulenInKoeln.getFieldAliases();
		for (Feature feature : features) {
			if (feature.getAttributes().getSchulart().toLowerCase()
					.equals(schulart.toLowerCase())) {
				geoJsonBoList.add(new SchulenInKoelnBo(feature, fieldAliases));
				logger.debug(feature.getAttributes().getSchulart());
			}
		}
	}

	public List<GeoJsonBo> getGeoJsonBoList() {
		return this.geoJsonBoList;
	}
}
