package com.ixxus.demo.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType =  DiscriminatorType.STRING)
@DiscriminatorValue("Animal")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "Dog"),
        @JsonSubTypes.Type(value = Lion.class, name = "Lion")
}
)
public abstract class Animal {
    public static final String PARAM_ID = "id";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_HABITAT = "habitat";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long _id;
    @Column
    private AnimalType _type;
    @Column
    private String _name;
    @Column
    private HabitatType _habitat;

    protected Animal() {

    }
    @JsonCreator
    protected Animal(@JsonProperty("name") final String name,
            @JsonProperty("id") final Long id,
            @JsonProperty("type") final String type,
            @JsonProperty("habitat") final String habitat) {
        _name = name;
        _id = id;
        _type = AnimalType.forValue(type);
        _habitat = HabitatType.forValue(habitat);
    }
    public Animal(final AnimalType type, final String name) {
        _type = type;
        _name = name;
    }

    public abstract String speak();
    /**
     * Get _type.
     *
     * @return _type
     */
    public AnimalType getType() {
        return _type;
    }

    /**
     * Get _name.
     *
     * @return _name
     */
    public String getName() {
        return _name;
    }

    /**
     * Get _habitat.
     *
     * @return _habitat
     */
    public HabitatType getHabitat() {
        return _habitat;
    }

    public Animal setHabitat(HabitatType _habitat) {
        this._habitat = _habitat;
        return this;
    }

    public Animal update(Animal updatedAnimal) {
        this._name = updatedAnimal.getName();
        this._habitat = updatedAnimal.getHabitat();
        return this;
    }
    /**
     * Get _id.
     *
     * @return _id
     */
    public Long getId() {
        return _id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + getId() + '\'' +
                ",_type='" + getType() + '\'' +
                ", _name='" + getName() + '\'' +
                ", _habitat='" + getHabitat() + '\'' +
                ", says()='" + speak() + '\'' +
                '}';
    }
}
