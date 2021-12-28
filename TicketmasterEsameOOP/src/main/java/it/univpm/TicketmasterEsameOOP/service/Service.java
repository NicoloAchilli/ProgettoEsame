package it.univpm.TicketmasterEsameOOP.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public interface Service {

	
	abstract JSONObject getJSONEventsPL();
	abstract Country parse(JSONObject obj1) throws org.json.simple.parser.ParseException;
	abstract JSONObject toJson(Country country);
		
	
	//abstract JSONObject getTypeEvent();	
	//abstract JSONObject getJSONEventsPL();
	abstract JSONObject getJSONEvents(String country);
	//abstract Country getEvent(JSONObject obj);
	//abstract String toJSONOString (JSONObject obj);

}
