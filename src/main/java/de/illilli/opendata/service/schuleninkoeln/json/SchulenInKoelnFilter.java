package de.illilli.opendata.service.schuleninkoeln.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.illilli.opendata.koeln.arcgis.Feature;
import de.illilli.opendata.koeln.arcgis.FieldAliases;
import de.illilli.opendata.koeln.geojson.GeoJson;

/**
 * Diese Klasse filtert aus dem von
 * http://www.offenedaten-koeln.de/dataset/schulen-k%C3%B6ln ausgelieferten
 * arcGis - Objekt eine Liste von SchulenInKoeln heraus und gibt sie als Liste
 * von geoJson Objekten zurück. Für die Konvertierung wird die Klasse
 * SchulenInKoelnGeoJson verwendet.
 */
public class SchulenInKoelnFilter {

	private final static Logger logger = Logger.getLogger(SchulenInKoelnFilter.class);
	private List<GeoJson> geoJsonList;

	/**
	 * Gibt alle Schulen zurück.
	 * 
	 * @param schulenInKoeln
	 */
	public SchulenInKoelnFilter(SchulenInKoelnArcgis schulenInKoeln) {
		geoJsonList = new ArrayList<GeoJson>();
		List<Feature> features = schulenInKoeln.getFeatures();
		FieldAliases fieldAliases = schulenInKoeln.getFieldAliases();
		for (Feature feature : features) {
			geoJsonList.add(new SchulenInKoelnGeoJson(feature, fieldAliases));
			logger.debug(feature.getAttributes().getSchulart());
		}
	}

	/**
	 * Gibt die Schulen nach schulart zurück.
	 * 
	 * @param schulenInKoeln
	 * @param schulart
	 */
	public SchulenInKoelnFilter(SchulenInKoelnArcgis schulenInKoeln, String schulart) {
		geoJsonList = new ArrayList<GeoJson>();
		List<Feature> features = schulenInKoeln.getFeatures();
		FieldAliases fieldAliases = schulenInKoeln.getFieldAliases();
		for (Feature feature : features) {
			if (feature.getAttributes().getSchulart().toLowerCase().equals(schulart.toLowerCase())) {
				geoJsonList.add(new SchulenInKoelnGeoJson(feature, fieldAliases));
				logger.debug(feature.getAttributes().getSchulart());
			}
		}
	}

	public List<GeoJson> getGeoJsonBoList() {
		return this.geoJsonList;
	}
}
