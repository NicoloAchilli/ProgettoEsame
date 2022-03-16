package it.univpm.TicketmasterEsameOOP.statistics;

import org.json.simple.JSONObject;

import it.univpm.TicketmasterEsameOOP.service.ServiceImpl;

public class MinMaxMediaStats {
	private int min;
	private int max;
	private double media;
	ServiceImpl service=new	ServiceImpl();
	
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
	
	public int minEventi(int[]numeroEventi) {
		sortSelectedEvents(numeroEventi);
		return this.min=numeroEventi[0];	
	}
	
	public int maxEventi(int[]numeroEventi) {
		int max=numeroEventi.length;
		sortSelectedEvents(numeroEventi);
		return this.max=numeroEventi[max-1];
	}
	
	public double mediaEventi(int[]numeroEventi) {
		int cont=0;

		for(int i=0;i<numeroEventi.length;i++) {
			cont+=numeroEventi[i];
			this.media=(double)cont/(double)numeroEventi.length;
		}
		return this.media;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject EventiMensili(String stateCode) {

        EventStats stat=new EventStats();

        min=minEventi(stat.MonthsEvents(stateCode));
        max=maxEventi(stat.MonthsEvents(stateCode));
        media=mediaEventi(stat.MonthsEvents(stateCode));

        JSONObject obj=new JSONObject();
        JSONObject object=new JSONObject();
        
        obj.put("numero minimo di eventi",min);
        obj.put("numero massimo di eventi",max);
        obj.put("numero medio di eventi",media);
        object.put("Statistiche mensili",obj);
        return object;
    }	
	}
