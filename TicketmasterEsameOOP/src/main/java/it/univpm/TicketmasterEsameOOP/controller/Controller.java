package it.univpm.TicketmasterEsameOOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.service.Service;

@RestController
public class Controller {
	
	@Autowired
	private Service service;

	@RequestMapping(value="/events")
	public ResponseEntity<Object> getJSONEvent(){
		return new ResponseEntity<>();
	}
	
}
