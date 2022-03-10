package it.univpm.TicketmasterEsameOOP.controller;

import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.exception.BodyIsEmptyException;
import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.filters.FiltersCountry;
import it.univpm.TicketmasterEsameOOP.filters.FiltersGenre;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.service.*;
import it.univpm.TicketmasterEsameOOP.statistics.StatisticsImpl;


@RestController
public class Controller {

	@Autowired
	private ServiceImpl s=new ServiceImpl();

	@GetMapping(value="/events")
	public JSONObject getJSONEvents() throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEvents("PL"))));
	}

	@GetMapping(value="/events/{countryCode}")
	public JSONObject getJSONEvents(@PathVariable String countryCode) throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEvents(countryCode))));
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value="/events/{countryCode}/{genre}")
	public JSONObject getJSONEvents(@PathVariable String countryCode, @PathVariable String genre){
		JSONObject obj=new JSONObject();
		obj.put("Default", s.toJson(s.parse(s.getJSONEvents("PL"))));
		obj.put("Scelta utente",s.toJson(s.parse(s.getJSONEventsG(countryCode,genre))));
		return obj;
	}

	@PostMapping(value="/filters")
	public JSONObject getFilteredEvents(@RequestBody JSONObject bodyFilter, @RequestParam(name = "CountryCode", defaultValue = "PL") String CountryCode,
			@RequestParam(name = "genre") String genre) throws BodyIsEmptyException{

		//if(bodyFilter.isEmpty()) throw new BodyIsEmptyException();
		
		JSONObject obj=new JSONObject();

		JSONObject risultato=new JSONObject();
		JSONArray eventi=new JSONArray();
		JSONArray eventi2=new JSONArray();
		Vector<Event>eventidaFiltrare=new Vector<Event>();
		Vector<Event>eventidaFiltrare2=new Vector<Event>();
		JSONObject eventiFiltratiPerStati=new JSONObject();
		JSONObject eventiFiltratiPerStati2=new JSONObject();
		JSONObject eventiFiltratiPerGenere=new JSONObject();
		JSONObject eventiFiltratiPerGenere2=new JSONObject();
		JSONObject eventiFiltratiPerGenere3=new JSONObject();
		JSONObject eventiFiltratiPerGenere4=new JSONObject();

		Evento eb;
		Vector<String>stati,generi;

		FiltersCountry filtrostati=new FiltersCountry();
		FiltersGenre filtrogenere=new FiltersGenre();

		eb=s.parsingbodyfilter(bodyFilter);

		stati=eb.getStati();
		generi=eb.getGeneri();
		String stato1=stati.get(0);
		String stato2=stati.get(1);
		String genere1=generi.get(0);
		String genere2=generi.get(1);
		
		try {
			eventidaFiltrare=s.(stato1);
		} catch (EventiException e) {
			e.printStackTrace();
		}
		
		try {
			eventidaFiltrare2=s.getStatoEvents(stato2);
		} catch (EventiException e) {
			e.printStackTrace();
		}
		
		eventiFiltratiPerStati=filtrostati.FilterCountry(stato1,filtrogenere.FiltroPiuGeneri(genere1, genere2, eventidaFiltrare))));
		eventiFiltratiPerStati2=filtrostati.FilterCountry(stato2, filtrogenere.FiltroPiuGeneri(genere1, genere2, eventidaFiltrare2))));
		
		//eventiFiltratiPerGenere=filtrogenere.FiltroGenere(genere1, eventidaFiltrare);
		
		eventiFiltratiPerGenere3=filtrogenere.FiltroGenere(genere1,filtroperiodo.filtroperiodo(inizio, fine,eventidaFiltrare2));
		Evento ev1=new Evento();
		ev1=eventidaFiltrare.get(0);
		
		risultato.put("Eventi in "+ev1.getStati(),eventiFiltratiPerStati);
		
		
		return risultato;
	}	
}

