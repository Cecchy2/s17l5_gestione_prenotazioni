package dariocecchinato.s17l5_gestione_prenotazioni.services;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.TipoPostazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.NotFoundException;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.repositories.PostazioniAziendaliRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public PostazioneAziendale findById(UUID id) {
        return postazioniAziendaliRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    public List<PostazioneAziendale> findByTipoPostazione (TipoPostazione tipoPostazione){
        return postazioniAziendaliRepository.findByTipoPostazione(tipoPostazione);
    }
}
