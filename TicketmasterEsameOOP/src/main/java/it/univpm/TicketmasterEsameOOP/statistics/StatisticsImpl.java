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
import java.time.format.DateTimeFormatter;

public class StatisticsImpl implements Statistics{
	Country c=new Country();
	ServiceImpl s=new ServiceImpl();
	

	public int NumberTotEvent() {
		int dimension=(c.getEvent().size())-1;
		/*int cont=0;
		for(int i=0;i<c.getEvent().size();i++) {
			if(c.getEvent().get(i) != null)
				cont++;
		}*/
		//JSONObject obj=new JSONObject();
		//obj.put("Numero totale di eventi in " + c.getCountryName() + " è ", dimension);
		return dimension;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject GenreStatistics(String genre) {
		Vector<Event> vg=new Vector<Event>();
		

		for (int i=0;i<vg.size();i++) {
			if(c.getEvent().get(i).getGenreName().equals(genre)) vg.add(c.getEvent().get(i));
			else System.out.print("Non è presente nessun evento di tipo " + genre);
		}
		JSONObject obj=new JSONObject();
		obj.put("Eventi di tipo " + genre + " in " + c.getCountryName() + " è ", vg);
		return obj;
	}
	
	public LocalDate Conversione(String d) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
	    LocalDate date = LocalDate.parse(d, formatter);
	    return date;
	}
	
	public int[] MounthStatistics() {
		int[] monthsEvents=new int[12];

		for (int i=0;i<c.getEvent().size();i++) {	
			Event e=new Event();
			e=c.getEvent().get(i);
			LocalDate d=Conversione(e.getDate());
			//LocalDate d1=Conversione(c.getEvent().get(i++).getDate());

			for(int j = 1; j <= 12; j++) {
				LocalDate d1=d.withMonth(j);
				if(d.equals(d1)) {		
					int index = j - 1;
					monthsEvents[index] += 1;
				} else {
					int index = j - 1;
					monthsEvents[index]+=0;
				}
				int accumulatore = j++;
				d1.plusMonths(accumulatore);
			}
		}
		return monthsEvents;
	}
	
	public int NumberMinMounth (int[] a) {
		int min=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]<a[i++]) min=a[i];
		}
		 return min;
	}
	
	public int NumberMaxMounth (int[] a) {
		int max=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]>a[i++]) max=a[i];

		}
		return max;
	}
	
	public double NumberAverageMounth (int[] a) {
		int dim=a.length;
		int somma=0;
		double avarage;
		for(int i=1;i<a.length;i++) {
			somma +=a[i];
		}
		avarage=somma/dim;
		return avarage;		
	}
}


