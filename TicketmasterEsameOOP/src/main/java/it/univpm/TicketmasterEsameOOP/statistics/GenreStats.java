package it.univpm.TicketmasterEsameOOP.statistics;

import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class GenreStats {
	
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

