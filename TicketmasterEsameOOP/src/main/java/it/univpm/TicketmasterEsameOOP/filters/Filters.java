package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import java.util.regex.PatternSyntaxException;
import org.json.simple.JSONObject;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class Filters {

	protected Vector<Filters> filtersCountry= new Vector<Filters>();
	protected Vector<Filters> filtersGenre= new Vector<Filters>();
	protected String value;
	
	public Vector<Filters> getFiltersGenre() {
		return filtersGenre;
	}

	public void setFiltersGenre(Vector<Filters> filtersGenre) {
		this.filtersGenre = filtersGenre;
	}


	public Vector<Filters> getFiltersCountry() {
		return filtersCountry;
	}

	public void setFiltersCountry(Vector<Filters> filtersCountry) {
		this.filtersCountry = filtersCountry;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
	public String[] parseString(String line) {
		String[] splittedLine= null;
		try{
			splittedLine = line.split(";");
		}catch(PatternSyntaxException p){
			System.out.println("MESSAGGI: " + p.getMessage());
			System.out.println("CAUSA: " + p.getCause());
		}
		return splittedLine;
	}

	public void parsingFilters(JSONObject bodyFilter){
		//Vector<Event> vfc=new Vector<Event>();
		Vector<Event> vf=new Vector<Event>();
		
		if(bodyFilter.containsKey("country")) {
			String line = (String)bodyFilter.get("country");
			//line = line.toUpperCase();
			for(String s: parseString(line)){
				if(s.equals("NULL")||s.equals("Null"))
					s = s.toLowerCase();
				Filters f = new FiltersCountry();
				//f.getFiltersCountry(s);
				filtersCountry.add(f);
				
				
				/*if(bodyFilter.containsKey("genre")) {
					FiltersGenre fg=new FiltersGenre();
					 vf=fg.filterByGenre((String)bodyFilter.get("genre"),f.FilterCountry(s));	
				}*/
				if(bodyFilter.containsKey("genre")) {
					FiltersGenre fg=new FiltersGenre();
					filtersGenre.add(fg);
			}
		}
	}
	
	
}

