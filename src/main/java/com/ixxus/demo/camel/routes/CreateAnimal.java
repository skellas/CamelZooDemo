package com.ixxus.demo.camel.routes;

import com.ixxus.demo.entities.Animal;
import com.ixxus.demo.entities.Dog;
import com.ixxus.demo.entities.Lion;
import com.ixxus.demo.services.ZooService;
import org.apache.camel.LoggingLevel;
import org.springframework.stereotype.Component;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Component
public class CreateAnimal extends AbstractRouteBuilder {
    public static final String ROUTE_URI = "direct:CreateAnimal";
    public static final String ROUTE_ID = "CreateAnimal";
    @Override
    public void configure() throws Exception {
        super.configure();
        from(ROUTE_URI).routeId(ROUTE_ID)
                .choice()
                    .when(header(Animal.PARAM_TYPE).isEqualTo(Lion.TYPE))
                        .to(CreateLion.ROUTE_URI)
                    .when(header(Animal.PARAM_TYPE).isEqualTo(Dog.TYPE))
                        .to(CreateDog.ROUTE_URI)
                    .otherwise()
                        .log(LoggingLevel.ERROR, String.format("Not sure how to create this animal type: %s", header(Animal.PARAM_TYPE)))
                .end()
            .to("bean:handler.CheckHabitat")
            .bean(ZooService.class, "add");
    }
}
