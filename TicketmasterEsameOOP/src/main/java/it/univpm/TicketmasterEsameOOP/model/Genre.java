package it.univpm.TicketmasterEsameOOP.model;

public class Genre extends Event{
	private String gname;
	private long idg;
	
	public Genre(String statesName, String name, long id, String gname, long idg) {
		super(statesName, name, id);
		this.gname=gname;
		this.idg=idg;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public long getIdg() {
		return idg;
	}

	public void setIdg(long idg) {
		this.idg = idg;
	}
	

}
