package it.univpm.TicketmasterEsameOOP.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;

import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
@Service
public class ServiceImpl implements Service{

	private String URL = "https://app.ticketmaster.com/discovery/v2/events.json?";
	private String apiKey = "WGbdslACGAbDUNgCjGnrpZQrvnq299KR";
	
	@Override
	public JSONObject getJSONEvents (String country) {
		JSONObject Events=null;
		
		try {
			URLConnection openConnection=new url(URL + "&apikey=" + apiKey);
			InputStream in = openConnection.getInputStream();
		
			String data="";
			String line="";
			try {
				InputStreamReader inR =new InputStreamReader(in);
				BufferedReader buf =new BufferedReader(inR);
				
				while ((line=buf.readLine() ) !=null) {
					data+=line;
				}	
			}finally {
				in.close();
			}
			country=(JSONObject)JSONValue.parseWithException(data);		
	}catch(IOException | ParseException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	
}
