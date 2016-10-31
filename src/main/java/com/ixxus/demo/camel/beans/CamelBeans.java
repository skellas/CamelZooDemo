package com.ixxus.demo.camel.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Configuration
public class CamelBeans {
    @Bean(name = "handler.CreateDog")
    public CreateDogHandler createDogHandler() {
        return new CreateDogHandler();
    }
    @Bean(name = "handler.CreateLion")
    public CreateLionHandler createLionHandler() {
        return new CreateLionHandler();
    }
    @Bean(name = "handler.CheckHabitat")
    public CheckHabitatHandler checkHabitatHandler() {
        return new CheckHabitatHandler();
    }
    @Bean(name = "handler.UpdateAnimalPreflight")
    public UpdateAnimalPreflightHandler updateAnimalPreflightHandler() {
        return new UpdateAnimalPreflightHandler();
    }
    @Bean(name = "handler.UpdateAnimal")
    public UpdateAnimalHandler updateAnimalHandler() {
        return new UpdateAnimalHandler();
    }

}
