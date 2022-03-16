package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.statistics.EventStats;

/**
 * 
 *Classe che esegue il filtro degli eventi in base ad un determinato stato.
 */

public class FiltersCountry{
	
	/**
	 * Metodo che esegue il filtro degli eventi in base ad un determinato stato e fornisce la statistica degli eventi filtrati.
	 * 
	 * @param country  stato di cui si vogliono visualizzare gli eventi.
	 * @param eventiDaFiltrare Vettore contenente gli eventi da filtrare.
	 * @return Statistica degli eventi filtrati in base ad un determinato stato.
	 */
	

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

