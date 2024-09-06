package dariocecchinato.s17l5_gestione_prenotazioni.repositories;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {

    boolean existsByNome (String nome);

    Utente findByNome (String nome);

    Optional<Utente> findById (UUID id);
}
