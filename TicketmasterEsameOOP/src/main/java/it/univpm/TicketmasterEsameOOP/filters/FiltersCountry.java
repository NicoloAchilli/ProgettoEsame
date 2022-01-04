package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class FiltersCountry extends Filters{

	public FiltersCountry(String value) {
		super(value);
	}


	public Vector<Event> FilterByCountry (String country) {
		
		Vector<Event> eventiFiltratiCountry = new Vector<Event>();
		
		for (Event eventiTemp : c.getEvent()) {
			if(country.equals(eventiTemp.getCountryName()))
				eventiFiltratiCountry.add(eventiTemp);
			}	
		return eventiFiltratiCountry;
		
	}

}
