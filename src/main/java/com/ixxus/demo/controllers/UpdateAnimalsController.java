package com.ixxus.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ixxus.demo.camel.routes.CreateAnimal;
import com.ixxus.demo.camel.routes.UpdateAnimal;
import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.entities.Dog;
import com.ixxus.demo.entities.Lion;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RequestMapping(value = "/update")
public class UpdateAnimalsController {

    @Produce(uri = UpdateAnimal.ROUTE_URI)
    private ProducerTemplate updateAnimalProducer;

    @RequestMapping(value = "{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Animal updateAnimal(@RequestBody final Map<String, Object> body, @PathVariable final Long id) throws Exception {
        Objects.requireNonNull(id, "Can't update an Animal with an ID.");

        Map<String, Object> headers = new HashMap<String, Object>(1);
        headers.put(Animal.PARAM_ID, id);
        ObjectMapper mapper = new ObjectMapper();
        Animal animal = mapper.readValue(mapper.writeValueAsString(body), Animal.class);
        Object o = updateAnimalProducer.requestBodyAndHeaders(updateAnimalProducer.getDefaultEndpoint(), animal, headers);
        Objects.requireNonNull(o, String.format("Null was returned when trying to update Animal[id:%d]", id));
        return (Animal) o;
    }
}
