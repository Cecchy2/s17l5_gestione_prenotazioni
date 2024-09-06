package dariocecchinato.s17l5_gestione_prenotazioni.runners;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import dariocecchinato.s17l5_gestione_prenotazioni.services.PostazioniAziendaliService;
import dariocecchinato.s17l5_gestione_prenotazioni.services.PrenotazioniService;
import dariocecchinato.s17l5_gestione_prenotazioni.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
@Order(4)
public class PrenotazioniRunner implements CommandLineRunner {
    @Autowired
    private PrenotazioniService prenotazioniService;
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private PostazioniAziendaliService postazioniAziendaliService;



    @Override
    public void run(String... args) throws Exception {

        Utente utente1 = utentiService.findById(UUID.fromString("05950cc9-19e6-49d2-bc6b-e054f01c815a"));

        PostazioneAziendale postazione1 =postazioniAziendaliService.findById(UUID.fromString("1ac133bc-d3ef-4c7a-a4e7-059c2fe27708"));

        /*PostazioneAziendale postazione1 = (PostazioneAziendale) context.getBean("postazione1");
        PostazioneAziendale postazione2 = (PostazioneAziendale) context.getBean("postazione2");
        PostazioneAziendale postazione3 = (PostazioneAziendale) context.getBean("postazione3");
        PostazioneAziendale postazione4 = (PostazioneAziendale) context.getBean("postazione4");
        PostazioneAziendale postazione5 = (PostazioneAziendale) context.getBean("postazione5");

        Utente utente1 = (Utente) context.getBean("utente1");
        Utente utente2 = (Utente) context.getBean("utente2");
        Utente utente3 = (Utente) context.getBean("utente3");*/

        LocalDate dataPrenotazione1 =  LocalDate.of(2024,10, 9);

        try{
            prenotazioniService.creaPrenotazione(dataPrenotazione1,postazione1,utente1);
            System.out.println("Prenotazione confermata");
        }catch (NullPointerException e){
            e.getMessage();
        }
    }
}
