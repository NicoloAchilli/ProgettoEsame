package it.univpm.TicketmasterEsameOOP;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import it.univpm.TicketmasterEsameOOP.statistics.MinMaxMediaStats;

/**
 * Classe che testa il funzionamento dei metodi della Classe MinMaxMedia (stats).
 *
 */
public class MinMaxMediaStastTest {
	int [] v = {1,9,5,4,7,4,2,6,7,0,4,10} ; 
	int [] risultato = {0,1,2,4,4,4,5,6,7,7,9,10};
	MinMaxMediaStats test;
	
	/**
	 * Inizializza i componenti necessari per il test.
	 * @throws Exception
	 */
	
	@BeforeEach
	void setUp() throws Exception {
		test=new MinMaxMediaStats();
	}
	
	/**
	 * Serve per distruggere ciò che è stato inizializzato dal metodo setUp.
	 * @throws Exception
	 */

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test che verifica se il vettore v viene ordinato correttamente.
	 * 
	 */
	@Test
	void testSortSelected() {
		
		assertArrayEquals (risultato,test.sortSelectedEvents(v));
		
	}
	
	/**
	 * Test che verifica se il calcolo del minimo del vettore v è corretto.
	 */
	@Test
	void testMinEventi() {
		
		assertEquals (risultato[0],test.minEventi(v));
		
	}
	
	/**
	 * Test che verifica se il calcolo del massimo del vettore v è corretto.
	 */
	@Test
	void testMaxEventi() {
		
		assertEquals (risultato[risultato.length-1],test.maxEventi(v));
		
	}
	/**
	 * Test che verifica se il calcolo della media del vettore v è corretto.
	 */
	@SuppressWarnings("deprecation")
	@Test
	void testMediaEventi() {
		
		int cont=0;
		double media=0;
		
		for(int i=0;i<risultato.length;i++) {
			cont+=risultato[i];
			media=(double)cont/(double)risultato.length;
		}
		
		assertEquals (media,test.mediaEventi(v));
		
	}
} 

