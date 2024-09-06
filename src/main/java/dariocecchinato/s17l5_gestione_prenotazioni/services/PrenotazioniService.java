package dariocecchinato.s17l5_gestione_prenotazioni.services;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Prenotazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.repositories.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    public Prenotazione creaPrenotazione(LocalDate data, PostazioneAziendale postazione, Utente utente){
        if (prenotazioniRepository.existsByUtenteAndDataPrenotazione(utente, data))
            throw new SavingException("L' utente " + utente.getNome() + " ha un' altra prenotazione per quella data");
        if (prenotazioniRepository.existsByPostazioneAziendaleAndDataPrenotazione(postazione,data))
            throw  new SavingException("La postazione è già stata prenotata da un altro Utente");
        Prenotazione prenotazione = new Prenotazione(data,postazione,utente);
        return prenotazioniRepository.save(prenotazione);
    }
}
