package it.univpm.TicketmasterEsameOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

public class ServiceImpl implements Service{

	private String url = "https://app.ticketmaster.com/discovery/v2";
	private String apikey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";
	
	//@Override
	public JSONObject getJSONEvents(String country) {
		JSONObject event = null;
	
	try {

		URLConnection openConnection = new URL(url + "countryCode=" + country + "&apikey=" + apikey).openConnection();
		InputStream in = openConnection.getInputStream();

		String data = "";
		String line = "";
		try {
			InputStreamReader inR = new InputStreamReader( in );
			BufferedReader buf = new BufferedReader( inR );

			while ( ( line = buf.readLine() ) != null ) {
				data+= line;
			}
		} finally {
			in.close();
		}
		//JSONArray obj = (JSONArray) JSONValue.parseWithException(data);	//parse JSON Array
		event = (JSONObject) JSONValue.parseWithException(data);	 //parse JSON Object
		
	} catch (IOException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return event;
}

	@Override
	public JSONObject toJSON(Country country) {
		return null;
	}

	

	@Override
	public Event getEvent(JSONObject event) {
		// TODO Auto-generated method stub
		return null;
	}
}
