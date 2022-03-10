package it.univpm.TicketmasterEsameOOP.filters;

import java.util.Vector;

import java.util.regex.PatternSyntaxException;
import org.json.simple.JSONObject;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class Filters {

	protected Vector<Filters> filtersCountry= new Vector<Filters>();
	protected Vector<Filters> filtersGenre= new Vector<Filters>();
	//protected String filtersGenre;
	protected String value;
	
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
}

