package com.ixxus.demo.controllers;

import com.ixxus.demo.camel.routes.CreateAnimal;
import com.ixxus.demo.camel.routes.DeleteAnimal;
import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.entities.Lion;
import com.ixxus.demo.services.ZooService;
import org.apache.camel.InvalidPropertyException;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.WebServiceException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */

@RestController
@RequestMapping(value = "/delete")
public class RemoveAnimalsController {

    @Produce(uri = DeleteAnimal.ROUTE_URI)
    private ProducerTemplate deleteAnimalProducer;

    @Autowired
    private ZooService zooService;

    @RequestMapping(value = "/{id}")
    public List<Animal> createLion(@PathVariable final Integer id) {
        Objects.requireNonNull(id, "Can't delete an animal without an ID");
        if (id > zooService.size())
            throw new BadRequestException(String.format("Animal not found for ID: %d", id));

        Object o = deleteAnimalProducer.requestBody(id);
        Objects.requireNonNull(o, String.format("Null was returned when trying to delete an animal with ID: %d.", id));

        return (List<Animal>)o;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private class BadRequestException extends RuntimeException {
        BadRequestException(final String message) {
            super(message);
        }
    }
}
