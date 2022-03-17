# ProgettoEsame
<h1 align="center"> Progetto-Programmazione-Ad-Oggetti </h1>

<h1 align="center"> TicketMaster </h1>
 

## **Sommario**

* [Introduzione](#introduzione)
  * [Statistiche e Filtri](#statistiche-e-filtri)
* [Installazione](#installazione)
* [Rotte](#rotte)
* [JUnit Test](#junit-test)
* [Documentazione JavaDoc](#documentazione-javadoc)
* [Software Utilizzati](#software-utilizzati)
* [Autori](#autori)


## Introduzione
"TicketMasterEEsameOOP" è un'applicazione che consente all'utente di confrontare le statistiche degli eventi che avranno luogo in Europa e in Polonia, utilizzando le APi di ticketmaster, sito per la gestione ed la prenotazione di vari eventi (musicali, artistici, sportivi, ecc...).

## Statistiche e Filtri
L'applicazione sviluppata fornisce le seguenti statistiche:
* numero totale di eventi per ogni Paese e complessivi.
* numero totale di eventi raggruppati per genere per ogni Paese e complessivi.
* numero minimo/massimo/media degli eventi mensili per ogni Paese e complessivi.

e offre i seguenti filtri:
* filtro eventi in Europa in base a uno o più Paesi.
* filtro eventi in Europa in base a di uno o più generi.


## Rotte
Le richieste che l'utente può effettuare tramite Postman devono essere all'indirizzo:

localhost:8080

## Rotta1 GET /events

La rotta restituisce un JSONObject contenente tutti gli eventi e le relative informazioni riferiti alla Polonia.

## Rotta2 GET /events/{coutnryCode}

La rotta restituisce un JSONObject contenente tutti gli eventi e le relative informazioni riferite ad un determinato Paese passato come parametro.

 ## Rotta3 GET /events/{contryCode}/{genre}
 
 La rotta restituisce un JSONObject contenente gli eventi del Paese e del genere passati come parametro, facendo il confronto degli eventi in Polonia dello stesso genere passato prima come parametro.
 
 ## Rotta4 POST /filtres 
 
La rotta restituisce un JSONObject contenente una lista di eventi filtrati per Paese e genere.

## Documentazione JavaDoc

Il codice java dell'applicazione "TicketMasterEsameOOP" è interamente documentato attraverso Javadoc.

