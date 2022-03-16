package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.statistics.GenreStats;

/**
 * Classe che filtra gli eventi per un determinato tipologia di evento.
 *
 */

public class FiltersGenre{
	
	/**
	 * Metodo che filtra il vettore di eventi per un determinato genere.
	 * 
	 * @param genre Genere per il filtro.
	 * @param eventiDaFiltrare Vettore contenente gli eventi da filtrare.
	 * @return eventiFiltrati Vettore di eventi filtrati per genere.
	 */

	public Vector<Event> filterByGenre(String genere,Vector<Event> eventsFilterdeByCoutry) {
	
		Vector<Event> eventiFilteredByGenre = new Vector<Event>();
		
		for (Event eventiTemp : eventsFilterdeByCoutry) {	
				if(genere.equals(eventiTemp.getGenreName()))
				eventiFilteredByGenre.add(eventiTemp);			
		}
		return eventiFilteredByGenre;
		
	}
	
	/**
	 * Metodo che filtra il vettore di eventi per più generi(si possono inserire 2 tipologia di generi).
	 * 
	 * @param genere1 primo genere Genere per il filtro.
	 * @param genere2 secondo genere Genere per il filtro.
	 * @param eventiDaFiltrare Vettore  di tipo Event contenente gli eventi da filtrare.
	 * @return eventiFiltrati Vettore di tipo Event di eventi filtrati per generi.
	 */
	public Vector<Event> FiltroPiuGeneri (String genere1, String genere2, Vector<Event> eventiDaFiltrare) {
		
			Vector<Event> eventiFiltrati = new Vector<Event>();
			
			for (Event ev : eventiDaFiltrare) {
				
				if(genere1.equals(ev.getGenreName())||genere2.equals(ev.getGenreName()))
					eventiFiltrati.add(ev);
			}
			
			return eventiFiltrati;
		}
	
	/**
	 * Metodo che fornisce la statistica degli eventi filtrati per genere.
	 * 
	 * @param genere tipologia di evento per il filtro.
	 * @param eventiDaFiltrare Vettore contenente gli eventi da filtrare.
	 * @return result JSONObject che fornisce la statistica degli eventi filtrati per genere.
	 */
	
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
