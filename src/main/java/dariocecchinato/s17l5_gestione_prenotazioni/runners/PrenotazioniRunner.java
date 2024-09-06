package dariocecchinato.s17l5_gestione_prenotazioni.runners;

import dariocecchinato.s17l5_gestione_prenotazioni.Enum.TipoPostazione;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.services.PostazioniAziendaliService;
import dariocecchinato.s17l5_gestione_prenotazioni.services.PrenotazioniService;
import dariocecchinato.s17l5_gestione_prenotazioni.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
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

        //**************************** questo aggiorna le prenotazioni all' avvio*******************************
        prenotazioniService.aggiornaStatoPrenotazioni();

        Utente utente1 = utentiService.findById(UUID.fromString("05950cc9-19e6-49d2-bc6b-e054f01c815a"));
        Utente utente2 = utentiService.findById(UUID.fromString("168fa801-e41d-4050-a311-0b9ec4882ef1"));
        Utente utente3 = utentiService.findById(UUID.fromString("05950cc9-19e6-49d2-bc6b-e054f01c815a"));
        Utente utente4 = utentiService.findById(UUID.fromString("4ed698c3-6501-41bc-ae08-fd8803532f19"));
        Utente utente5 = utentiService.findById(UUID.fromString("8f98ded7-af49-40fb-a5a8-bc1c892fa970"));
        Utente utente6 = utentiService.findById(UUID.fromString("b04c8fea-65ad-4d23-8cb0-c2403c448fe1"));
        Utente utente7 = utentiService.findById(UUID.fromString("b7f85877-0232-433e-a3cd-d3f9c596985e"));

        PostazioneAziendale postazione1 =postazioniAziendaliService.findById(UUID.fromString("1ac133bc-d3ef-4c7a-a4e7-059c2fe27708"));
        PostazioneAziendale postazione2 =postazioniAziendaliService.findById(UUID.fromString("52c895b9-2d96-473c-96d1-323539ea2389"));
        PostazioneAziendale postazione3 =postazioniAziendaliService.findById(UUID.fromString("69b0a4ca-ce5d-49d4-a491-40cc0011e49a"));
        PostazioneAziendale postazione4 =postazioniAziendaliService.findById(UUID.fromString("7d302909-6ccc-4439-963d-55cc60cf70de"));
        PostazioneAziendale postazione5 =postazioniAziendaliService.findById(UUID.fromString("955f9e3a-14e6-49f8-89a9-f1639d2d296d"));
        PostazioneAziendale postazione6 =postazioniAziendaliService.findById(UUID.fromString("a8f46b8b-54f6-4b85-b7d2-16fe39298b1e"));
        PostazioneAziendale postazione7 =postazioniAziendaliService.findById(UUID.fromString("bf9d69e2-30f0-49f2-8a15-fb6924648443"));

        LocalDate dataPrenotazione1 =  LocalDate.of(2023,9, 11);
        LocalDate dataPrenotazione2 =  LocalDate.of(2024,11, 23);
        LocalDate dataPrenotazione3 =  LocalDate.of(2024,10, 15);
        LocalDate dataPrenotazione4 =  LocalDate.of(2025,1, 12);
        LocalDate dataPrenotazione5 =  LocalDate.of(2023,11, 8);
        LocalDate dataPrenotazione6 =  LocalDate.of(2020,12, 21);
        LocalDate dataPrenotazione7 =  LocalDate.of(2024,6, 20);
        LocalDate dataPrenotazione8 =  LocalDate.of(2024,3, 4);
        LocalDate dataPrenotazione9 = LocalDate.of(2024,9,8);

        try{
            prenotazioniService.creaPrenotazione(dataPrenotazione1,postazione1,utente1);
            prenotazioniService.creaPrenotazione(dataPrenotazione2,postazione2,utente2);
            prenotazioniService.creaPrenotazione(dataPrenotazione3,postazione3,utente3);
            prenotazioniService.creaPrenotazione(dataPrenotazione4,postazione4,utente4);
            prenotazioniService.creaPrenotazione(dataPrenotazione5,postazione5,utente5);
            prenotazioniService.creaPrenotazione(dataPrenotazione6,postazione6,utente6);
            prenotazioniService.creaPrenotazione(dataPrenotazione7,postazione7,utente7);
            System.out.println("Prenotazione confermata");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        System.out.println("*********************************** POSTAZIONI PER EDIFICIO E CITTA` ***********************************");
        List<PostazioneAziendale> postazionePrivatoThomasenaburgh = postazioniAziendaliService.findByTipoPostazioneAndEdificioCitta(TipoPostazione.PRIVATO,"Thomasenaburgh");
        System.out.println("Postazione Privata a Thomasenaburgh" + postazionePrivatoThomasenaburgh);


        System.out.println("*********************************** CREA PRENOTAZIONE PER RICERCA POSTAZIONE E CITTA` ***********************************");
        try {
            prenotazioniService.creaPrenotazione(dataPrenotazione9, postazionePrivatoThomasenaburgh.getFirst(), utente1);
        }catch (SavingException e){
            System.out.println(e.getMessage());
        }
    }
}
