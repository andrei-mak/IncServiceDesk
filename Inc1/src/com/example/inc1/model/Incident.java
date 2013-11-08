package com.example.inc1.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Incident {

	private String id;
	private String shortDescription;
	private String techResolution;

	public Incident() {

	}

	public Incident(String id, String shortDescription) {
		this.id = id;
		this.shortDescription = shortDescription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getTechResolution() {
		return techResolution;
	}

	public void setTechResolution(String techResolution) {
		this.techResolution = techResolution;
	}

}
