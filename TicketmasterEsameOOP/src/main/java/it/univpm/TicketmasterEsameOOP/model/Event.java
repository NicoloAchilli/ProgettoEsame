package it.univpm.TicketmasterEsameOOP.model;

import java.util.Vector;

/**
 * Classe che descrive l'evento.
 *
 */

public class Event {
	/**
	 * Variabile che descrive l id dell'evento.
	 */
	private String id;
	/**
	 * Variabile che descrive il nome dell'evento.
	 */
	private String name;
	/**
	 * Variabile che descrive il nome del genere.
	 */
	private String genreName;
	/**
	 * Variabile che descrive la data in cui avviene l' evento.
	 */
	private String date;
	/**
	 * Variabile che descrive il nome dello stato.
	 */
	private String countryCode;
	/**
	 * Variabile che descrive la sigla dello stato.
	 */
	private String countryName;

	/**
	 * Costruttore che inizializza l'oggetto evento.
	 * @param name
	 * @param id
	 * @param genreName
	 * @param date
	 * @param countryName
	 * @param countryCode
	 */
	public Event(String id, String name, String genreName, String date, String countryCode, String countryName) {
		this.id = id;
		this.name = name;
		this.genreName = genreName;
		this.date = date;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}
	
	/**
	 * Costruttore dell'oggetto Evento (vuoto).
	 */
	public Event(){};
	
	/**
	 * Getter dell'attributo countryCode.
	 * @return countryCode.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Setter dell'attributo countryCode.
	 * @param countryCode parametro del Setter.
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Getter dell'attributo countryName.
	 * @return countryName.
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Setter dell'attributo countryName.
	 * @param countryName parametro del Setter.
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Getter dell'attributo genreName.
	 * @return genreName.
	 */
	public String getGenreName() {
		return genreName;
	}
	
	/**
	 * Setter dell'attributo genreName.
	 * @param genreName parametro del Setter.
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	/**
	 * Getter dell'attributo id.
	 * @return id.
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Setter dell'attributo id.
	 * @param id parametro del Setter.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter dell'attributo getName.
	 * @return getName.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter dell'attributo name.
	 * @param name parametro del Setter.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter dell'attributo date.
	 * @return date.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter dell'attributo date.
	 * @param date parametro del Setter.
	 */
	public void setDate(String date) {
		this.date = date;
	}

}
