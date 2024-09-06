package dariocecchinato.s17l5_gestione_prenotazioni.runners;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.PostazioneAziendale;
import dariocecchinato.s17l5_gestione_prenotazioni.services.PostazioniAziendaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class PostazioniAziendaliRunner implements CommandLineRunner {
    @Autowired
    private PostazioniAziendaliService postazioniAziendaliService;
    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        PostazioneAziendale postazione1 = (PostazioneAziendale) context.getBean("postazione1");
        PostazioneAziendale postazione2 = (PostazioneAziendale) context.getBean("postazione2");
        PostazioneAziendale postazione3 = (PostazioneAziendale) context.getBean("postazione3");
        PostazioneAziendale postazione4 = (PostazioneAziendale) context.getBean("postazione4");
        PostazioneAziendale postazione5 = (PostazioneAziendale) context.getBean("postazione5");


        postazioniAziendaliService.savePostazione(postazione1);
        postazioniAziendaliService.savePostazione(postazione2);
        postazioniAziendaliService.savePostazione(postazione3);
        postazioniAziendaliService.savePostazione(postazione4);
        postazioniAziendaliService.savePostazione(postazione5);
    }


}
