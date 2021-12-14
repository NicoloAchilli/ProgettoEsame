package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private String id;
	private String genre;
	private long date;
	
	public Event(String statesName, String name, String id, String genre, long date) {
		super(statesName);
		this.name = name;
		this.id = id;
		this.genre = genre;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	
	
}
