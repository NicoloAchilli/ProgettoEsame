package it.univpm.TicketmasterEsameOOP.service;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.function.Consumer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.pattern.FileOfCallerConverter;
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.filters.FiltersCountry;
import it.univpm.TicketmasterEsameOOP.filters.FiltersGenre;
import it.univpm.TicketmasterEsameOOP.model.Event;

/**
 * Implementazione dell'interfaccia service.
 */

@Service
public class ServiceImpl implements service{

	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";
	
	/**
	 * Metodo che analizza l'API di ticketmaster e restituisce il JSONObject filtrato per paese.
	 * 
	 * @param CountryCode sigla dello stato di cui si vogliono visualizzare gli eventi.
	 * @return JSONObject dell'evento.
	 */
	
	public JSONObject getJSONEvents(String country) {
		JSONObject event=new JSONObject();
		String data = "";
		String line = "";

		try {

			URLConnection openConnection = new URL(url + "countryCode=" + country + "&apikey=" + apiKey).openConnection();
			InputStream in = openConnection.getInputStream();

			try {
				InputStreamReader inR = new InputStreamReader( in );
				BufferedReader buf = new BufferedReader( inR );

				while ( ( line = buf.readLine() ) != null ) {
					data+= line;
				}
			} finally {
				in.close();
			}
			event= (JSONObject) JSONValue.parseWithException(data);	

		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	/**
	 * Metodo che, tramite il JSONObject di eventi, costruice il Vettore di tipo Event.
	 * 
	 * @param JSONObject dello stato di cui si vogliono visualizzare gli eventi.
	 * @return Vettore di tipo Event.
	 * @throws EventiException se il vettore di Eventi è vuoto.
	 */
	
	public  Vector<Event> parse(JSONObject obj1) throws EventiException{
		
		
		JSONObject obj = (JSONObject)obj1;
		JSONObject event= (JSONObject) obj.get("_embedded");
		JSONArray arrayEvent = (JSONArray) event.get("events");	
		
		Vector<Event> ae=new Vector<Event>();


		for(int i=0; i<arrayEvent.size(); i++) {
			Event e=new Event();
			JSONObject Event = (JSONObject) arrayEvent.get(i);
			String id = (String) Event.get("id");
			e.setId(id);
			String name = (String) Event.get("name");
			e.setName(name);
			JSONObject Date=(JSONObject) Event.get("dates");
			JSONObject Date1=(JSONObject) Date.get("start");
			String dates= (String) Date1.get("localDate");
			e.setDate(dates);

			JSONArray type = (JSONArray) Event.get("classifications");
			JSONObject Event3 = (JSONObject) type.get(0);
			JSONObject Event4 = (JSONObject) Event3.get("segment");
			String nameg = (String) Event4.get("name");	
			e.setGenreName(nameg);

			JSONObject Event1= (JSONObject) Event.get("_embedded");
			JSONArray arrayEvent2 = (JSONArray) Event1.get("venues");
			JSONObject Event2 = (JSONObject) arrayEvent2.get(0);
			JSONObject Country = (JSONObject) Event2.get("country");
			String namec=(String) Country.get("name");
			e.setCountryName(namec);
			String codec=(String) Country.get("countryCode");
			e.setCountryCode(codec);
			ae.add(e);
		}		
		if (ae.isEmpty()) {
			throw new EventiException("Il vettore di eventi è vuoto");
		}
		
		return ae;
	}

	/**
	 * Metodo che converte il Vettore di tipo Event in un JSONObject.
	 * 
	 * @param  Vettore di tipo Event
	 * @return  JSONObject del vettore.
	 */
	
	@SuppressWarnings({ "unchecked", "unused" })
	public JSONObject toJson(Vector<Event>  ev) {

		JSONObject output = new JSONObject();
		JSONArray eventList = new JSONArray();
		
		for(Event singleEvent : ev) {
			JSONObject obj = new JSONObject();
			
			output.put("coutryName", singleEvent.getCountryName());	
			output.put("countryCode", singleEvent.getCountryCode());
			
			obj.put("name", singleEvent.getName());
			obj.put("id", singleEvent.getId());
			obj.put("date", singleEvent.getDate());
			obj.put("genre", singleEvent.getGenreName());

			eventList.add(obj);	
		}

		output.put("events", eventList);

		return output;
	}
	
	/**
	 * Metodo che analizza l'API di ticketmaster e restituisce il JSONObject filtrato per paese e per genere.
	 * 
	 * @param CountryCode sigla dello stato di cui si vogliono visualizzare gli eventi.
	 * @param genre tipologia di evento
	 * @return JSONObject dell'evento.
	 */
	
	public JSONObject getJSONEventsG(String country,String genre) {
		JSONObject event=null;
		String data = "";
		String line = "";

		try {

			URLConnection openConnection = new URL(url + "ClassificationName= " + genre + "&countryCode=" + country + "&apikey=" + apiKey).openConnection();
			InputStream in = openConnection.getInputStream();

			try {
				InputStreamReader inR = new InputStreamReader( in );
				BufferedReader buf = new BufferedReader( inR );

				while ( ( line = buf.readLine() ) != null ) {
					data+= line;
				}
			} finally {
				in.close();
			}
			event= (JSONObject) JSONValue.parseWithException(data);	

		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
	
	/**
	 * Metodo che legge il body e crea l'oggetto di tipo Evento.
	 * Il body inserito dall' utente deve essere di questo tipo:
	 * 
	 * {
	 *	"stati":[
     *  	{ 
     *  	"stato1":"PL"
     * 	},
  	 * {
     *	"stato2":"FR"
     *	}
     * ],
     *	"generi":[
     *	{
     *	"genere1":"Music"
     *	},
     *	{
     *	"genere2":"Sport"
     *	}
     * ]
     * }
     * 
	 *@param body Stringa del body in ingresso.
	 *@return Oggetto di tipo Evento.
	 */
	
	@SuppressWarnings("unused")
	public Evento readBody(String body) {
		Vector<String>stati=new Vector<String>();
		Vector<String>generi=new Vector<String>();
		Vector<String>periodo=new Vector<String>();
		Evento eb;
		JSONObject Body;
		try {
			Body= (JSONObject)new JSONParser().parse(body);
	

		JSONArray jsonstati=(JSONArray)Body.get("stati");

		JSONObject statetmp=(JSONObject)jsonstati.get(0);
		JSONObject statetmp2=(JSONObject)jsonstati.get(1);

		String stato1=(String)statetmp.get("stato1");
		String stato2=(String)statetmp2.get("stato2");

		stati.add(stato1);
		stati.add(stato2);

		JSONArray jsongeneri=(JSONArray)Body.get("generi");

		JSONObject genretemp=(JSONObject)jsongeneri.get(0);
		JSONObject genretemp2=(JSONObject)jsongeneri.get(1);
		String genere1=(String)genretemp.get("genere1");
		String genere2=(String)genretemp2.get("genere2");

		generi.add(genere1);
		generi.add(genere2);
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		return eb=new Evento(stati,generi);

	}	
	
	/**
	 * Metodo che restituisce il risultato del JSONObject degli eventi filtrati per genere e stato.
	 * 
	 * @param Countrycode sigla dello stato di cui si vogliono visualizzare gli eventi.
	 * @param genre tipologia di evento.
	 * @return result JSONObject degli eventi filtrati.
	 * @throws EventiException se il vettore filtrato è vuoto.
	 */
	
	public JSONObject resultFilters (String genre,String country) throws EventiException{
		
		FiltersGenre fg=new FiltersGenre();
		Vector<Event> eventi=new Vector<Event>();
		
		eventi=(fg.filterByGenre(genre, parse(getJSONEventsG(country,genre))));

		if(eventi.isEmpty()) {
			throw new EventiException("Il vettore di eventi per lo stato è vuoto");
		}

		JSONObject result=toJson(eventi);
		return result ;
	}
}	