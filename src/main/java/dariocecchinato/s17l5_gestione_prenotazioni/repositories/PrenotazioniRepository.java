package dariocecchinato.s17l5_gestione_prenotazioni.repositories;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Prenotazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    boolean existsByPostazioneAziendaleAndDataPrenotazione(PostazioneAziendale postazioneAziendale, LocalDate data);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);
}
