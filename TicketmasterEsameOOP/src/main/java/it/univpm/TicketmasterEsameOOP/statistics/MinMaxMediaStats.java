package it.univpm.TicketmasterEsameOOP.statistics;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.service.ServiceImpl;

/**
 * 
 * Classe che fornisce le statische del numero minimo/massimo/medio di eventi mensili
 *
 */

public class MinMaxMediaStats {
	private int min;
	private int max;
	private double media;
	ServiceImpl service=new	ServiceImpl();

	/**
	 * 
	 * Metodo che ordina il vettore contenente il numero di eventi di uno stato in un determinato mese (in modo crescente).
	 * 
	 * @param numEventi Vettore che contiene il numero di eventi mensili da ordinare
	 * @return numEventi Vettore ordinato in modo crescente.
	 */
	public int[] sortSelectedEvents(int[] numEventi) {

		int n=numEventi.length;
		int temp=0;  

		for(int i=0;i<n;i++){  

			for(int j=1;j<(n-i);j++){  

				if(numEventi[j-1]>numEventi[j]){ 

					temp=numEventi[j-1];  
					numEventi[j-1]=numEventi[j];  
					numEventi[j]=temp;  

				}  
			}  
		}    
		return numEventi;	
	}

	/**
	 * Metodo che restituisce il numero minimo di eventi.
	 * 
	 * @param numeroEventi Vettore contenente il numero di eventi.
	 * @return min Numero minimo di eventi.
	 */
	public int minEventi(int[]numeroEventi) {
		sortSelectedEvents(numeroEventi);
		return this.min=numeroEventi[0];	
	}

	/**
	 * Metodo che restituisce il numero massimo di eventi.
	 * 
	 * @param numeroEventi Vettore contenente il numero di eventi.
	 * @return max Numero massimo di eventi.
	 */ 
	public int maxEventi(int[]numeroEventi) {
		int max=numeroEventi.length;
		sortSelectedEvents(numeroEventi);
		return this.max=numeroEventi[max-1];
	}

	/**
	 * Metodo che restituisce la media degli eventi.
	 * 
	 * @param numeroEventi Vettore contenente il numero di eventi.
	 * @return media Media degli eventi
	 */
	public double mediaEventi(int[]numeroEventi) {
		int cont=0;

		for(int i=0;i<numeroEventi.length;i++) {
			cont+=numeroEventi[i];
			this.media=(double)cont/(double)numeroEventi.length;
		}
		return this.media;
	}

	/**
	 * 
	 * Metodo che fornisce il numero minimo/massimo/medio di eventi mensili e restituisce il  suo corrispondente JSONObject.
	 * @param statecode nome dello stato di cui si vogliono visualizzare gli eventi.
	 * @return object JSONObject contente il nummero minimo/massimo/medio di eventi mensili.
	 */
	@SuppressWarnings("unchecked")
	public JSONObject EventiMensili(String statecode) {

		EventStats stat=new EventStats();

		min=minEventi(stat.MonthsEvents(statecode));
		max=maxEventi(stat.MonthsEvents(statecode));
		media=mediaEventi(stat.MonthsEvents(statecode));

		JSONObject obj=new JSONObject();
		JSONObject object=new JSONObject();

		obj.put("numero minimo di eventi",min);
		obj.put("numero massimo di eventi",max);
		obj.put("numero medio di eventi",media);
		object.put("Statistiche mensili",obj);
		return object;
	}	
}
