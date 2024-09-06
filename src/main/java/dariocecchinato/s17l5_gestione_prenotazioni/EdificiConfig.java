package dariocecchinato.s17l5_gestione_prenotazioni;

import com.github.javafaker.Faker;
import dariocecchinato.s17l5_gestione_prenotazioni.entities.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;


@Configuration
public class EdificiConfig {

    Faker faker = new Faker();

    @Bean
    public Edificio edificio1(){
        return new Edificio(faker.company().name(),faker.address().fullAddress(), faker.address().city());
    }
    @Bean
    public Edificio edificio2() {
        return new Edificio(faker.company().name(), faker.address().fullAddress(), faker.address().city());
    }
    @Bean
    public List<Edificio> edifici() {
        return Arrays.asList(edificio1(), edificio2());
    }

}
