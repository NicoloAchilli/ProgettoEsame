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
```json
{
    "coutryName": "Poland",
    "countryCode": "PL",
    "events": [
        {
            "date": "2022-03-17",
            "name": "Michał Wiśniewski Akustycznie Część 2 - ZAWSZE NAPRZÓD - NIGDY WSTECZ",
            "genre": "Music",
            "id": "Z698xZQpZa7cv"
        },
        {
            "date": "2022-03-19",
            "name": "Paddy and the Rats",
            "genre": "Music",
            "id": "Z698xZQpZa7md"
        },
        {
            "date": "2022-03-19",
            "name": "Strażak Sam Na Żywo - Cyrkowa Przygoda",
            "genre": "Miscellaneous",
            "id": "Z698xZQpZaA-M"
        },
        {
            "date": "2022-03-18",
            "name": "Punky Reggae live 2022: Farben Lehnre + Kobranocka + Gutek + support",
            "genre": "Music",
            "id": "Z698xZQpZaAE4"
        }
    ]
}
```
## Rotta2 GET /events/{coutnryCode}

La rotta restituisce un JSONObject contenente tutti gli eventi e le relative informazioni riferite ad un determinato Paese passato come parametro.
```json
{
    "coutryName": "Germany",
    "countryCode": "DE",
    "events": [
        {
            "date": "2022-06-14",
            "name": "Imagine Dragons | Ultimate Imagine Dragons Fan Experience",
            "genre": "Music",
            "id": "Z698xZC2Z178z7M"
        },
        {
            "date": "2022-06-14",
            "name": "Imagine Dragons - Mercury World Tour",
            "genre": "Music",
            "id": "Z698xZC2Z178zZ_"
        },
        {
            "date": "2022-07-05",
            "name": "Imagine Dragons | Ultimate Imagine Dragons Fan Experience",
            "genre": "Music",
            "id": "Z698xZC2Z178zFE"
        },
        {
            "date": "2022-07-05",
            "name": "Imagine Dragons - Mercury World Tour",
            "genre": "Music",
            "id": "Z698xZC2Z178zZP"
        },
     ]
}
```
 ## Rotta3 GET /events/{contryCode}/{genre}
 
 La rotta restituisce un JSONObject contenente gli eventi del Paese e del genere passati come parametro, facendo il confronto degli eventi in Polonia dello stesso genere passato prima come parametro di default.
 ```json
 {
    "Default (PL)": {
        "countryCode": "PL",
        "coutryName": "Poland",
        "events": [
            {
                "date": "2022-06-30",
                "name": "HIP HOP KOPALNIA FESTIWAL - pole namiotowe",
                "genre": "Music",
                "id": "Z698xZQpZaARo"
            },
            {
                "date": "2022-07-01",
                "name": "HIP HOP KOPALNIA FESTIWAL",
                "genre": "Music",
                "id": "Z698xZQpZaAtd"
            },
            {
                "date": "2022-07-15",
                "name": "JAROCIN FESTIWAL 2022 - KARNET 3-DNIOWY",
                "genre": "Music",
                "id": "Z698xZQpZaAYy"
            },
            {
                "date": "2022-03-26",
                "name": "World Orchestra Grzech Piotrowski",
                "genre": "Music",
                "id": "Z698xZQpZaARS"
            }
        ]
    },
    "Scelta utente": {
        "countryCode": "FR",
        "coutryName": "France",
        "events": [
            {
                "date": "2022-07-03",
                "name": "Indochine (with coach)",
                "genre": "Music",
                "id": "Z698xZG2Za10h"
            }
        ]
    }
}
```
  ## Rotta4 GET /{contryCode}
 
