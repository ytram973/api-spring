package com.example.springapirest.config;

import com.example.springapirest.entity.Training;
import com.example.springapirest.service.TrainingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final TrainingService trainingService;

    public DataInitializer(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (trainingService.findAll().isEmpty()) {
            trainingService.create(new Training(null, "Java", "Java Standard", 0, 1));
            trainingService.create(new Training(null, "Spring", "Création d'un projet Spring", 0, 2));
            trainingService.create(new Training(null, "Angular", "Devenez un bon Angular", 0, 3));
            trainingService.create(new Training(null, "Python", "Initiation à Python", 0, 4));
        }
    }
}