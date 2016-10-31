package com.ixxus.demo.camel.routes;

import org.springframework.stereotype.Component;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Component
public class CreateLion extends AbstractRouteBuilder {
    public static final String ROUTE_URI = "direct:CreateLion";
    public static final String ROUTE_ID = "CreateLion";
    @Override
    public void configure() throws Exception {
        super.configure();
        from(ROUTE_URI).routeId(ROUTE_ID)
                .to("bean:handler.CreateLion")
                .to("log:CreateLion?showBody=true");
    }
}
