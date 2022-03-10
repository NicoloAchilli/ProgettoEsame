package it.univpm.TicketmasterEsameOOP.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.statistics.Statistics;

public interface Service {

	
	abstract JSONObject getJSONEventsPL();
	abstract Vector<Event> parse(JSONObject obj1) throws org.json.simple.parser.ParseException;
	abstract JSONObject toJson(Event event);
	abstract Evento parsingbodyfilter(JSONObject bodyFilter);

	abstract JSONObject getJSONEvents(String country);

}
