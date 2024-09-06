package dariocecchinato.s17l5_gestione_prenotazioni.repositories;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.TipoPostazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioniAziendaliRepository extends JpaRepository<PostazioneAziendale, UUID> {

    boolean existsByTipoPostazioneAndEdificio(TipoPostazione tipoPostazione, Edificio edificio);

    List<PostazioneAziendale> findByTipoPostazione (TipoPostazione tipoPostazione);

    List<PostazioneAziendale> findByTipoPostazioneAndEdificioCitta(TipoPostazione tipoPostazione, String citta);

    List<PostazioneAziendale> findByEdificioNome(String nome);



}
