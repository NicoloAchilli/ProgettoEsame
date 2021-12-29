package it.univpm.TicketmasterEsameOOP.statistics;

import static org.hamcrest.CoreMatchers.anything;
import org.json.simple.JSONObject;
import it.univpm.TicketmasterEsameOOP.model.Genre;
import it.univpm.TicketmasterEsameOOP.service.ServiceImpl;
import it.univpm.TicketmasterEsameOOP.service.ServiceImpl.*;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Country.*;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import java.util.*;
import java.text.*;
import java.time.LocalDate;

public class StatisticsImpl implements Statistics{
	Country c=new Country();
	ServiceImpl s=new ServiceImpl();
	
	
	@SuppressWarnings("unchecked")
	public JSONObject NTOTEvent() {
		int dimension=(c.getEvent().size())-1;
		/*int cont=0;
		for(int i=0;i<c.getEvent().size();i++) {
			if(c.getEvent().get(i) != null)
				cont++;
		}*/
		JSONObject obj=new JSONObject();
		obj.put("Numero totale di eventi in " + c.getCountryName() + " è ", dimension);
		return obj;
	}
	
	public Vector<Event> NGenreEvent(String genre) {
		Vector<Event> vg=new Vector<Event>();

		for (int i=0;i<vg.size();i++) {
			if(c.getEvent().get(i).getGenreName().equals(genre)) vg.add(c.getEvent().get(i));
			else System.out.print("Non è presente nessun evento di tipo " + genre);
		}
		return vg;
		/*for(int i=0;i<g.size();i++) {
			if(g.get(i).getGenreName() == "Comedy") cc++;
			if(g.get(i).getGenreName() == "Family") cf++;
		}
		System.out.println("Numero di eventi di tipo Comedy in " + c.getCountryName() + " è "+ cc);
		System.out.println("Numero di eventi di tipo Family in " + c.getCountryName() + " è "+ cf);
	}*/
	}

}
