package it.univpm.TicketmasterEsameOOP.controller;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping(value="/event")
	public ResponseEntity<Object> getEvent()
	
}
