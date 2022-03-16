package it.univpm.TicketmasterEsameOOP.statistics;

import java.time.LocalDate;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.service.ServiceImpl;

public class EventStats {
	ServiceImpl s=new	ServiceImpl();
	private int[]monthsEvents=new int[12];
	private int[] months;
	
	public int[] MonthsEvents(String country) {

		Vector<Event>eventiPerStato=new Vector<Event>();
		
		eventiPerStato=s.parse(s.getJSONEvents(country));
		Event ev=new Event();

		monthsEvents=new int[12];

		for(int i=0;i<eventiPerStato.size();i++) {

			
			ev=eventiPerStato.get(i);
			LocalDate mese1=dateConverter(ev.getDate()); 

			for(int j=1;j<=12;j++) {

				LocalDate mese2=mese1.withMonth(j);

				if(mese1.equals(mese2)) {

					int counter=j-1;
					monthsEvents[counter]+=1;
				} 
				else
				{					
					int counter=j-1;
					monthsEvents[counter]+=0;
				}

				int cont=j+1;
				mese2.plusMonths(cont);
			}
		}
		
		return monthsEvents;

	}
	
	public LocalDate dateConverter(String date) {

		LocalDate localdate = LocalDate.parse((CharSequence) date);
		
		return localdate;
	
	}
	
	public int[] MonthsEventsFiltrati (Vector<Event>eventiFiltrati) {

		Event ev=new Event();

		monthsEvents=new int[12];

		for(int i=0;i<eventiFiltrati.size();i++) {

			
			ev=eventiFiltrati.get(i);
			LocalDate mese1=dateConverter(ev.getDate()); 

			for(int j=1;j<=12;j++) {

				LocalDate mese2=mese1.withMonth(j);

				if(mese1.equals(mese2)) {

					int counter=j-1;
					monthsEvents[counter]+=1;
				} 
				else
				{					
					int counter=j-1;
					monthsEvents[counter]+=0;
				}

				int cont=j+1;
				mese2.plusMonths(cont);
			}
		}
		
		return monthsEvents;

	}
	
@SuppressWarnings("unchecked")
public JSONObject TotEventi(Vector<Event>eventidaFiltrare) {
		
		JSONObject obj=new JSONObject();

		int eventiTot=0;
		
		monthsEvents=MonthsEventsFiltrati(eventidaFiltrare);
		
		for(int i=0;i<monthsEvents.length;i++) {
			eventiTot+=monthsEvents[i];	
		}
		obj.put("Totale", eventiTot);	

		return obj;
		
	}

@SuppressWarnings("unchecked")
public JSONObject totEventi(String stateCode) {

	JSONObject obj=new JSONObject();

	int eventiTot=0;
	
	monthsEvents=MonthsEvents(stateCode);
	
	for(int i=0;i<monthsEvents.length;i++) {
		eventiTot+=monthsEvents[i];	
		
	}
	obj.put("Totale Eventi", eventiTot);	

	return obj;
	
}
}
