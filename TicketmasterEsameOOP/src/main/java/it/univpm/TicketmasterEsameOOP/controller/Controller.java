package it.univpm.TicketmasterEsameOOP.controller;

import org.json.simple.JSONObject;
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

	@GetMapping(value="/countryCode")
	public String getJSONEventsPL(){
		return s.getJSONEventsPL();
	}
	
	@GetMapping(value="/{countryCode}")
	public String getJSONEvents(@PathVariable String countryCode){
		return s.getJSONEvents(countryCode);
	}
	
	@GetMapping(value="/classifications")
	public String getTypeEvent(){
		return s.getTypeEvent();
	}
}
