package it.univpm.TicketmasterEsameOOP.statistics;

import java.util.ArrayList;
import it.univpm.TicketmasterEsameOOP.model.*;

public interface Statistics {
	
	ArrayList<Event> e=new ArrayList<Event>();
	ArrayList<Genre> g=new ArrayList<Genre>();
	
	abstract int NTOTEvent();
	abstract void NGenreEvent();
	//abstract ArrayList<Genre> NMaxGenre();
}
