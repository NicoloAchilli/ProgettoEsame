package it.univpm.TicketmasterEsameOOP.service;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;

/**
 *Interfaccia di Service che contiene i metodi richiamati dal Controller
 *
 */

public interface service{

	
	abstract JSONObject getJSONEventsPL();
	abstract Vector<Event> parse(JSONObject obj1) throws org.json.simple.parser.ParseException, EventiException;
	abstract JSONObject toJson(Event event);
	abstract Evento parsingbodyfilter(JSONObject bodyFilter);

	abstract JSONObject getJSONEvents(String country);

}
