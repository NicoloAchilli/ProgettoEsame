package it.univpm.TicketmasterEsameOOP.model;

import java.util.Vector;

public class Country {

	private String countryCode;
	private String countryName;
	private Vector<Event> event;

	public Vector<Event> getEvent() {
		return event;
	}

	public void setEvent(Vector<Event> event) {
		this.event = event;
	}
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
}
