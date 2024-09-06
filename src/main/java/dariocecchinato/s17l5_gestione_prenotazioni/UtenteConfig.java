package dariocecchinato.s17l5_gestione_prenotazioni;

import com.github.javafaker.Faker;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Utente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class UtenteConfig {
    Faker faker = new Faker(Locale.ITALY);

    @Bean
    public Utente utente1(){
        return new Utente(faker.name().username(),faker.name().fullName(),faker.internet().emailAddress());
    }
    @Bean
    public Utente utente2() {
        return new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
    }
    @Bean
    public Utente utente3() {
        return new Utente(faker.name().username(), faker.name().fullName(), faker.internet().emailAddress());
    }
}
