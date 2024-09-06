package dariocecchinato.s17l5_gestione_prenotazioni.repositories;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, UUID> {

    Edificio findByNome(String nome);

    boolean existsByNome(String nome);
}
