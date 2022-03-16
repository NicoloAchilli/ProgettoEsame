package it.univpm.TicketmasterEsameOOP;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.service.ServiceImpl;

public class ToJSONtest {
	Event ev;
	Vector <Event> eventi;
	ServiceImpl test;
	
	@BeforeEach
	void setUp() throws Exception {
		eventi=new Vector<Event>();
		ev=new Event();
		test=new ServiceImpl();
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void test() {

		ev.setName("Michał Wiśniewski Akustycznie Część 2 - ZAWSZE NAPRZÓD - NIGDY WSTECZ");
		ev.setId("Z698xZQpZa7cv");
		ev.setDate("2022-03-17");
		ev.setCountryName("Poland");
		ev.setCountryName("PL");
		ev.setGenreName("Music");
		eventi.add(ev);
		
		JSONObject output = new JSONObject();
		JSONArray eventList = new JSONArray();
		
		for(Event singleEvent : eventi) {
			JSONObject obj = new JSONObject();
			
			output.put("coutryName", singleEvent.getCountryName());	
			output.put("countryCode", singleEvent.getCountryName());
			
			obj.put("name", singleEvent.getName());
			obj.put("id", singleEvent.getId());
			obj.put("date", singleEvent.getDate());
			obj.put("genre", singleEvent.getGenreName());

			eventList.add(obj);	
		}
		
		output.put("events", eventList);
		JSONObject result=test.toJson(eventi);
		assertEquals (output, result);
	}

}

