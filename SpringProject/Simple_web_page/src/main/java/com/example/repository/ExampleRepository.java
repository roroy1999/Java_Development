package com.example.repository;

import com.example.model.ExampleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExampleRepository extends CrudRepository<ExampleEntity, Long> {

    // You can add custom queries or methods here if needed
}