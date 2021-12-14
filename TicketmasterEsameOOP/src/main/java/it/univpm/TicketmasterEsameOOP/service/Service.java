package it.univpm.TicketmasterEsameOOP.service;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {

	abstract JSONObject toJSON(Country country);
	abstract JSONObject getJSONEvents(String country);
	abstract Event getEvent(JSONObject event);
}
