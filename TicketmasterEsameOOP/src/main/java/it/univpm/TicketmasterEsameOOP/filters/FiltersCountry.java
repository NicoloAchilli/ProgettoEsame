package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;

public class FiltersCountry extends Filters{


	@SuppressWarnings("unlikely-arg-type")
	public Vector<Evento> FilterCountry (Evento e) {
		
		Vector<Evento> eventiFilteredByCountry = new Vector<Evento>();
		Event event=new Event();
		for(Evento ef: e) {
			if(ef.equals(e.getStati()));
				eventiFilteredByCountry.add(ef);
			}
		return eventiFilteredByCountry;
}
}
