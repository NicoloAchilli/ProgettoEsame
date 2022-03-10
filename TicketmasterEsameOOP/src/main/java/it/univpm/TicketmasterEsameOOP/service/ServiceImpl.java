package it.univpm.TicketmasterEsameOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.function.Consumer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;
import ch.qos.logback.classic.pattern.FileOfCallerConverter;
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.statistics.StatisticsImpl;
import it.univpm.TicketmasterEsameOOP.exception.NoDataException;
import it.univpm.TicketmasterEsameOOP.filters.Filters;
import it.univpm.TicketmasterEsameOOP.filters.FiltersCountry;
import it.univpm.TicketmasterEsameOOP.filters.FiltersGenre;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;


public class ServiceImpl implements Service{

	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";

	//private Vector<Event> filteredEvents= new Vector<Event>();
	
	@Override
	public JSONObject getJSONEvents(String country) {
		JSONObject event=null;
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

	public  Vector<Event> parse(JSONObject obj1){

		Vector<Event> ae=new Vector<Event>();

		JSONObject obj = (JSONObject)obj1;
		JSONObject event= (JSONObject) obj.get("_embedded");
		JSONArray arrayEvent = (JSONArray) event.get("events");	

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
		return ae;
	}

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
	
	public Evento parsingbodyfilter(JSONObject bodyFilter){
		Vector<String> stati=new Vector<String>();
		Vector<String> generi=new Vector<String>();
		Evento e=new Evento();
		JSONArray arrayEvent =(JSONArray) bodyFilter.get("CountryCode");
		String stato1=(String) arrayEvent.get(0);
		String stato2=(String) arrayEvent.get(1);
		stati.add(stato1);
		stati.add(stato2);
		e.setGeneri(stati);
		JSONArray arrayEvent1 =(JSONArray) bodyFilter.get("Genre");
		String genere1=(String) arrayEvent1.get(0);
		String genere2=(String) arrayEvent1.get(1);
		generi.add(genere1);
		generi.add(genere2);
		e.setGeneri(generi);
		return e;
	}
	
}	