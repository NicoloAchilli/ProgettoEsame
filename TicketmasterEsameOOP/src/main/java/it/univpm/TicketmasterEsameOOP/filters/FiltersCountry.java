package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class FiltersCountry extends Filters{


	public Vector<Event> FilterCountry (Vector<Filters> f) {
		
		Vector<Event> eventiFilteredByCountry = new Vector<Event>();
		Country c=new Country();
		for(Filters sf: f) {
			for (Event eventiTemp : c.getEvent()) {
			if(f.equals(eventiTemp.getCountryName()))
				eventiFilteredByCountry.add(eventiTemp);
			}
		}
		return eventiFilteredByCountry;
		
	}
	
	/*public Vector<Event> FilterByCountry (String country) {
		
		Vector<Event> eventiFilteredByCountry = new Vector<Event>();
		Country c=new Country();
		
		for (Event eventiTemp : c.getEvent()) {
			if(country.equals(eventiTemp.getCountryName()))
				eventiFilteredByCountry.add(eventiTemp);
			}	
		return eventiFilteredByCountry;
		
}*/
	
/*public void toFilter(Vector<Event> EventsToFilter, Vector<Event> filteredEvents) { //FILTRAGGIO OR
		
		for(Event d: EventsToFilter) {
		 	 if(d.getCountryName().equals(value) && !filteredEvents.contains(d))
				 try{
					 filteredEvents.add(d);
				 }catch(ClassCastException c){
					 System.out.println("MESSAGGI: " + c.getMessage());
					 System.out.println("CAUSA: " + c.getCause());
				 }
		}*/
}
