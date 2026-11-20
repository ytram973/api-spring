package com.example.springapirest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapirest.entity.Training;

public interface TrainingRepository extends JpaRepository<Training, Long> {

}
