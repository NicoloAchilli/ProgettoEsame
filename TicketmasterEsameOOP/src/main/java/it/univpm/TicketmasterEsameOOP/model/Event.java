package it.univpm.TicketmasterEsameOOP.model;

import java.util.Vector;

public class Event {

	private String id;
	private String name;
	private String genreName;
	private String date;
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

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
