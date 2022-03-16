package it.univpm.TicketmasterEsameOOP.model;

import java.util.Vector;

/**
 * 
 * Classe che descrive la struttura del Body degli eventi per la chiamata.
 *
 */
public class Evento {
	/**
	 * Vettore di generi.
	 */
	private Vector<String> generi;
	
	/**
	 * Vettore di stati.
	 */
	private Vector<String> stati;

	/**
	 * Costruttore dell'oggetto evento
	 * @param stati  Vettore contenente i nomi degli stati.
	 * @param generi    Vettore contenente i generi.
	 */
	public Evento(Vector<String> stati, Vector<String> generi) {
		this.generi=generi;
		this.stati=stati;
	}
	
	/**
	 * Getter dello vettore generi
	 * @return generi 
	 */
	public Vector<String> getGeneri() {
		return generi;
	}
	
	/**
     * Setter del vettore generi
     * @param generi Parametro del Setter
     */
	public void setGeneri(Vector<String> generi) {
		this.generi = generi;
	}
	
	/**
	 * Getter dello vettore stati
	 * @return stati 
	 */
	public Vector<String> getStati() {
		return stati;
	}
	/**
     * Setter del vettore stati
     * @param stati Parametro del Setter
     */
	public void setStati(Vector<String> stati) {
		this.stati = stati;
	}
}
