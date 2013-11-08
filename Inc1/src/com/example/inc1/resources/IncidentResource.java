package com.example.inc1.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import com.example.inc1.dao.IncidentDao;
import com.example.inc1.model.Incident;

public class IncidentResource {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	String id;

	public IncidentResource(UriInfo uriInfo, Request request, String id) {
		this.uriInfo = uriInfo;
		this.request = request;
		this.id = id;
	}

	// Application integration
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Incident getIncident() {
		IncidentDao incidentDao = new IncidentDao();
		Incident incident = incidentDao.getModel().get(id);
		if (incident == null)
			throw new RuntimeException("Get: Incident with " + id
					+ " not found");
		return incident;
	}

	// for the browser test
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Incident getIncidentHTML() {
		IncidentDao incidentDao = new IncidentDao();
		Incident incident = incidentDao.getModel().get(id);
		if (incident == null)
			throw new RuntimeException("Get: Incident with " + id
					+ " not found");
		return incident;
	}

}
