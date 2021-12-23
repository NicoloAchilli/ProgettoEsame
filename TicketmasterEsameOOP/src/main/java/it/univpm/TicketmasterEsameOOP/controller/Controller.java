package it.univpm.TicketmasterEsameOOP.controller;

import java.util.Vector;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.model.Country;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.service.*;
import it.univpm.TicketmasterEsameOOP.statistics.StatisticsImpl;
import it.univpm.TicketmasterEsameOOP.statistics.StatisticsImpl.*;
import it.univpm.TicketmasterEsameOOP.model.*;

@RestController
public class Controller {
	
	//@Autowired
	private ServiceImpl s=new ServiceImpl();
	private StatisticsImpl st= new StatisticsImpl();

	@GetMapping(value="/countryCode")
	public JSONObject getJSONEventsPL(){
		return new JSONObject(s.toJson(s.parse(s.getJSONEventsPL())));

	}
	
	@GetMapping(value="/{countryCode}")
	public JSONObject getJSONEvents(@PathVariable String countryCode){
		return s.getJSONEvents(countryCode);
	}
	
	/*@GetMapping(value="/{countryCode}")
	public JSONObject getJSONEventsM(@RequestParam(name="countryCode",defaultValue = "PL") String countryCode){
		return s.getJSONEvents(countryCode);
	}*/
	
	/*@GetMapping(value="/classifications")
	public JSONObject getTypeEvent(){
		return s.getTypeEvent();
	}*/
	
	@GetMapping(value="/statistics")
	public JSONObject getstat(){
		return st.NTOTEvent();
	}
	
	
	
	
	/*@RequestMapping(value="/events")
	public ResponseEntity<Object> getJSONEvent(@RequestParam(name = "countryCode", defaultValue = "PL")String country){
		return new ResponseEntity<>(service.toJSON(service.getEvent(service.getJSONEvents("PL"))), HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value="/events", method=RequestMethod.GET)
	public ResponseEntity<Object> getJSONEvents(@RequestParam(name = "countryCode", defaultValue = "PL ")String country){
		return new ResponseEntity<>(service.getJSONEvents(country), HttpStatus.OK);
	}*/
	
	/*@RequestMapping(value="/events")
	public ResponseEntity<Object> getJSONEvents(String country){
		return new ResponseEntity<>(service.getJSONEvents(country), HttpStatus.OK);
	}*/
	
	
	/*@RequestMapping(value="/discovery/v2/events")
	public ResponseEntity<Object> getJSONEvent(@RequestParam(name = "countryCode", defaultValue = "PL")String country){
		return new ResponseEntity<>(service.toJSON(service.getEvent(service.getJSONEvents("PL"))), HttpStatus.OK);
	}*/
	
	

}
