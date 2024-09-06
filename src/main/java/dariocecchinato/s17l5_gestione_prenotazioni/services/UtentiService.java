package dariocecchinato.s17l5_gestione_prenotazioni.services;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.NotFoundException;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UtentiService {
    @Autowired
    private UtenteRepository utenteRepository;

    public void saveUtente (Utente newUtente){
        if (utenteRepository.existsByNome(newUtente.getNome())) throw new SavingException("L' utente gia esiste nel DB");
        utenteRepository.save(newUtente);
        log.info("L' utente " + newUtente.getNome() + " è stato salvato");
    }

    public Utente findById (UUID id){
        return  utenteRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }
}
