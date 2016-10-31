package com.ixxus.demo.controllers;

import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.repositories.AnimalRepository;
import com.ixxus.demo.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@RestController
public class GetAnimalsController {
    @Autowired
    private ZooService zooService;

    @RequestMapping(value = "/get")
    public List<Animal> getAllAnimals() {
        return zooService.displayAll();
    }
}
