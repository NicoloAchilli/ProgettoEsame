package it.univpm.TicketmasterEsameOOP.model;

public class Event extends Country {

	private String name;
	private long id;
	private String type;
	private int numEventi;

	public Event(String statesName, String name, long id, String type, int numEventi) {
		super(statesName);
		this.name = name;
		this.id = id;
		this.type = type;
		this.numEventi = numEventi;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public int getNumEventi() {
		return numEventi;
	}

	
	
}
