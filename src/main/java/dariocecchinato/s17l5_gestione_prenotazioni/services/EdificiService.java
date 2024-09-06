package dariocecchinato.s17l5_gestione_prenotazioni.services;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.repositories.EdificiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EdificiService {
    @Autowired
    private EdificiRepository edificiRepository;

    public void saveEdificio (Edificio newEdificio){
        if (newEdificio== null) throw new RuntimeException("Non hai inserito nessun altro edificio da salvare");
        if (edificiRepository.existsByNome(newEdificio.getNome())) throw new SavingException("L' edificio è già presente nel DB");
        edificiRepository.save(newEdificio);
        log.info("L' edificio " + newEdificio.getNome() + " è stato aggiunto");
    }

}
