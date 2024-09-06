package dariocecchinato.s17l5_gestione_prenotazioni.services;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.repositories.PostazioniAziendaliRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostazioniAziendaliService {
    @Autowired
    private PostazioniAziendaliRepository postazioniAziendaliRepository;

    public void savePostazione(PostazioneAziendale newPostazione){
        if (postazioniAziendaliRepository.existsByTipoPostazioneAndEdificio(newPostazione.getTipoPostazione(), newPostazione.getEdificio())) throw new SavingException("La postazione già esiste nel DB");
        postazioniAziendaliRepository.save(newPostazione);
        log.info("La postazione " + newPostazione.getTipoPostazione() + " è stata salvata");
    }

}
