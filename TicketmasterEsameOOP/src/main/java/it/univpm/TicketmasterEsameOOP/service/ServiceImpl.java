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

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Event.*;
import it.univpm.TicketmasterEsameOOP.model.Genre;


public class ServiceImpl implements Service{

	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?&countryCode=";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";

	@Override
	public JSONObject getJSONEventsPL() {
		JSONObject event=null;
		String data = "";
		String line = "";

		try {

			URLConnection openConnection = new URL(url + "PL" + "&apikey=" + apiKey).openConnection();
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

	public void parse(String data) throws org.json.simple.parser.ParseException {

		ArrayList<Event> ae=new ArrayList<Event>();
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject)parser.parse(data);
			JSONObject event= (JSONObject) obj.get("_embedded");
			JSONArray arrayEvent = (JSONArray) event.get("events");	

			for(int i=0; i<arrayEvent.size(); i++) {
				JSONObject Event = (JSONObject) arrayEvent.get(i);
				long id = (long) Event.get("id");
				String name = (String) Event.get("name");
				Event e=new Event("PL", name, id);
				ae.add(e);
				JSONArray type = (JSONArray) Event.get("classifications");		
				for(int j=0; j<type.size(); j++) {
					JSONObject Event1 = (JSONObject) Event.get("segment");
					long idg = (long) Event1.get("id");
					String nameg = (String) Event1.get("name");
					Genre g=new Genre("PL", name, id, nameg, idg);
				}
			}
		}
		catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

	//  ------------------------------------------------------------
	@Override
	public JSONObject getJSONEvents(String country) {
		JSONObject event=null;
		String data = "";
		String line = "";

		try {

			URLConnection openConnection = new URL(url + country + "&apikey=" + apiKey).openConnection();
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
}

