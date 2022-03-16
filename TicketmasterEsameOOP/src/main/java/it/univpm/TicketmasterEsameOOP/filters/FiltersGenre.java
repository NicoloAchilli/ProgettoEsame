package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.statistics.GenreStats;

public class FiltersGenre{

	public Vector<Event> filterByGenre(String genere,Vector<Event> eventsFilterdeByCoutry) {
	
		Vector<Event> eventiFilteredByGenre = new Vector<Event>();
		
		for (Event eventiTemp : eventsFilterdeByCoutry) {	
				if(genere.equals(eventiTemp.getGenreName()))
				eventiFilteredByGenre.add(eventiTemp);			
		}
		return eventiFilteredByGenre;
		
	}
	
	public Vector<Event> FiltroPiuGeneri (String genere1, String genere2, Vector<Event> eventiDaFiltrare) {
		
			Vector<Event> eventiFiltrati = new Vector<Event>();
			
			for (Event ev : eventiDaFiltrare) {
				
				if(genere1.equals(ev.getGenreName())||genere2.equals(ev.getGenreName()))
					eventiFiltrati.add(ev);
			}
			
			return eventiFiltrati;
		}
	
	@SuppressWarnings("unchecked")
	public JSONObject FiltroGenere (String genere, Vector<Event> eventiDaFiltrare) {
		GenreStats stats=new GenreStats();
		JSONObject result=new JSONObject();
		
		Vector<Event> eventiFiltrati = new Vector<Event>();
		
		for (Event ev : eventiDaFiltrare) {
			
			if(genere.equals(ev.getGenreName()))
				eventiFiltrati.add(ev);
		}	
	
		try {
			result=stats.GenreEventi(eventiFiltrati, genere);
		} catch (EventiException e) {
			result.put("ERRORE","Nessun evento per il genere "+genere);
			e.printStackTrace();
		}
		
		return result;
	}
}
