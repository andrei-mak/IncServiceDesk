package com.example.inc1.resources;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.example.inc1.dao.IncidentDao;
import com.example.inc1.model.Incident;

//Will map the resource to the URL
@Path("/incidents")
public class IncidentsResouce {
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	// Return the list of incidents for applications
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Incident> getIncidents() {
		List<Incident> incidents = new ArrayList<Incident>();
		IncidentDao incidentDao = new IncidentDao();
		incidents.addAll(incidentDao.getModel().values());
		return incidents;
	}

	// Return the list of incidents to the user in the browser
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Incident> getIncidentsBrowser() {
		List<Incident> incidents = new ArrayList<Incident>();
		IncidentDao incidentDao = new IncidentDao();
		incidents.addAll(incidentDao.getModel().values());
		return incidents;
	}

	@Path("{id}")
	// @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public IncidentResource getIncident(@PathParam("id") String id) {
		return new IncidentResource(uriInfo, request, id);
	}

}
