package it.univpm.TicketmasterEsameOOP.statistics;

import static org.hamcrest.CoreMatchers.anything;
import java.util.ArrayList;
import jdk.jfr.Event;
import it.univpm.TicketmasterEsameOOP.model.Genre;
import it.univpm.TicketmasterEsameOOP.service.ServiceImpl.*;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Country.*;

import java.util.*;
import java.text.*;

public class StatisticsImpl implements Statistics{
	Country c=new Country(null);
	
	public int NTOTEvent(ArrayList<Event> e) {
		int cont=0;
		for(int i=0;i<e.size();i++) {
			if(e.get(i) != null)
				cont++;
		}
		System.out.println("Numero totale di eventi in " + c.getStatename() + " è ");
		return cont;
	}
	
	public void NGenreEvent(ArrayList<Genre> g) {
		int cc=0;
		int cf=0;
		for(int i=0;i<g.size();i++) {
			if(g.get(i).getGname() == "Comedy") cc++;
			if(g.get(i).getGname() == "Family") cf++;
		}
		System.out.println("Numero di eventi di tipo Comedy in " + c.getStatename() + " è "+ cc);
		System.out.println("Numero di eventi di tipo Family in " + c.getStatename() + " è "+ cf);
	}
		
	public class DateDemo {
      Date dNow = new Date( );
      SimpleDateFormat ft = new SimpleDateFormat (" %tB ");
      //System.out.println("Current Date: " + ft.format(dNow));
   }
	
	public ArrayList<Genre> NMaxGenre(String genere){
		for(int i=0;i<g.size();i++) {
			
		}
	}
}
