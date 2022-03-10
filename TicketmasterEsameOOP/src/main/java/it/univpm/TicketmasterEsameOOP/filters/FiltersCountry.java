package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class FiltersCountry{

	public JSONObject FilterCountry (String stato,Vector<Event>  e) {
		
		Vector<Event>  eventiFilteredByCountry = new Vector<Event>();
		for(Event ef: e) {
			if(stato.equals(ef.getCountryName()));
				eventiFilteredByCountry.add(ef);
			}
		return eventiFilteredByCountry;
}
}
