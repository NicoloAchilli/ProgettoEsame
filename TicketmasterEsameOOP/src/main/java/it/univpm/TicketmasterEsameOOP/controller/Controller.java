package it.univpm.TicketmasterEsameOOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.service.*;

import it.univpm.TicketmasterEsameOOP.model.*;
@RestController
public class Controller {
	
	//@Autowired
	private ServiceImpl s=new ServiceImpl();

	@GetMapping(value="/{countryCode}")
	public String getJSONEvent(@PathVariable String countryCode){
		return s.getJSONEvents(countryCode);
	}
	/*@RequestMapping(value="/discovery/v2/events")
	public ResponseEntity<Object> getJSONEvent(@RequestParam(name = "countryCode", defaultValue = "PL")String country){
		return new ResponseEntity<>(service.toJSON(service.getEvent(service.getJSONEvents("PL"))), HttpStatus.OK);
	}*/
}
