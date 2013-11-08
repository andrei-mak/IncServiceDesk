package com.example.inc1.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.example.inc1.model.Incident;

/**
 * Data Access Object for Incidents
 */
public class IncidentDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM Incidents ORDER BY Id";

	public Map<String, Incident> getModel() {
		Map<String, Incident> incidentsList = new HashMap<String, Incident>();
		Connection c = ConnectionHelper.getConnection();
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(SQL_SELECT_ALL);
			while (rs.next()) {
				// Read incident Id and incident object
				incidentsList.put(processRow(rs).getId(),processRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return incidentsList;
	}
	
	protected Incident processRow(ResultSet rs) throws SQLException {
		Incident incident = new Incident();
        incident.setId(rs.getString("Id"));
        incident.setShortDescription(rs.getString("ShortDescription"));
        incident.setTechResolution(rs.getString("TechResolution"));
        return incident;
    }

}
