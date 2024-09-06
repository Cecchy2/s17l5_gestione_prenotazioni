package dariocecchinato.s17l5_gestione_prenotazioni.entities;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.StatoPrenotazione;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private StatoPrenotazione statoPrenotazione;
    private LocalDate dataPrenotazione;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private PostazioneAziendale postazioneAziendale;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;


    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", statoPrenotazione=" + statoPrenotazione +
                ", dataPrenotazione=" + dataPrenotazione +
                ", postazioneAziendale=" + postazioneAziendale +
                '}';
    }
}
