package dariocecchinato.s17l5_gestione_prenotazioni;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.TipoPostazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PostazioniAziendaliConfig {

    @Bean
    public PostazioneAziendale postazione1(Edificio edificio1){
        return new PostazioneAziendale(TipoPostazione.OPENSPACE,
                "Studio con cucina, sala pranzo, scrivania grande con più postazioni monitors",
                15,
                edificio1);
    }@Bean
    public PostazioneAziendale postazione2(Edificio edificio1){
        return new PostazioneAziendale(TipoPostazione.PRIVATO,
                "Spazio privato con scrivania e Monitor",
                1,
                edificio1);
    }@Bean
    public PostazioneAziendale postazione3(Edificio edificio2){
        return new PostazioneAziendale(TipoPostazione.PRIVATO,
                "Spazio privato con scrivania e Monitor",
                1,
                edificio2);
    }@Bean
    public PostazioneAziendale postazione4(Edificio edificio2){
        return new PostazioneAziendale(TipoPostazione.OPENSPACE,
                "Studio con cucina, sala pranzo, scrivania grande con più postazioni monitors",
                15,
                edificio2);
    }@Bean
    public PostazioneAziendale postazione5(Edificio edificio2){
        return new PostazioneAziendale(TipoPostazione.SALA_RIUNIONI,
                "Grande sala per riunioni",
                80,
                edificio2);
    }
}
