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
import org.json.simple.parser.*;
import org.json.simple.parser.JSONParser;
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import it.univpm.TicketmasterEsameOOP.model.Genre;
import it.univpm.TicketmasterEsameOOP.model.Genre.*;
import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;


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


	@SuppressWarnings("unchecked")
	public  JSONObject parse(JSONObject obj1){

		Vector<Event> ae=new Vector<Event>();
		Event e=new Event();
		Genre g=new Genre();
		Country c=new Country();

		
		JSONObject obj = (JSONObject)obj1;
		JSONObject event= (JSONObject) obj.get("_embedded");
		JSONArray arrayEvent = (JSONArray) event.get("events");	
		
		for(Event singleEvent : c.getEvent()) {

		//for(int i=0; i<arrayEvent.size(); i++) {
			JSONObject Event = (JSONObject) arrayEvent.get(i);
			String id = (String) Event.get("id");
			e.setId(id);
			String name = (String) Event.get("name");
			e.setName(name);
			JSONObject Date=(JSONObject) Event.get("dates");
			JSONObject Date1=(JSONObject) Date.get("start");
			String dates= (String) Date1.get("localDate");
			e.setDate(dates);
			ae.add(e);

			JSONObject Event1= (JSONObject) Event.get("_embedded");
			JSONArray arrayEvent2 = (JSONArray) Event1.get("venues");
			for(int j=0; j<arrayEvent2.size(); j++) {
				JSONObject Event2 = (JSONObject) arrayEvent2.get(j);
				JSONObject Country = (JSONObject) Event2.get("country");
				String namec=(String) Country.get("name");
				c.setCountryName(namec);
				String codec=(String) Country.get("countryCode");
				c.setCountryCode(codec);
				c.setEvent(ae);

				JSONArray type = (JSONArray) Event.get("classifications");		
				for(int l=0; l<type.size(); l++) {
					JSONObject Event3 = (JSONObject) type.get(l);
					JSONObject Event4 = (JSONObject)Event3.get("segment");
					String idg= (String) Event4.get("id");
					g.setIdg(idg);
					String nameg = (String) Event4.get("name");	
					g.setNameg(nameg);

				}
			}
		}

		JSONObject objT=new JSONObject();
		objT.put("name",e.getName());
		objT.put("id",e.getId());
		objT.put("dates",e.getDate());
		objT.put("Countryname",c.getCountryName());
		objT.put("Countrycode",c.getCountryCode());
		objT.put("Genrename",g.getNameg());
		objT.put("GenreId",g.getIdg());

		/*objT.put("nameCountry", c.getCountryName());
		objT.put("countryCode", c.getCountryCode());
		objT.put("events", 0);
		JSONArray objT1=(JSONArray) objT.get("events");
		for(int h=0; h<objT1.size(); h++) {
			JSONObject objT2 = (JSONObject) objT1.get(h);
			objT2.put("name",e.getName());
			objT2.put("id",e.getId());
			objT2.put("dates",e.getDate());
		}*/

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
		return event;
	}

	
//------------------------------------------
	@Override
	public Country getEvent(JSONObject obj) {
		
		Country country = new Country();
		Vector<Event> eventData = new Vector<Event>();
		
		JSONObject countryData = (JSONObject)obj.get("country");
		JSONArray events = (JSONArray)obj.get("events");
		
		country.setCountryName((String)countryData.get("name"));
		country.setCountryCode((String)countryData.get("countryCode"));
		
		for(int i=0; i<events.size() ; i++) {
			JSONObject listElement = (JSONObject)events.get(i);
			Event singleEvent = new Event();
			
			singleEvent.setName((String)listElement.get("name"));
			singleEvent.setId((String)listElement.get("id"));
			singleEvent.setGenre((String)listElement.get("genre"));
			singleEvent.setDate((long)listElement.get("localDate"));
			
			eventData.add(singleEvent);
		}
		
		country.setEvent(eventData);
		return country;
	}
	*/
	

	
