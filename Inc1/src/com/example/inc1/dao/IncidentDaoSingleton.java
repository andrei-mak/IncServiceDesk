package com.example.inc1.dao;

import java.util.HashMap;
import java.util.Map;

import com.example.inc1.model.Incident;

/**
 * Class for testing purposes. Contains static data sample.
 */
public enum IncidentDaoSingleton {
	instance;

	private Map<String, Incident> contentProvider = new HashMap<String, Incident>();

	private IncidentDaoSingleton() {

		Incident incident = new Incident("1", "Недоступность внешнего сайта");
		incident.setTechResolution("Выполнен перезапуск сервисов  по инструкции");
		contentProvider.put("1", incident);
		incident = new Incident("2", "Недостаток свободной памяти на сервере");
		incident.setTechResolution("Один из процессов IIS занимал много памяти. Выполнен перезапуск.");
		contentProvider.put("2", incident);
	}

	public Map<String, Incident> getModel() {
		return contentProvider;
	}

}
