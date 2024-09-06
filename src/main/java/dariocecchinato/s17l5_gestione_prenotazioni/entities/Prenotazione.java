package dariocecchinato.s17l5_gestione_prenotazioni.entities;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.StatoPrenotazione;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private StatoPrenotazione statoPrenotazione;

    private LocalDate dataPrenotazione;
    private LocalDate finePrenotazione;

    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private PostazioneAziendale postazioneAziendale;

    @ManyToOne
    @JoinColumn(name = "utente_id", nullable = false)
    private Utente utente;

    public Prenotazione(LocalDate dataPrenotazione, PostazioneAziendale postazioneAziendale, Utente utente) {
        this.dataPrenotazione = dataPrenotazione;
        this.finePrenotazione = dataPrenotazione.plusDays(1);
        this.postazioneAziendale = postazioneAziendale;
        this.utente = utente;
this.statoPrenotazione= StatoPrenotazione.PRENOTATA;
    }

    public void aggiornaStato() {
        if (finePrenotazione != null && LocalDate.now().isAfter(finePrenotazione)) {
            this.statoPrenotazione = StatoPrenotazione.TERMINATA;
        }
    }

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
