package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private long id;
	private String genre;
	private int date;
	
	public Event(String statesName, String name, long id, String genre,int date) {
		super(statesName);
		this.name = name;
		this.id = id;
		this.genre = genre;
		this.date=date;
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

	int getDate() {
		return date;
	}

	void setDate(int date) {
		this.date = date;
	}

}
