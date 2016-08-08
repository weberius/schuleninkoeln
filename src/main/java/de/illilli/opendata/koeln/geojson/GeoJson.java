package de.illilli.opendata.koeln.geojson;

import java.util.Map;

import org.geojson.GeoJsonObject;

public interface GeoJson {

	String getId();

	Map<String, Object> getProperties();

	GeoJsonObject getGeometry();

	String getType();

}
