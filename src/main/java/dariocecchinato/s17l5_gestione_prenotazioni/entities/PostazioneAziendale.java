package dariocecchinato.s17l5_gestione_prenotazioni.entities;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.TipoPostazione;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PostazioneAziendale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private String descrizione;
    private int numeroMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazioneAziendale")
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    public PostazioneAziendale(TipoPostazione tipoPostazione, String descrizione, int numeroMaxOccupanti, Edificio edificio) {
        this.tipoPostazione = tipoPostazione;
        this.descrizione = descrizione;
        this.numeroMaxOccupanti = numeroMaxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "PostazioneAziendale {\n" +
                "   ID: " + id + ",\n" +
                "   Edificio: " + edificio + ",\n" +
                "   Numero massimo occupanti: " + numeroMaxOccupanti + ",\n" +
                "   Descrizione: '" + descrizione + "',\n" +
                "   Tipo di postazione: " + tipoPostazione + "\n" +
                "}";
    }
}
