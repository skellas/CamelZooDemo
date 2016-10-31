package com.ixxus.demo.camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Component
public class CreateDog extends AbstractRouteBuilder {
    public static final String ROUTE_URI = "direct:CreateDog";
    public static final String ROUTE_ID = "CreateDog";
    @Override
    public void configure() throws Exception {
        super.configure();
        from(ROUTE_URI).routeId(ROUTE_ID)
                .to("bean:handler.CreateDog")
                .to("log:CreateDog?showBody=true");
    }
}
