package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private String id;
	private String genre;
	private long date;

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

	@Override
	public String toString() {
		return "Event [name=" + name + ", id=" + id + ", genre=" + genre + ", date=" + date + "]";
	}
	
	
	
}
