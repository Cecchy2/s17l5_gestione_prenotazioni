package dariocecchinato.s17l5_gestione_prenotazioni.runners;

import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import dariocecchinato.s17l5_gestione_prenotazioni.exceptions.SavingException;
import dariocecchinato.s17l5_gestione_prenotazioni.services.EdificiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class EdificiRunner implements CommandLineRunner {
    @Autowired
    private EdificiService edificiService;
    @Autowired
    private ApplicationContext context;


    @Override
    public void run(String... args) throws Exception {

        Edificio edificio1 = (Edificio) context.getBean("edificio1");
        Edificio edificio2 = (Edificio) context.getBean("edificio2");

        try {
            //edificiService.saveEdificio(edificio1);
            //edificiService.saveEdificio(edificio2);
        }catch (SavingException e){
            System.out.println(e.getMessage());
        }
    }
}
