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
import org.springframework.web.bind.annotation.RestController;

import it.univpm.TicketmasterEsameOOP.exception.EventiException;
import it.univpm.TicketmasterEsameOOP.filters.FiltersCountry;
import it.univpm.TicketmasterEsameOOP.filters.FiltersGenre;
import it.univpm.TicketmasterEsameOOP.model.Event;
import it.univpm.TicketmasterEsameOOP.model.Evento;
import it.univpm.TicketmasterEsameOOP.service.*;
import it.univpm.TicketmasterEsameOOP.statistics.EventStats;
import it.univpm.TicketmasterEsameOOP.statistics.MinMaxMediaStats;

/**
 * Classe che gestisce tutte le chiamate.
 * 
 * @author Renzi Luca
 * @author Achilli Nicolò
 *
 */

@RestController
public class Controller {

	@Autowired
	private ServiceImpl s=new ServiceImpl();
	
	/**
	 * Rotta di tipo GET che mostra tutti gli eventi e le relative informazioni di un determinato stato.
	 * 
	 * 
	 * @return insieme di eventi dello stato di default, la Polonia
	 */

	@GetMapping(value="/events")
	public JSONObject getJSONEvents() throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEvents("PL"))));
	}
	
	/**
	 * Rotta di tipo GET che mostra tutti gli eventi e le relative informazioni di un determinato stato.
	 * 
	 * @param CountryCode sigla dello stato di cui si vogliono conoscere gli eventi.
	 * @return insieme di eventi di un determinato stato.
	 */
	
	@GetMapping(value="/events/{countryCode}")
	public JSONObject getJSONEvents(@PathVariable String countryCode) throws ParseException{
		return new JSONObject(s.toJson(s.parse(s.getJSONEvents(countryCode))));
	}
	
	/**
	 * Rotta di tipo GET che mostra il numero di eventi per un determinato genere.
	 * 
	 * @param CountryCode sigla dello stato di cui si vogliono conoscere gli eventi.
	 * @param genre genere dell'evento.
	 * @return gli eventi per un deterinato paese e un determinato genere e quelli del paese di default(Polonia) con lo stesso genere
	 */

	@SuppressWarnings("unchecked")
	@GetMapping(value="/events/{countryCode}/{genre}")
	public JSONObject getJSONEvents(@PathVariable String countryCode, @PathVariable String genre){
		JSONObject obj=new JSONObject();
		obj.put("Default (PL)", s.toJson(s.parse(s.getJSONEvents("PL"))));
		obj.put("Scelta utente",s.toJson(s.parse(s.getJSONEventsG(countryCode,genre))));
		
		return obj;
	}
	
	/**
	 * Rotta di tipo GET che fornisce il numero minimo/massimo/medio di eventi mensili di uno stato.
	 * 
	 * @param CountryCode sigla dello stato di cui si vogliono conoscere gli eventi.
	 * @return il numero minimo/massimo/medio di eventi mensili di uno stato.
	 */
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/{CountryCode}")
	public JSONObject getEventiMensili(@PathVariable String CountryCode){
		MinMaxMediaStats stats=new MinMaxMediaStats();
		
		JSONObject obj=new JSONObject();
		obj.put("Default (PL)",stats.EventiMensili("PL"));
		obj.put("Utente",stats.EventiMensili(CountryCode));
		return obj;
	}
	
	/**
	 * Rotta di tipo GET che mostra il numero totale di eventi per un determinato stato.
	 * 
	 * @param Countrycode sigla dello stato di cui si vogliono conoscere gli eventi.
	 * @return il numero totale degli eventi.
	 */
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/eventnum/{CountryCode}")
	public JSONObject  getNumEventi(@PathVariable String CountryCode){
		EventStats stats=new EventStats();
		JSONObject obj=new JSONObject();
		obj.put("Default (PL)",stats.totEventi("PL"));
		obj.put("Utente",stats.totEventi(CountryCode));
		return obj;
	}
	
	/**
	 * Rotta di tipo POST che filtra in base a uno o piu stati, uno o piu generi
	 *	per il calcolo degli eventi.
	 * 
	 * Il body inserito dall' utente deve essere di questo tipo:
	 * 
	 * {
	 *	"stati":[
     *  	{ 
     *  	"stato1":"PL"
     * 	},
  	 * {
     *	"stato2":"FR"
     *	}
     * ],
     *	"generi":[
     *	{
     *	"genere1":"Music"
     *	},
     *	{
     *	"genere2":"Sport"
     *	}
     * ]
     * }
     * 
     * @param bodyFilter Body come indicato in precedenza.
     * @return le statistiche filtrate in base ai parametri inseriti.
	*/
	@SuppressWarnings("unchecked")
	@PostMapping(value="/filters")
	public JSONObject getFilteredEvents(@RequestBody String bodyFilter){

		JSONObject result=new JSONObject();
		JSONArray eventi=new JSONArray();
		JSONArray eventi2=new JSONArray();
		
		Vector<Event>eventidaFiltrare=new Vector<Event>();
		Vector<Event>eventidaFiltrare2=new Vector<Event>();
		
		JSONObject eventiFiltratiPerStato=new JSONObject();
		JSONObject eventiFiltratiPerStato2=new JSONObject();
		JSONObject eventiFiltratiPerGenere=new JSONObject();
		JSONObject eventiFiltratiPerGenere2=new JSONObject();
		JSONObject eventiFiltratiPerGenere3=new JSONObject();
		JSONObject eventiFiltratiPerGenere4=new JSONObject();

		Evento eb;
		Vector<String>stati,generi;

		FiltersCountry filtrostati=new FiltersCountry();
		FiltersGenre filtrogenere=new FiltersGenre();

		eb=s.readBody(bodyFilter);

		stati=eb.getStati();
		generi=eb.getGeneri();
		String stato1=stati.get(0);
		String stato2=stati.get(1);
		String genere1=generi.get(0);
		String genere2=generi.get(1);

		eventidaFiltrare=s.parse(s.getJSONEvents(stato1));

		eventidaFiltrare2=s.parse(s.getJSONEvents(stato2));

		eventiFiltratiPerStato=filtrostati.FilterCountry(stato1,filtrogenere.FiltroPiuGeneri(genere1, genere2, eventidaFiltrare));
		eventiFiltratiPerGenere=filtrogenere.FiltroGenere(genere1, eventidaFiltrare);
		eventiFiltratiPerGenere3=filtrogenere.FiltroGenere(genere1, eventidaFiltrare2);
		Event ev=new Event();
		ev=eventidaFiltrare.get(0);	
		
		eventiFiltratiPerStato2=filtrostati.FilterCountry(stato2, filtrogenere.FiltroPiuGeneri(genere1, genere2, eventidaFiltrare2));
		eventiFiltratiPerGenere2=filtrogenere.FiltroGenere(genere2, eventidaFiltrare2);
		eventiFiltratiPerGenere4=filtrogenere.FiltroGenere(genere2, eventidaFiltrare);
		Event ev1=new Event();
		ev1=eventidaFiltrare2.get(0);
		
		result.put("Eventi in "+ev.getCountryName(),eventiFiltratiPerStato);
		
		eventi.add(eventiFiltratiPerGenere);
		eventi.add(eventiFiltratiPerGenere3);
	
		result.put("Eventi per il genere "+genere1,eventi);
		
		result.put("Eventi in "+ev1.getCountryName(),eventiFiltratiPerStato2);
		
		eventi2.add(eventiFiltratiPerGenere2);
		eventi2.add(eventiFiltratiPerGenere4);
		
		result.put("Eventi per il genere "+genere2,eventi2);
		
		return result;
	}	
}

