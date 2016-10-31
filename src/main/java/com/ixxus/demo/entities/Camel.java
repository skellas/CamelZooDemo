package com.ixxus.demo.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Entity
@DiscriminatorValue("Camel")
public class Camel extends Animal {
    public static final AnimalType TYPE = AnimalType.forValue("Camel");
    public static final String NOISE = "I have no idea what sound a camel makes.";
    public static final HabitatType DEFAULT_HABITAT = HabitatType.DESERT;
    protected Camel() {
        super();
    }

    @JsonCreator
    protected Camel(@JsonProperty("name") final String name,
            @JsonProperty("id") final Long id,
            @JsonProperty("type") final String type,
            @JsonProperty("habitat") final String habitat) {
        super(name, id, type, habitat);
    }
    public Camel(final String name) {
        super(TYPE, name);
        setHabitat(DEFAULT_HABITAT);
    }
    @Override
    public String speak() {
        return NOISE;
    }
}
