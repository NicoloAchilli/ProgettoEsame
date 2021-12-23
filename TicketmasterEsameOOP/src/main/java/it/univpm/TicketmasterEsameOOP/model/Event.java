package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private long id;
	private String name;
	//private String genre;
	private long date;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [name=" + name + ", id=" + id +  ", date=" + date + "]";
	}

}
