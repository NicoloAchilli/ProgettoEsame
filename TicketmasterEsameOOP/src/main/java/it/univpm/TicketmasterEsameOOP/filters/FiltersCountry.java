package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.statistics.EventStats;

public class FiltersCountry{

	public JSONObject FilterCountry (String country,Vector<Event>  e) {
		
		EventStats stats=new EventStats();
		
		Vector<Event>  eventiFilteredByCountry = new Vector<Event>();
		for(Event ef: e) {
			if(country.equals(ef.getCountryName()));
				eventiFilteredByCountry.add(ef);
			}
		return 	stats.TotEventi(eventiFilteredByCountry);
}
}

