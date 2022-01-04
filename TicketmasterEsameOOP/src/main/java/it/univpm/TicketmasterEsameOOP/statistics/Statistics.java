package it.univpm.TicketmasterEsameOOP.statistics;

import java.util.ArrayList;
import java.util.Vector;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.model.*;

public interface Statistics {
	
	ArrayList<Event> e=new ArrayList<Event>();
	ArrayList<Genre> g=new ArrayList<Genre>();

	
	abstract int NumberTotEvent();
	abstract JSONObject GenreStatistics(String genre);
	
	
	//abstract Vector<Event> MounthStatistics(String genre);	
	//abstract Vector<Event> NumberMaxMounth();
	//abstract Vector<Event> NumberMinMounth();
	//abstract Vector<Event> NumberAverageMounth();
}
