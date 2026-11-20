package com.example.springapirest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapirest.entity.Training;
import com.example.springapirest.service.TrainingService;

import java.util.List;



@RestController 
@RequestMapping ("/api/trainings")
public class TrainingController {
    
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }
    @GetMapping
    public List<Training> findAll() {
        return trainingService.findAll();
    }

    @GetMapping ("/{id}")
    public Training findById(@PathVariable Long id) {
        return trainingService.findById(id).orElseThrow(() -> new RuntimeException("Training not found"));
    }

    @PostMapping 
    public Training create(@RequestBody Training training) {
        return trainingService.create(training);
    }

    @PutMapping ("/{id}")
    public Training update(@PathVariable Long id, @RequestBody Training training) {
        return trainingService.update(id, training).orElseThrow(() -> new RuntimeException("Training not found"));
    }

    @DeleteMapping ("/{id}")
    public boolean delete(@PathVariable Long id) {
        return trainingService.delete(id);
    }


}
