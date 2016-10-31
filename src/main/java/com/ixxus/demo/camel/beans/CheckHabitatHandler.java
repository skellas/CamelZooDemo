package com.ixxus.demo.camel.beans;

import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.entities.HabitatType;
import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
public class CheckHabitatHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckHabitatHandler.class);
    @Handler
    public void execute(@Body Animal animal, final Exchange exchange) throws Exception {
        Class animalClass = animal.getClass();
        Field defaultHabitatField = animalClass.getField("DEFAULT_HABITAT");
        HabitatType animalsDefaultHabitat = (HabitatType) defaultHabitatField.get(animal);
        if (animalsDefaultHabitat.equals(animal.getHabitat())) {
            LOGGER.info("Animal is in it's natural habitat.");
        } else {
            LOGGER.info(String.format("This animal may not like living in the %s", animal.getHabitat().getValue()));
        }
    }
}
