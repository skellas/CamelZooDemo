package com.ixxus.demo.services;

import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Component
public class ZooService {
    @Autowired
    private AnimalRepository zoo;
    public Animal get(final Long animalId) {
        return zoo.findOne(animalId);
    }
    public Animal add(final Animal animal) {
        return zoo.save(animal);
    }
    public List<Animal> remove(final Long animalId) {
        zoo.delete(animalId);
        return zoo.findAll();
    }
    public Animal update(final Animal animal) {
        return zoo.save(animal);
    }
    public List<Animal> displayAll() {
        return zoo.findAll();
    }
    public Long size() {
        return zoo.count();
    }
}
