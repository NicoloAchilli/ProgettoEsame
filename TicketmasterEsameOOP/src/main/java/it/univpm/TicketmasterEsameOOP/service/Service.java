package it.univpm.TicketmasterEsameOOP.service;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {

	abstract String getTypeEvent(String type);
	abstract String getJSONEventsPL();
	//abstract Event getEvent(JSONObject event);
}
