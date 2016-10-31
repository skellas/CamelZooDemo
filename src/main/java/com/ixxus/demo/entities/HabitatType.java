package com.ixxus.demo.entities;

/**
 * All rights reserved.
 * Copyright (c) NIKE, Inc. 2016
 * <p>
 *
 * @author skellas, Ixxus Ltd.
 */
public enum HabitatType {
    AQUARIUM("Aquarium"),
    SAFARI("Safari"),
    SUBURBIA("Suburbia"),
    DESERT("Desert");

    private final String value;

    HabitatType(final String value) {
        this.value = value;
    }

    public static HabitatType forValue(final String _value) {
        for (HabitatType habitatType : values()) {
            if (habitatType.value.equalsIgnoreCase(_value))
                return habitatType;
        }
        throw new NullPointerException(String.format("No known HabitatType of %s", _value));
    }

    /**
     * Get value.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }
    public String toString() {
        return value;
    }
}
