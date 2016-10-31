package com.ixxus.demo.camel.beans;

import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.services.ZooService;
import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */

public class UpdateAnimalPreflightHandler {

    @Autowired
    private ZooService zooService;
    @Handler
    public void execute(@Body Animal updatedAnimal, final Exchange exchange) {
        // check that an animal exists at this id
        Long animalId = exchange.getIn().getHeader(Animal.PARAM_ID, Long.class);
        Objects.requireNonNull(animalId, String.format("ID parameter is required"));
        Animal existingAnimal = zooService.get(animalId);
        Objects.requireNonNull(existingAnimal, String.format("No Animal found for ID: %d", animalId));
        // check that we passed in an animal
        Objects.requireNonNull(updatedAnimal, String.format("No usable Animal passed in"));
        if (!Objects.equals(existingAnimal.getType(), updatedAnimal.getType())) {
            throw new NullPointerException(String.format("Cannot change Animal Type from %s to %s",
                    existingAnimal.getType().getValue(), updatedAnimal.getType().getValue()));
        }
    }
}
