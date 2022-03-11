package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class FiltersCountry{

	public JSONObject FilterCountry (String stato,Vector<Event>  e) {
		
		Vector<Event>  eventiFilteredByCountry = new Vector<Event>();
		for(Event ef: e) {
			if(stato.equals(ef.getCountryName()));
				eventiFilteredByCountry.add(ef);
			}
		return eventiFilteredByCountry;
}
}


/*public JSONObject FiltroStati(String stato, Vector<Evento> eventiDaFiltrare) {

	EventStats stats=new EventStats();

	Vector<Evento> eventiFiltrati=new Vector<Evento>();

	for(Evento eventiTemp:eventiDaFiltrare) {

		if(stato.equals(eventiTemp.getStateCode()))
			eventiFiltrati.add(eventiTemp);

	}

	return 	stats.TotEventi(eventiFiltrati);

}*/