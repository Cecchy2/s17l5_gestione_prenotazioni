package dariocecchinato.s17l5_gestione_prenotazioni.runners;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.services.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class UtentiRunner implements CommandLineRunner {
    @Autowired
    private UtentiService utentiService;
    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Utente utente1 = (Utente) context.getBean("utente1");
        Utente utente2 = (Utente) context.getBean("utente2");
        Utente utente3 = (Utente) context.getBean("utente3");

        try{
        //utentiService.saveUtente(utente1);
        //utentiService.saveUtente(utente2);
        //utentiService.saveUtente(utente3);
    }catch (SavingException e) {
            System.out.println(e.getMessage());
        }
    }
}
