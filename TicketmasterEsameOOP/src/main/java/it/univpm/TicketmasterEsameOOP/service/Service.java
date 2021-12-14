package it.univpm.TicketmasterEsameOOP.service;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {

	abstract JSONObject toJSON(Event event);
	abstract JSONObject getJSONEvents(String event);
	//abstract Event getEvent()
}
