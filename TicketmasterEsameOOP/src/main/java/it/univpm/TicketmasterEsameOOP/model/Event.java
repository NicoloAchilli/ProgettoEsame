package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private long id;
	
	public Event(String statesName, String name, long id) {
		super(statesName);
		this.name = name;
		this.id = id;
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
}
