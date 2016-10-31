package com.ixxus.demo.controllers;

import com.ixxus.demo.camel.routes.CreateAnimal;
import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.entities.Dog;
import com.ixxus.demo.entities.Lion;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = "/create")
public class CreateAnimalsController {

    @Produce(uri = CreateAnimal.ROUTE_URI)
    private ProducerTemplate createAnimalProducer;

    @RequestMapping(value = "/lion/{name}")
    public Animal createLion(@PathVariable final String name) {
        Objects.requireNonNull(name, "Can't create a Lion without a name.");

        Map<String, Object> headers = new HashMap<String, Object>(2);
        headers.put(Animal.PARAM_NAME, name);
        headers.put(Animal.PARAM_TYPE, Lion.TYPE);

        return createAnimal(headers);
    }

    @RequestMapping(value = "/dog/{name}")
    public Animal createDog(@PathVariable final String name) {
        Objects.requireNonNull(name, "Can't create a Dog without a name.");

        Map<String, Object> headers = new HashMap<String, Object>(2);
        headers.put(Animal.PARAM_NAME, name);
        headers.put(Animal.PARAM_TYPE, Dog.TYPE);

        return createAnimal(headers);
    }

    private Animal createAnimal(final Map<String, Object> headers) {
        Object o = createAnimalProducer.requestBodyAndHeaders(createAnimalProducer.getDefaultEndpoint(), new Object(), headers);

        Objects.requireNonNull(o, String.format("Null was returned when trying to create a %s.", headers.get(Animal.PARAM_TYPE)));
        return (Animal)o;
    }
}
