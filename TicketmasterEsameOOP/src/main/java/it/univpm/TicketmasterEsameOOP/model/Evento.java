package it.univpm.TicketmasterEsameOOP.model;

import java.util.Vector;

public class Evento {
	private Vector<String> generi;
	private Vector<String> stati;

	public Evento(Vector<String> stati, Vector<String> generi) {
		this.generi=generi;
		this.stati=stati;
	}
	
	public Vector<String> getGeneri() {
		return generi;
	}
	public void setGeneri(Vector<String> generi) {
		this.generi = generi;
	}
	public Vector<String> getStati() {
		return stati;
	}
	public void setStati(Vector<String> stati) {
		this.stati = stati;
	}
}
