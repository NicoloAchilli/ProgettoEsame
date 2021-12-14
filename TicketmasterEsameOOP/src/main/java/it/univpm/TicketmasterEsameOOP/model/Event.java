package it.univpm.TicketmasterEsameOOP.model;

public class Event {

	private String name;
	private long id;
	private String type;
	private int numEventi;
	
	public Event(String name, long id, String type,int numEventi) {
		this.name = name;
		this.id = id;
		this.type = type;
		this.numEventi=numEventi;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	int getNumEventi() {
		return numEventi;
	}

	void setNumEventi(int numEventi) {
		this.numEventi = numEventi;
	}
	
	
}
