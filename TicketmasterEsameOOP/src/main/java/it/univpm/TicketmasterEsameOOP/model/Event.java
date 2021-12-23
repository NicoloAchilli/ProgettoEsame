package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String id;
	private String name;
	//private String genre;
	private String date;


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

	@Override
	public String toString() {
		return "Event [name=" + name + ", id=" + id +  ", date=" + date + "]";
	}
}
