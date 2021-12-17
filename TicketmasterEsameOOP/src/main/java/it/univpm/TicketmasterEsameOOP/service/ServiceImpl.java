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

import it.univpm.TicketmasterEsameOOP.model.Event;


import it.univpm.TicketmasterEsameOOP.model.Country;
import it.univpm.TicketmasterEsameOOP.model.Event;

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


	public JSONObject getTypeEvent(String type) {
		JSONObject event=null;
		String data = "";
		String line = "";
		
	try {

		URLConnection openConnection = new URL("https://app.ticketmaster.com/discovery/v2/classifications.json?" + "&countryCode=PL"  +"&apikey=" + apiKey).openConnection();
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

	
}
	



	
/*	public  String toJSONOString (JSONObject obj) {
		//Event e=new Event(null,null,0, null,0);
		JSONObject event=getJSONEventsPL();
		String e= (String) JSONValue.toJSONString(event);	 //parse JSON Objec
		
		}*/

