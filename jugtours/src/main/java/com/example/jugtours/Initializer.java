package com.example.jugtours;

import com.example.jugtours.model.Event;
import com.example.jugtours.model.Group;
import com.example.jugtours.model.GroupRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {
    private final GroupRespository respository;

    public Initializer(GroupRespository respository){
        this.respository = respository;
    }

    @Override
    public void run(String... strings){
        Stream.of("Alfa JUG", "Beta JUG", "Gama JUG", "Sigma JUG").forEach(name -> respository.save(new Group(name)));

        Group ajug = respository.findByName("Alfa JUG");
        Event e = Event.builder().title("Full Android R")
                .description("Just an event")
                .date(Instant.parse("2021-08-29T18:00:00.000Z"))
                .build();
        ajug.setEvents(Collections.singleton(e));
        respository.save(ajug);

        respository.findAll().forEach(System.out::println);
    }
}
