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
public class CreateCamel extends AbstractRouteBuilder {
    public static final String ROUTE_URI = "direct:CreateCamel";
    public static final String ROUTE_ID = "CreateCamel";
    @Override
    public void configure() throws Exception {
        super.configure();
        from(ROUTE_URI).routeId(ROUTE_ID)
                .to("bean:handler.CreateCamel")
                .to("log:CreateCamel?showBody=true");
    }
}
