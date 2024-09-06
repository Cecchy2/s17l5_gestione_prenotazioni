package dariocecchinato.s17l5_gestione_prenotazioni.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
	public NotFoundException(UUID id){
		super("Il record con id " + id + " non è stato trovato!");
	}
}
