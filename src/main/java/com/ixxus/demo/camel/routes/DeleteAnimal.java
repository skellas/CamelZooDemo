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
public class DeleteAnimal extends AbstractRouteBuilder {
    public static final String ROUTE_URI = "direct:DeleteAnimal";
    public static final String ROUTE_ID = "DeleteAnimal";
    @Override
    public void configure() throws Exception {
        super.configure();
        from(ROUTE_URI).routeId(ROUTE_ID)
            .bean(ZooService.class, "remove");
    }
}
