package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private String id;
	private String genre;
	private int date;
	
<<<<<<< HEAD
	public Event(String statesName, String name, String id, String genre) {
=======
	public Event(String statesName, String name, long id, String genre,int date) {
>>>>>>> 27e78b0c41932855c0068491e860c57c5a2efbad
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

	int getDate() {
		return date;
	}

	void setDate(int date) {
		this.date = date;
	}

}
