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
@DiscriminatorValue("Lion")
public class Lion extends Animal {
    public static final AnimalType TYPE = AnimalType.forValue("Lion");
    public static final String NOISE = "Roar!";
    public static final HabitatType DEFAULT_HABITAT = HabitatType.SAFARI;
    protected Lion() {
        super();
    }

    @JsonCreator
    protected Lion(@JsonProperty("name") final String name,
            @JsonProperty("id") final Long id,
            @JsonProperty("type") final String type,
            @JsonProperty("habitat") final String habitat) {
        super(name, id, type, habitat);
    }
    public Lion(final String name) {
        super(TYPE, name);
        setHabitat(DEFAULT_HABITAT);
    }
    @Override
    public String speak() {
        return NOISE;
    }
}
