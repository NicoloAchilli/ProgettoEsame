package it.univpm.TicketmasterEsameOOP.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import it.univpm.TicketmasterEsameOOP.service.*;


@RestController
public class Controller {
	
	//@Autowired
	private ServiceImpl s=new ServiceImpl();


	@GetMapping(value="/countryCode")
	public JSONObject getJSONEventsPL() throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEventsPL())));

	}
	
	/*@GetMapping(value="/{countryCode}")
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
	
	/*@GetMapping(value="/statistics")
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
