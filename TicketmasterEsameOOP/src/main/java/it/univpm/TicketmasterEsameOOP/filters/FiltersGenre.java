package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;
import it.univpm.TicketmasterEsameOOP.model.Evento;

public class FiltersGenre extends Filters{

	public Vector<Evento> filterByGenre(String g,Vector<Evento> eventsFilterdeByCoutry) {
	
		Vector<Evento> eventiFilteredByGenre = new Vector<Evento>();
		
		for (Evento eventiTemp : eventsFilterdeByCoutry) {	
				if(g.equals(eventiTemp.getGeneri()))
				eventiFilteredByGenre.add(eventiTemp);			
		}
		return eventiFilteredByGenre;
		
	}
	
	public Vector<Evento> FiltroPiuGeneri (String genere1, String genere2, Vector<Evento> eventiDaFiltrare) {
		
		Vector<Evento> eventiFiltrati = new Vector<Evento>();
		
		for (Evento ev : eventiDaFiltrare) {
			
			if(genere1.equals(ev.getGeneri())||genere2.equals(ev.getGeneri()))
				eventiFiltrati.add(ev);
		}
		
		return eventiFiltrati;
	}
}
