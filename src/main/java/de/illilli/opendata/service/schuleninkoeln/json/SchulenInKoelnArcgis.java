package de.illilli.opendata.service.schuleninkoeln.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import de.illilli.opendata.koeln.arcgis.Feature;
import de.illilli.opendata.koeln.arcgis.FieldAliases;
import de.illilli.opendata.koeln.arcgis.Fields;
import de.illilli.opendata.koeln.arcgis.SpatialReference;

/**
 * Dieses Objekt wird für die Konvertierung der Schulen in Köln Daten
 * (http://www.offenedaten-koeln.de/dataset/schulen-k%C3%B6ln) benötigt. Es ist
 * die deserialisierte Form der dort vorgehaltenen JSON Daten.
 */
public class SchulenInKoelnArcgis {

	@JsonProperty("displayFieldName")
	String displayFieldName;
	@JsonProperty("fieldAliases")
	FieldAliases fieldAliases;
	@JsonProperty("geometryType")
	String geometryType;
	@JsonProperty("spatialReference")
	SpatialReference spatialReference;
	@JsonProperty("fields")
	List<Fields> fields;
	@JsonProperty("features")
	List<Feature> features;

	public String getDisplayFieldName() {
		return displayFieldName;
	}

	public void setDisplayFieldName(String displayFieldName) {
		this.displayFieldName = displayFieldName;
	}

	public FieldAliases getFieldAliases() {
		return fieldAliases;
	}

	public void setFieldAliases(FieldAliases fieldAliases) {
		this.fieldAliases = fieldAliases;
	}

	public String getGeometryType() {
		return geometryType;
	}

	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	public SpatialReference getSpatialReference() {
		return spatialReference;
	}

	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayFieldName == null) ? 0 : displayFieldName.hashCode());
		result = prime * result + ((features == null) ? 0 : features.hashCode());
		result = prime * result + ((fieldAliases == null) ? 0 : fieldAliases.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + ((geometryType == null) ? 0 : geometryType.hashCode());
		result = prime * result + ((spatialReference == null) ? 0 : spatialReference.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchulenInKoelnArcgis other = (SchulenInKoelnArcgis) obj;
		if (displayFieldName == null) {
			if (other.displayFieldName != null)
				return false;
		} else if (!displayFieldName.equals(other.displayFieldName))
			return false;
		if (features == null) {
			if (other.features != null)
				return false;
		} else if (!features.equals(other.features))
			return false;
		if (fieldAliases == null) {
			if (other.fieldAliases != null)
				return false;
		} else if (!fieldAliases.equals(other.fieldAliases))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (geometryType == null) {
			if (other.geometryType != null)
				return false;
		} else if (!geometryType.equals(other.geometryType))
			return false;
		if (spatialReference == null) {
			if (other.spatialReference != null)
				return false;
		} else if (!spatialReference.equals(other.spatialReference))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArcGisJsonObject [displayFieldName=" + displayFieldName + ", fieldAliases=" + fieldAliases
				+ ", geometryType=" + geometryType + ", spatialReference=" + spatialReference + ", fields=" + fields
				+ ", features=" + features + "]";
	}

}
