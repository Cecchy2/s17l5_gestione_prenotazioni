package dariocecchinato.s17l5_gestione_prenotazioni.services;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.StatoPrenotazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Prenotazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.repositories.PrenotazioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
        prenotazione.setStatoPrenotazione(StatoPrenotazione.PRENOTATA);
        return prenotazioniRepository.save(prenotazione);
    }
    public void aggiornaStatoPrenotazioni() {
        List<Prenotazione> prenotazioni = prenotazioniRepository.findAll();
        for (Prenotazione prenotazione : prenotazioni) {
            prenotazione.aggiornaStato();
            prenotazioniRepository.save(prenotazione);
        }
    }
}
