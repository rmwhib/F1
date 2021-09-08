package com.example.F1.Api.RaceDetails;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RaceConfig {

    @Bean
    CommandLineRunner commandLineRunner(RaceRepository repository){
        return args -> {

            Race uk =
                    new Race("Britian", "UK");

            Race usa =
                    new Race("US", "USA");

            repository.saveAll(List.of(uk, usa));
        };
    }
}

