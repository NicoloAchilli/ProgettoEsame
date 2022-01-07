package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class FiltersGenre extends Filters{

public Vector<Event> filterByGenre(String genre,Vector<Event> eventsFilterdeByCoutry) {
	
		Vector<Event> eventiFileredByGenre = new Vector<Event>();
		
		for (Event eventiTemp : eventsFilterdeByCoutry) {	
			if(genre.equals(eventiTemp.getGenreName()))
				eventiFileredByGenre.add(eventiTemp);			
		}
		
		return eventiFileredByGenre;
		
	}
}
