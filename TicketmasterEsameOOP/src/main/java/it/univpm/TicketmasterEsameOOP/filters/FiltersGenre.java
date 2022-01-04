package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import it.univpm.TicketmasterEsameOOP.model.Event;

public class FiltersGenre extends Filters{

	public FiltersGenre(String value) {
		super(value);
	}

public static Vector<Event> filterByGenre(String genre, Vector<Event> eventiDaFiltrare) {
	
		Vector<Event> eventiFiltratiGenre = new Vector<Event>();
		
		for (Event eventiTemp : eventiDaFiltrare) {	
			if(genre.equals(eventiTemp.getGenreName()))
				eventiFiltratiGenre.add(eventiTemp);			
		}
		
		return eventiFiltratiGenre;
		
	}


/*private static void controlloFiltroGeneri() throws EventiException {

if (eventiFiltratiPerGeneri.isEmpty()) {
	
	key = "Attenzione";
	value = "Non ci sono eventi disponibili";
	throw new EventiException();

}*/
}