La rotta restituisce un JSONObject contenente le statistiche del numero minimo/massimo/medio degli eventi del Paese passato come parametro, facendo il confronto degli eventi in Polonia inserito come parametro di default.
 ```json
{
    "Utente": {
        "Statistiche mensili": {
            "numero medio di eventi": 0.08333333333333333,
            "numero massimo di eventi": 1,
            "numero minimo di eventi": 0
        }
    },
    "Default (PL)": {
        "Statistiche mensili": {
            "numero medio di eventi": 1.6666666666666667,
            "numero massimo di eventi": 20,
            "numero minimo di eventi": 0
        }
    }
}
 ```
 ## Rotta5 GET/eventnum/{contryCode}
 La rotta restituisce un JSONObject contenente il numero totale degli eventi del Paese passato come parametro, facendo il confronto degli eventi in Polonia inserito come parametro di default.
  ```json
 {
    "Utente": {
        "Totale Eventi": 1
    },
    "Default (PL)": {
        "Totale Eventi": 20
    }
}
 ```
 ## Rotta6 POST /filtres 
 
La rotta restituisce un JSONObject contenente una lista di eventi filtrati per uno o più Paesi e per uno o più generi.Richiede un body di questo tipo:
  ```json
{
    "stati":[
        { 
            	"stato1":"PL"
        },
        { 
            	"stato1":"DE"
        }
    ],
    "generi":[
        {
            "genere1":"Music"
        },
        {
            "genere2":"Sport"
        }
    ]
}
```
- **stati** è il JSONArray che contiene gli stateCode degli stati di cui si vuole fare il filtraggio.
- **generi** è il JSONArray che contiene i generi degli eventi relativi al rispettivo stato di cui si vuole fare statistica.
## Documentazione JavaDoc

Il codice java dell'applicazione "TicketMasterEsameOOP" è interamente documentato attraverso Javadoc.

## JUnit Test
All'interno del progetto è presente anche un package di test contente le seguenti classi:

* [toJSONtest], un test del metodo toJSON contenuto nella classe ServiceImpl che verifica se l'oggetto viene convertito correttamente in JSONObject.

* [MinMaxMediaStatsTest], un test dei tre metodi contenuti nella classe MinMaxMedia che verifica se il calcolo del minimo,massimo e medio di un vettore è corretto.

## Software utilizzati

* L'IDE [Eclipse](https://www.eclipse.org/downloads/) per la scrittura del codice dell'intero applicativo
* [Postman](https://www.postman.com/downloads/) per il testing delle API, impiegato per gestire le chiamate `GET` e `POST` delle rotte.
* [GitHub](https://github.com/), per il versioning del codice dell'interfaccia. 
* [Git Bash](https://git-scm.com/downloads), per eseguire il versioning del codice tramite terminale direttamente dalla cartella locale del progetto.
* Il framework [JUnit 5](https://junit.org/junit5/), per lo Unit Testing dei metodi dell'applicativo
* L'applicativo [Javadoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html), incluso nel pacchetto [JDK](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2020-12/R/eclipse-java-2020-12-R-win32-x86_64.zip), utilizzato per la generazione automatica della documentazione del codice sorgente scritto in Java
* [Spring Inizializr](https://start.spring.io/), per la generazione del progetto. 
* Il framework [Spring](https://spring.io/), per l'esecuzione e sviluppo dell'applicazione Java.
* Il progetto [Spring Boot](https://spring.io/projects/spring-boot), che consente di avviare l'applicazione attraverso un metodo main che, a sua volta, lancia il web server integrato.
* L'IDE [Spring Tool Suite 4](https://spring.io/tools), per lo sviluppo di applicazioni Spring.
* Il tool [Spring Web](https://spring.io/guides/gs/serving-web-content/), affinchè l'applicazione possa accettare richieste `HTTP` all'indirizzo `localhost:8080`.
* Il tool [Apache Maven](https://maven.apache.org/), per la definizione della struttura del progetto mediante il file `pom.xml`.
* Il web server locale [Apache Tomcat](https://spring.io/blog/2014/03/07/deploying-spring-boot-applications), per la gestione delle richieste `HTTP`.

## Autori

Autori del progetto: 

-Nicolò Achilli

-Luca Renzi
