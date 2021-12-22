package it.univpm.TicketmasterEsameOOP.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {
	
	abstract JSONObject getJSONEventsPL();
	abstract void parse() throws org.json.simple.parser.ParseException;
	abstract JSONObject getJSONEvents(String country);
	//abstract Event getEvent(JSONObject event);
	//abstract public JSONObject getstat();
}
