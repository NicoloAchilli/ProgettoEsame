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
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import it.univpm.TicketmasterEsameOOP.model.Genre;
import it.univpm.TicketmasterEsameOOP.model.Genre.*;
import it.univpm.TicketmasterEsameOOP.statistics.StatisticsImpl;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;


public class ServiceImpl implements Service{

	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";

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

	public  Country parse(JSONObject obj1){

		Vector<Event> ae=new Vector<Event>();
		Country c=new Country();

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
			c.setCountryName(namec);
			String codec=(String) Country.get("countryCode");
			c.setCountryCode(codec);
			ae.add(e);
			c.setEvent(ae);
		}
		return c;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public JSONObject toJson(Country country) {

		StatisticsImpl st=new StatisticsImpl();

		JSONObject output = new JSONObject();
		output.put("coutryName", country.getCountryName());	
		output.put("countryCode", country.getCountryCode());
		output.put("Numero totale eventi ", country.getEvent().size());

		JSONArray eventList = new JSONArray();

		for(Event singleEvent : country.getEvent()) {
			JSONObject obj = new JSONObject();

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
	
	public JSONObject getFilteredEvents(JSONObject bodyFilter) {
	}
		/*try{
			Filter f0 = new Filter();
			f0.parsingFilters(bodyFilter);

			if (!f0.getFiltersName().isEmpty() && !f0.getFiltersCountry().isEmpty()) {
				for (Filter f : f0.getFiltersName()) {
					f.toFilter(domainsToFilter1, domainsToFilter2);
				}
				for (Filter f : f0.getFiltersCountry()) {
					f.toFilter(domainsToFilter2, filteredDomains);
				}
			}
			if (f0.getFiltersName().isEmpty() && !f0.getFiltersCountry().isEmpty()) {
				for (Filter f : f0.getFiltersCountry()) {
					System.out.println(f);
					f.toFilter(domainsToFilter1, filteredDomains);
				}
			}
			if (!f0.getFiltersName().isEmpty() && f0.getFiltersCountry().isEmpty()) {
				for (Filter f : f0.getFiltersName()) {
					f.toFilter(domainsToFilter1, filteredDomains);
				}
			}
			if (f0.getFiltersName().isEmpty() && f0.getFiltersCountry().isEmpty()) {
				filteredDomains = domainsToFilter1;
			}
			for (Filter f : f0.getFilters()) {
				f.toFilter(filteredDomains);
			}
		}
		catch(Exception e){
			System.out.println("ERRORE: GENERICO in getFilteredDomains().");
			System.out.println("MESSAGGI: " + e.getMessage());
			System.out.println("CAUSA: " + e.getCause());
		}
		for(Domain d:filteredDomains)
			System.out.println(d);
		return filteredDomains;
	}*/

}	