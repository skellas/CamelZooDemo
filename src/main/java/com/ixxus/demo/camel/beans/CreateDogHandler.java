package com.ixxus.demo.camel.beans;

import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.entities.Dog;
import org.apache.camel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
public class CreateDogHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateDogHandler.class);
    @Handler
    public void execute(final Exchange exchange) {
        String name = exchange.getIn().getHeader(Animal.PARAM_NAME, String.class);
        LOGGER.info(String.format("About to create a Dog named: %s", name));
        exchange.getIn().setBody(new Dog(name));
    }
}
