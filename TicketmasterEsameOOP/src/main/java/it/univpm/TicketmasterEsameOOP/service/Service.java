package it.univpm.TicketmasterEsameOOP.service;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {

	abstract JSONObject getTypeEvent(String type);
	abstract JSONObject getJSONEventsPL();
	abstract String getJSONEvents(String country);
	//abstract Event getEvent(JSONObject event);
	//abstract String toJSONOString (JSONObject obj);
}
