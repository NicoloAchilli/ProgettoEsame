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

public class ServiceImpl implements Service{

	private String url = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";
	
	//@Override
	public JSONObject getJSONEvent(String country) {
		JSONObject event = null;
	
	try {

		URLConnection openConnection = new URL(url + "countryCode=" + country + "&apikey=" + apiKey).openConnection();
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
		
	} catch (IOException | ParseException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return event;
}
}
