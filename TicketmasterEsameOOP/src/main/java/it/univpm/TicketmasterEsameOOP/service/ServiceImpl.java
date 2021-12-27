package it.univpm.TicketmasterEsameOOP.service;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import it.univpm.TicketmasterEsameOOP.model.Genre;
import it.univpm.TicketmasterEsameOOP.model.Genre.*;


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
		
			event= (JSONObject) JSONValue.parseWithException(data);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return event;
	}

	//---------------------------------
	@SuppressWarnings("unchecked")
	public  JSONObject parse(JSONObject obj1){

		ArrayList<Event> ae=new ArrayList<Event>();
		Event e=new Event();
		Genre g=new Genre();
		Country c=new Country();

		JSONObject objT=new JSONObject();
		
		JSONObject obj = (JSONObject)obj1;
		JSONObject event= (JSONObject) obj.get("_embedded");
		JSONArray arrayEvent = (JSONArray) event.get("events");	
		

		for(int i=0; i<arrayEvent.size(); i++) {
			JSONObject Event = (JSONObject) arrayEvent.get(i);
			String id = (String) Event.get("id");
			e.setId(id);
			String name = (String) Event.get("name");
			e.setName(name);
			JSONObject Date=(JSONObject) Event.get("dates");
			JSONObject Date1=(JSONObject) Date.get("start");
			String dates= (String) Date1.get("localDate");
			e.setDate(dates);
			
			JSONObject Event1= (JSONObject) Event.get("_embedded");
			JSONArray arrayEvent2 = (JSONArray) Event1.get("venues");
			for(int j=0; j<arrayEvent2.size(); j++) {
				JSONObject Event2 = (JSONObject) arrayEvent2.get(j);
				JSONObject Country = (JSONObject) Event2.get("country");
				String namec=(String) Country.get("name");
				c.setCountryName(namec);
				String codec=(String) Country.get("countryCode");
				c.setCountryCode(codec);
				
			}
			//ae.add(e);
			
			/*JSONArray type = (JSONArray) Event.get("classifications");		
			for(int j=0; j<type.size(); j++) {
				JSONObject Event1 = (JSONObject) Event.get("segment");
				long idg = (long) Event1.get("id");
				g.set
				String nameg = (String) Event1.get("name");*/		
	}
		
		objT.put("name",e.getName());
		objT.put("id",e.getId());
		objT.put("dates",e.getDate());
		objT.put("nameCountry", c.getCountryName());
		objT.put("countryCode", c.getCountryCode());
		return objT;
	}
}
	/*
	@Override
	public JSONObject toJson(Country country) {
		JSONObject output = new JSONObject();
		 output.put("name", country.getCountryName());	
		 output.put("countryCode", country.getCountryCode());
		
		JSONArray eventList = new JSONArray();
		
		for(Event singleEvent : country.getEvent()) {
			JSONObject obj = new JSONObject();
			
			obj.put("name", singleEvent.getName());
			obj.put("id", singleEvent.getId());
			//obj.put("genre", singleEvent.getGenre());
			obj.put("date", singleEvent.getDate());
			
			eventList.add(obj);
		}
		
		return output;
		
	}
}
/*
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

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return event;
	}
	// --------------------------------


	public JSONObject getTypeEvent(String Type,String country) {
		JSONObject event=null;
		String data = "";
		String line = "";

		try {

			URLConnection openConnection = new URL("https://app.ticketmaster.com/discovery/v2/events.json?classificationName=" + Type + "&countryCode=" + country  +"&apikey=" + apiKey).openConnection();
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
<<<<<<< HEAD
		
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
		
=======
		return event;
>>>>>>> 593541f8cf5ea2b66161fbf5f122d9c4388dfd5a
	}

	
//------------------------------------------
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
	*/
	

	
