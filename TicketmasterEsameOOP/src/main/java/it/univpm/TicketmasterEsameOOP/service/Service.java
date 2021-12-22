package it.univpm.TicketmasterEsameOOP.service;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {

	abstract JSONObject toJson(Country country);
	abstract JSONObject getTypeEvent();
	abstract JSONObject getJSONEventsPL();
	abstract JSONObject getJSONEvents(String country);
	abstract Country getEvent(JSONObject obj);
	//abstract String toJSONOString (JSONObject obj);
}
