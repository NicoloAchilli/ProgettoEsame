package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private long id;
	private String genre;
	
	public Event(String statesName, String name, long id, String genre) {
		super(statesName);
		this.name = name;
		this.id = id;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

	

}
