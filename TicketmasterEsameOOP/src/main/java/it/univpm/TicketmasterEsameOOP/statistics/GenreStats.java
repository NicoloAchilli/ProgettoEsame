package it.univpm.TicketmasterEsameOOP.statistics;

import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.model.Event;

/**
 * 
 * Classe che fornisce le statistiche degli eventi per un determinato genere.
 *
 */
public class GenreStats {
	
	/**
	 * 
	 * Classe che fornisce il numero totale di eventi per un determinato genere.
	 * 
	 * @param eventiFiltrati Vettore di eventi filtrati per un determinato genere.
	 * @param genre tipologia di evento per il filtro.
	 * @return obj JSONObject contente il numero di eventi per un determinato genere.
	 * @throws EventiException se non è presente alcun evento per un determinato genere.
	 */
	@SuppressWarnings("unchecked")
	public JSONObject GenreEventi(Vector<Event>eventiFiltrati,String genre) throws EventiException {
		
		int contGenre=0;
		
		JSONObject obj=new JSONObject();
		Event ev=new Event();
		
		for(int i=0;i<eventiFiltrati.size();i++) {
			
			ev=eventiFiltrati.get(i);
			
			if(genre.equals(ev.getGenreName())) {
				contGenre++;
			}
			
		}
		
		if(eventiFiltrati.isEmpty()) {
			throw new EventiException("Nessun evento per il genere "+genre);
		}
		obj.put("in "+ev.getCountryName(), contGenre);
		return obj;
	}
	
}

