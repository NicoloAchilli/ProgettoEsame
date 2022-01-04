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

	public Filters(String value) {
		this.value = value;
	}


	/*public void toFilter(List<Domain> domainsToFilter, List<Domain> filteredDomains) { 		//FILTRAGGIO OR

	for(Domain d: domainsToFilter) {
	 	 if(d.getCountry().equals(value) && !filteredDomains.contains(d))
			 try{
				 filteredDomains.add(d);
			 }catch(ClassCastException c){
				 System.out.println("MESSAGGI: " + c.getMessage());
				 System.out.println("CAUSA: " + c.getCause());
			 }
	}
	 */

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
		if(bodyFilter.containsKey("country")) {
			String line = (String)bodyFilter.get("country");
			line = line.toUpperCase();
			for(String s: parseString(line)){
				if(s.equals("NULL")||s.equals("Null"))
					s = s.toLowerCase();
				FiltersCountry f = new FiltersCountry(s);
				Filters.add(f);
			}
		}

		if(bodyFilter.containsKey("genre")) {
			Filters f=new FiltersGenre((String)bodyFilter.get("genre"));
			Filters.add(f);	
		}
	}
}

