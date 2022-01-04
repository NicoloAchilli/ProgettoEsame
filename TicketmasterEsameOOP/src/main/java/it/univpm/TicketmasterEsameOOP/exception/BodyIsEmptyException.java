package it.univpm.TicketmasterEsameOOP.exception;

public class BodyIsEmptyException extends Exception{
	private static final long serialVersionUID = 1L;

    public BodyIsEmptyException() {
        super("Il body del post non contiene nulla");
    }
}

