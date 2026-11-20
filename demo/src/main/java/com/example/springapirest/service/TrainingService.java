package com.example.springapirest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springapirest.entity.Training;
import com.example.springapirest.repository.TrainingRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TrainingService {

    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    public Optional<Training> findById(Long id) {
        return trainingRepository.findById(id);
    }

    @Transactional
    public Training create(Training training) {
        return trainingRepository.save(training);
    }

    @Transactional
    public Optional<Training> update(Long id, Training training) {
        return trainingRepository.findById(id)
                .map(existingTraining -> {
                    existingTraining.setName(training.getName());
                    existingTraining.setDescription(training.getDescription());
                    return trainingRepository.save(existingTraining);
                });

    }

    @Transactional
    public boolean delete(Long id) {
        return trainingRepository.findById(id)
                .map(training -> {
                    trainingRepository.delete(training);
                    return true;
                })
                .orElse(false);
    }
}
