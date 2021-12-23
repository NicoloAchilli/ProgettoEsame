package it.univpm.TicketmasterEsameOOP.service;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import it.univpm.TicketmasterEsameOOP.model.Event;


import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event; 

//import com.google.gson.Gson;

public class ServiceImpl implements Service{

	
	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";
	
	@Override
	public JSONObject getJSONEventsPL() {
		JSONObject event=null;
		String data = "";
		String line = "";
		
	try {

		URLConnection openConnection = new URL(url + "countryCode=PL" + "&apikey=" + apiKey).openConnection();
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
		
		event= (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return event;
	}
	
//  ------------------------------------------------------------
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
		event= (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object

	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return event;
	}


	public JSONObject getTypeEvent() {
		JSONObject event=null;
		String data = "";
		String line = "";
		
	try {

		URLConnection openConnection = new URL(url + "classificationName=music" + "&countryCode=PL"  +"&apikey=" + apiKey).openConnection();
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
		
		event= (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object

		//(JSONArray) JSONValue.parseWithException(data);	//parse JSON Array
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}

	return event;
	}

	@Override
	public JSONObject toJson(Country country) {
		JSONObject output = new JSONObject();
		// output.put("name", country.getCountryName());	
		// output.put("countryCode", country.getCountryCode());
		
		JSONArray eventList = new JSONArray();
		
		for(Event singleEvent : country.getEvent()) {
			//JSONObject obj = new JSONObject();
			
			output.put("name", singleEvent.getName());
			output.put("id", singleEvent.getId());
			output.put("genre", singleEvent.getGenre());
			output.put("date", singleEvent.getDate());
			
			eventList.add(output);
		}
		
		return output;
		
	}

	@Override
	public Country getEvent(JSONObject obj) {
		
		Country country = new Country();
		Vector<Event> eventData = new Vector<Event>();
		
		//JSONObject countryData = (JSONObject)obj.get("country");
		JSONArray events = (JSONArray)obj.get("events");
		
		//country.setCountryName((String)countryData.get("name"));
		//country.setCountryCode((String)countryData.get("countryCode"));
		
		for(int i=0; i<events.size() ; i++) {
			JSONObject listElement = (JSONObject)events.get(i);
			Event singleEvent = new Event();
			
			singleEvent.setName((String)listElement.get("name"));
			singleEvent.setId((String)listElement.get("id"));
			//singleEvent.setGenre((String)listElement.get("genre"));
			//singleEvent.setDate((long)listElement.get("localDate"));
			
			eventData.add(singleEvent);
		}
		
		country.setEvent(eventData);
		return country;
	}
	
	
	
}
	



	
/*	public  String toJSONOString (JSONObject obj) {
		//Event e=new Event(null,null,0, null,0);
		JSONObject event=getJSONEventsPL();
		String e= (String) JSONValue.toJSONString(event);	 //parse JSON Objec
		
		}*/

