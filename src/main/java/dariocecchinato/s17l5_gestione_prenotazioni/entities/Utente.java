package dariocecchinato.s17l5_gestione_prenotazioni.entities;

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
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userName;
    private String nome;
    private String eMail;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni = new ArrayList<>();

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", nome='" + nome + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
