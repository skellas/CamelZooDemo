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

public class UpdateAnimalHandler {

    @Autowired
    private ZooService zooService;
    @Handler
    public void execute(@Body Animal updatedAnimal, final Exchange exchange) {
        // check that an animal exists at this id
        Long animalId = exchange.getIn().getHeader(Animal.PARAM_ID, Long.class);
        final Animal existingAnimal = zooService.get(animalId);
        exchange.getOut().setBody(existingAnimal, Animal.class);
        exchange.getIn().setBody(existingAnimal.update(updatedAnimal), Animal.class);
    }
}
