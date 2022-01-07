package it.univpm.TicketmasterEsameOOP.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.exception.BodyIsEmptyException;
import it.univpm.TicketmasterEsameOOP.service.*;
import it.univpm.TicketmasterEsameOOP.statistics.StatisticsImpl;


@RestController
public class Controller {
	
	//@Autowired
	private ServiceImpl s=new ServiceImpl();
	private StatisticsImpl st= new StatisticsImpl();

	@GetMapping(value="/events")
	public JSONObject getJSONEvents() throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEvents("PL"))));
	}
	
	@GetMapping(value="/events/{countryCode}")
	public JSONObject getJSONEvents(@PathVariable String countryCode) throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEvents(countryCode))));
	}

	/*@GetMapping(value="/events/{countryCode}/{genre}")
	public JSONObject getJSONEvents(@PathVariable String countryCode, @PathVariable String genre){
		JSONObject obj=new JSONObject();
		obj.put("Default", s.toJson(s.parse(s.getJSONEvents("PL"))));
		obj.put("Scelta utente",s.toJson(s.parse(s.getJSONEventsG(countryCode,genre))));
		return obj;
	}*/
	
	@PostMapping(value="/filters")
	public JSONObject getFilteredEvents(@RequestBody JSONObject bodyFilter, @RequestParam(name = "CountryCode", defaultValue = "PL") String CountryCode,
																			   @RequestParam(name = "genre") String genre) throws BodyIsEmptyException{

		if(bodyFilter.isEmpty()) throw new BodyIsEmptyException();
		return new JSONObject(s.getFilteredEvents(bodyFilter));
	}
	
	
	}

